package fr.btssio.pharma.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisiteurProfilFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisiteurProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisiteurProfilFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "vis_mat";

    private String mVis_mat;

    private OnFragmentInteractionListener mListener;
    private VisiteurDAO visiteurDAO;
    private Visiteur visiteur;

    private TextView etVisiteurNom, etVisiteurPrenom, etVisiteurAdresse, etVisiteurCP, etVisiteurVille;

    public VisiteurProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param vis_mat Matricule du visiteur.
     * @return A new instance of fragment VisiteurProfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisiteurProfilFragment newInstance(String vis_mat) {
        VisiteurProfilFragment fragment = new VisiteurProfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, vis_mat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVis_mat = getArguments().getString(ARG_PARAM1);
            //Récupération du visiteur connecté
            visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            visiteur = visiteurDAO.getByVisMat(mVis_mat);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_visiteur_profil, container, false);

        //Autocomplétion des champs
        etVisiteurNom = (TextView) view.findViewById(R.id.etVisiteurNom);
        etVisiteurPrenom = (TextView) view.findViewById(R.id.etVisiteurPrenom);
        etVisiteurAdresse = (TextView) view.findViewById(R.id.etVisiteurAdresse);
        etVisiteurCP = (TextView) view.findViewById(R.id.etVisiteurCP);
        etVisiteurVille = (TextView) view.findViewById(R.id.etVisiteurVille);

        etVisiteurNom.setText(visiteur.getVisNom());
        etVisiteurNom.setEnabled(false);
        etVisiteurPrenom.setText(visiteur.getVisPrenom());
        etVisiteurPrenom.setEnabled(false);
        etVisiteurAdresse.setText(visiteur.getVisAdresse());
        etVisiteurAdresse.requestFocus();
        etVisiteurCP.setText(visiteur.getVisCp().toString());
        etVisiteurVille.setText(visiteur.getVisVille());

        //Affichage du boutton "mise à jour"
        Button btnProfil = (Button) view.findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Contrôle des champs saisis
                boolean error = false;

                if (TextUtils.isEmpty(getVisiteurAdresse())) {
                    error = true;
                    Toast.makeText(getContext(), "Veuillez renter une adresse.", Toast.LENGTH_LONG).show();
                    etVisiteurAdresse.requestFocus();
                } else if (TextUtils.isEmpty(getVisiteurCP())) {
                    error = true;
                    Toast.makeText(getContext(), "Veuillez renter un code postal.", Toast.LENGTH_LONG).show();
                    etVisiteurCP.requestFocus();
                } else if (TextUtils.isEmpty(getVisiteurVille())) {
                    error = true;
                    Toast.makeText(getContext(), "Veuillez renter une ville.", Toast.LENGTH_LONG).show();
                    etVisiteurVille.requestFocus();
                }

                if (!error) {
                    //Update du visiteur en BDD
                    visiteur.setVisAdresse(getVisiteurAdresse());
                    visiteur.setVisCp(Integer.valueOf(getVisiteurCP()));
                    visiteur.setVisVille(getVisiteurVille());
                    visiteurDAO.update(visiteur);
                    Toast.makeText(getContext(), "Mise à jour effectuée avec succès.", Toast.LENGTH_LONG).show();

                    //Load fragment_main
                    MainFragment mainFragment = new MainFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction()
                            .replace(
                                    R.id.constraintlayout_for_fragment,
                                    mainFragment,
                                    mainFragment.getTag()
                            ).commit();
                }

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private String getVisiteurAdresse() {
        return etVisiteurAdresse.getText().toString().trim();
    }

    private String getVisiteurCP() {
        return etVisiteurCP.getText().toString().trim();
    }

    private String getVisiteurVille() {
        return etVisiteurVille.getText().toString().trim();
    }

}
