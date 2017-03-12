package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.Medicament;
import fr.btssio.pharma.orm.gen.MedicamentDAO;
import fr.btssio.pharma.orm.gen.MedicamentDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicamentDetailsFragment extends Fragment {
    // the fragment initialization parameters, e.g. MED_DEPOT_LEGAL
    private static final String MED_DEPOT_LEGAL = "med_depot_legal";

    private Medicament medicament;

    public MedicamentDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param med_depot_legal Code du dépôt légal du médicament.
     * @return A new instance of fragment MedicamentDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicamentDetailsFragment newInstance(String med_depot_legal) {
        MedicamentDetailsFragment fragment = new MedicamentDetailsFragment();
        Bundle args = new Bundle();
        args.putString(MED_DEPOT_LEGAL, med_depot_legal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mMed_depot_legal = getArguments().getString(MED_DEPOT_LEGAL);
            //Récupération du médicament sélectionné
            MedicamentDAO medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            medicament = medicamentDAO.getByMedDepotlegal(mMed_depot_legal);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_medicament_details, container, false);

        //Autocomplétion des champs
        TextView etMedicamentDepotLegal = (TextView) view.findViewById(R.id.etMedicamentDepotLegal);
        TextView etMedicamentNom = (TextView) view.findViewById(R.id.etMedicamentNom);
        TextView etMedicamentComposition = (TextView) view.findViewById(R.id.etMedicamentComposition);
        TextView etMedicamentEffet = (TextView) view.findViewById(R.id.etMedicamentEffet);
        TextView etMedicamentContreIndication = (TextView) view.findViewById(R.id.etMedicamentContreIndication);

        etMedicamentDepotLegal.setText(medicament.getMedDepotlegal());
        etMedicamentDepotLegal.setEnabled(false);
        etMedicamentNom.setText(medicament.getMedNomcom());
        etMedicamentNom.setEnabled(false);
        etMedicamentComposition.setText(medicament.getMedCompo());
        etMedicamentComposition.setEnabled(false);
        etMedicamentEffet.setText(medicament.getMedEffets());
        etMedicamentEffet.setEnabled(false);
        etMedicamentContreIndication.setText(medicament.getMedContreind());
        etMedicamentContreIndication.setEnabled(false);

        return view;
    }

}
