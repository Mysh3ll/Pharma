package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisiteurDetailsFragment extends Fragment {
    // the fragment initialization parameters, e.g. VIS_MAT
    private static final String VIS_MAT = "vis_mat";

    private Visiteur visiteur;

    public VisiteurDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param vis_mat Matricule du visiteur.
     * @return A new instance of fragment VisiteurDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisiteurDetailsFragment newInstance(String vis_mat) {
        VisiteurDetailsFragment fragment = new VisiteurDetailsFragment();
        Bundle args = new Bundle();
        args.putString(VIS_MAT, vis_mat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mVis_mat = getArguments().getString(VIS_MAT);
            //Récupération du visiteur sélectionné
            VisiteurDAO visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            visiteur = visiteurDAO.getByVisMat(mVis_mat);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_visiteur_details, container, false);

        //Autocomplétion des champs
        TextView etVisiteurNom = (TextView) view.findViewById(R.id.etVisiteurNom);
        TextView etVisiteurPrenom = (TextView) view.findViewById(R.id.etVisiteurPrenom);
        TextView etVisiteurAdresse = (TextView) view.findViewById(R.id.etVisiteurAdresse);
        TextView etVisiteurCP = (TextView) view.findViewById(R.id.etVisiteurCP);
        TextView etVisiteurVille = (TextView) view.findViewById(R.id.etVisiteurVille);

        etVisiteurNom.setText(visiteur.getVisNom());
        etVisiteurNom.setEnabled(false);
        etVisiteurPrenom.setText(visiteur.getVisPrenom());
        etVisiteurPrenom.setEnabled(false);
        etVisiteurAdresse.setText(visiteur.getVisAdresse());
        etVisiteurAdresse.setEnabled(false);
        etVisiteurCP.setText(visiteur.getVisCp().toString());
        etVisiteurCP.setEnabled(false);
        etVisiteurVille.setText(visiteur.getVisVille());
        etVisiteurVille.setEnabled(false);

        return view;
    }

}
