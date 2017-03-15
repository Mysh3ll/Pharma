package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.gen.Medicament;
import fr.btssio.pharma.orm.gen.MedicamentDAO;
import fr.btssio.pharma.orm.gen.MedicamentDAOImpl;
import fr.btssio.pharma.orm.gen.Offrir;
import fr.btssio.pharma.orm.gen.OffrirDAO;
import fr.btssio.pharma.orm.gen.OffrirDAOImpl;
import fr.btssio.pharma.orm.gen.Praticien;
import fr.btssio.pharma.orm.gen.PraticienDAO;
import fr.btssio.pharma.orm.gen.PraticienDAOImpl;
import fr.btssio.pharma.orm.gen.RapportVisite;
import fr.btssio.pharma.orm.gen.RapportVisiteDAO;
import fr.btssio.pharma.orm.gen.RapportVisiteDAOImpl;
import fr.btssio.pharma.orm.runtime.query.OrderByDirection;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class RapportVisiteDetailsFragment extends Fragment {
    // the fragment initialization parameters, e.g. RAP_NUM
    private static final String RAP_NUM = "rap_num";

    private RapportVisite rapportVisite;

    public RapportVisiteDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param rap_num Numéro du rapport de visite.
     * @return A new instance of fragment RapportVisiteDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RapportVisiteDetailsFragment newInstance(int rap_num) {
        RapportVisiteDetailsFragment fragment = new RapportVisiteDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(RAP_NUM, rap_num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int mRap_num = getArguments().getInt(RAP_NUM);
            //Récupération du rapport sélectionné
            RapportVisiteDAO rapportVisiteDAO = new RapportVisiteDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            rapportVisite = rapportVisiteDAO.getByRapNum(mRap_num);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_rapport_visite_details, container, false);

        //Autocomplétion des champs
        TextView etRapportVisteNum = (TextView) view.findViewById(R.id.etRapportVisteNum);
        TextView etRapportVisteDate = (TextView) view.findViewById(R.id.etRapportVisteDate);
        TextView etRapportVisteMotif = (TextView) view.findViewById(R.id.etRapportVisteMotif);
        TextView etRapportVisteBilan = (TextView) view.findViewById(R.id.etRapportVisteBilan);
        TextView etRapportVistePraticien = (TextView) view.findViewById(R.id.etRapportVistePraticien);
        TextView etRapportVisteMedicament = (TextView) view.findViewById(R.id.etRapportVisteMedicament);
        TextView etRapportVisteQuantite = (TextView) view.findViewById(R.id.etRapportVisteQuantite);

        etRapportVisteNum.setText(rapportVisite.getRapNum().toString());
        etRapportVisteDate.setText(rapportVisite.getRapDate());
        etRapportVisteMotif.setText(rapportVisite.getRapMotif());
        etRapportVisteBilan.setText(rapportVisite.getRapBilan());
        // Récupération du praticien concerné par le rapport de visite
        PraticienDAO praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
        Praticien praticien = praticienDAO.getByPraNum(rapportVisite.getPraticienPraNum());
        etRapportVistePraticien.setText(praticien.getPraNom() + " " + praticien.getPraPrenom());
        // Récupération du médicament offert
        OffrirDAO offrirDAO = new OffrirDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
        List<Offrir> offrir = offrirDAO.getOffrirList(OffrirDAO.RAPPORT_VISITE_RAP_NUM.eq(rapportVisite.getRapNum()));
        if (offrir.size() > 0) {
            MedicamentDAO medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            Medicament medicament = medicamentDAO.getByMedDepotlegal(offrir.get(0).getMedicamentMedDepotlegal());
            etRapportVisteMedicament.setText(medicament.getMedNomcom());
            etRapportVisteQuantite.setText(offrir.get(0).getOffQte().toString());
        } else {
            etRapportVisteMedicament.setText("Aucun");
            etRapportVisteQuantite.setText("Aucune");
        }

        etRapportVisteNum.setEnabled(false);
        etRapportVisteDate.setEnabled(false);
        etRapportVisteMotif.setEnabled(false);
        etRapportVisteBilan.setEnabled(false);
        etRapportVistePraticien.setEnabled(false);
        etRapportVisteMedicament.setEnabled(false);
        etRapportVisteQuantite.setEnabled(false);

        return view;
    }

}
