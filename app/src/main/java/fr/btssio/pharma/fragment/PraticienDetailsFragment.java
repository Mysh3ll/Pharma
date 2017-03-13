package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.Praticien;
import fr.btssio.pharma.orm.gen.PraticienDAO;
import fr.btssio.pharma.orm.gen.PraticienDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class PraticienDetailsFragment extends Fragment {
    // the fragment initialization parameters, e.g. PRA_NUM
    private static final String PRA_NUM = "pra_num";

    private Praticien praticien;

    public PraticienDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pra_num Numéro du praticien.
     * @return A new instance of fragment PraticienDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PraticienDetailsFragment newInstance(int pra_num) {
        PraticienDetailsFragment fragment = new PraticienDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(PRA_NUM, pra_num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int mPra_num = getArguments().getInt(PRA_NUM);
            //Récupération du praticien sélectionné
            PraticienDAO praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            praticien = praticienDAO.getByPraNum(mPra_num);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_praticien_details, container, false);

        //Autocomplétion des champs
        TextView etPraticienNom = (TextView) view.findViewById(R.id.etPraticienNom);
        TextView etPraticienPrenom = (TextView) view.findViewById(R.id.etPraticienPrenom);
        TextView etPraticienAdresse = (TextView) view.findViewById(R.id.etPraticienAdresse);
        TextView etPraticienCP = (TextView) view.findViewById(R.id.etPraticienCP);
        TextView etPraticienVille = (TextView) view.findViewById(R.id.etPraticienVille);
        TextView etPraticienCoef = (TextView) view.findViewById(R.id.etPraticienCoef);

        etPraticienNom.setText(praticien.getPraNom());
        etPraticienNom.setEnabled(false);
        etPraticienPrenom.setText(praticien.getPraPrenom());
        etPraticienPrenom.setEnabled(false);
        etPraticienAdresse.setText(praticien.getPraAdresse());
        etPraticienAdresse.setEnabled(false);
        etPraticienCP.setText(praticien.getPraCp().toString());
        etPraticienCP.setEnabled(false);
        etPraticienVille.setText(praticien.getPraVille());
        etPraticienVille.setEnabled(false);
        etPraticienCoef.setText(praticien.getPraCoef().toString());
        etPraticienCoef.setEnabled(false);

        return view;
    }

}
