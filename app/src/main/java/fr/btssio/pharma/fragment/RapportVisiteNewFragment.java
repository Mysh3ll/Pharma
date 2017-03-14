package fr.btssio.pharma.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
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
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.orm.runtime.query.OrderByDirection;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class RapportVisiteNewFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    // the fragment initialization parameters, e.g. VIS_MAT
    private static final String VIS_MAT = "vis_mat";

    EditText etRapportVisiteDate;
    TextView etRapportVisitebilan;
    Spinner spinnerMotif, spinnerPraticien, spinnerMedicament, spinnerQuantite;
    String selectedMotif, selectedPraticien, selectedMedicament, selectedQuantite;
    int positionSelectedPraticien, positionSelectedMedicament;
    private Visiteur visiteur;

    // Variables for text watcher
    private String current = "";
    private String ddmmyyyy = "DDMMYYYY";
    private Calendar cal = Calendar.getInstance();

    public RapportVisiteNewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param vis_mat Matricule du visiteur.
     * @return A new instance of fragment RapportVisiteNewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RapportVisiteNewFragment newInstance(String vis_mat) {
        RapportVisiteNewFragment fragment = new RapportVisiteNewFragment();
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
            //Récupération du visiteur connecté
            VisiteurDAOImpl visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            visiteur = visiteurDAO.getByVisMat(mVis_mat);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.fragment_rapport_visite_new, container, false);

        etRapportVisiteDate = (EditText) view.findViewById(R.id.etRapportVisiteDate);
        // Text watcher for DD-MM-YYYY
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day = Integer.parseInt(clean.substring(0, 2));
                        int mon = Integer.parseInt(clean.substring(2, 4));
                        int year = Integer.parseInt(clean.substring(4, 8));

                        if (mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon - 1);
                        year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
                        clean = String.format("%02d%02d%02d", day, mon, year);
                    }

                    clean = String.format("%s-%s-%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    etRapportVisiteDate.setText(current);
                    etRapportVisiteDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        etRapportVisiteDate.addTextChangedListener(tw);

        etRapportVisitebilan = (TextView) view.findViewById(R.id.etRapportVisitebilan);

        // Spinner rapport visite motif
        spinnerMotif = (Spinner) view.findViewById(R.id.spRapportVisiteMotif);
        // Spinner click listener
        spinnerMotif.setOnItemSelectedListener(this);

        // Spinner rapport visite praticien
        spinnerPraticien = (Spinner) view.findViewById(R.id.spRapportVisitePraticien);
        // Récupération des praticiens en BDD
        PraticienDAO praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
        List<Praticien> praticiens = praticienDAO.getPraticienList(PraticienDAO.PRA_NOM, OrderByDirection.ASC);
        // Création de la liste pour le spinnerPraticien
        List<String> prat_list = new ArrayList<>();
        for (Praticien praticien :
                praticiens) {
            prat_list.add(praticien.getPraNom() + " " + praticien.getPraPrenom());
        }
        // Creating adapter for spinner
        ArrayAdapter<String> praticienAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, prat_list);
        // Drop down layout style - list view with radio button
        praticienAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Spinner click listener
        spinnerPraticien.setOnItemSelectedListener(this);
        // attaching data adapter to spinnerPraticien
        spinnerPraticien.setAdapter(praticienAdapter);

        // Spinner rapport visite médicament
        spinnerMedicament = (Spinner) view.findViewById(R.id.spRapportVisiteMedicament);
        // Récupération des médicaments en BDD
        MedicamentDAO medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
        List<Medicament> medicaments = medicamentDAO.getMedicamentList(MedicamentDAO.MED_NOMCOM, OrderByDirection.ASC);
        // Création de la liste pour le spinnerMedicament
        List<String> med_list = new ArrayList<>();
        for (Medicament medicament :
                medicaments) {
            med_list.add(medicament.getMedNomcom());
        }
        // Creating adapter for spinner
        ArrayAdapter<String> medicamentAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, med_list);
        // Drop down layout style - list view with radio button
        medicamentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Spinner click listener
        spinnerMedicament.setOnItemSelectedListener(this);
        // attaching data adapter to spinnerMedicament
        spinnerMedicament.setAdapter(medicamentAdapter);

        // Spinner rapport visite médicament quantité
        spinnerQuantite = (Spinner) view.findViewById(R.id.spRapportVisiteQuantite);
        // Spinner click listener
        spinnerQuantite.setOnItemSelectedListener(this);

        // Validation du nouveau rapport
        Button btnValider = (Button) view.findViewById(R.id.btnRapportVisite);

        btnValider.setOnClickListener(this);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spRapportVisiteMotif) {
            // On selecting a spinner item
            selectedMotif = parent.getItemAtPosition(position).toString();

        } else if (parent.getId() == R.id.spRapportVisitePraticien) {
            selectedPraticien = parent.getItemAtPosition(position).toString();
            positionSelectedPraticien = position;

        } else if (parent.getId() == R.id.spRapportVisiteQuantite) {
            selectedQuantite = parent.getItemAtPosition(position).toString();

        } else if (parent.getId() == R.id.spRapportVisiteMedicament) {
            selectedMedicament = parent.getItemAtPosition(position).toString();
            positionSelectedMedicament = position;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        RapportVisite rapportVisite;
        RapportVisiteDAO rapportVisiteDAO = new RapportVisiteDAOImpl(new PharmaSQLiteOpenHelper(getContext()));

        // Récupération de la valeur des champs
        boolean error = false;

        if (TextUtils.isEmpty(getRapportVisiteDate())) {
            error = true;
            Toast.makeText(getContext(), "Veuillez renter une date.", Toast.LENGTH_LONG).show();
            etRapportVisiteDate.requestFocus();
        } else if (TextUtils.isEmpty(getRapportVisiteBilan())) {
            error = true;
            Toast.makeText(getContext(), "Veuillez renter un motif.", Toast.LENGTH_LONG).show();
            etRapportVisitebilan.requestFocus();
        }

        if (!error) {
            // Récupération du Praticien
            PraticienDAOImpl praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
            List<Praticien> praticiens = praticienDAO.getPraticienList(PraticienDAO.PRA_NOM, OrderByDirection.ASC);
            int pra_num = praticiens.get(positionSelectedPraticien).getPraNum();
            Praticien praticien = praticienDAO.getByPraNum(pra_num);

            // Création du rapport de visite
            rapportVisite = new RapportVisite();
            rapportVisite.setRapDate(getRapportVisiteDate());
            rapportVisite.setRapMotif(selectedMotif);
            rapportVisite.setRapBilan(getRapportVisiteBilan());
            rapportVisite.setVisiteurVisMat(visiteur.getVisMat());
            rapportVisite.setPraticienPraNum(praticien.getPraNum());

            // Insertion du rapport de visite en BDD
            rapportVisiteDAO.insert(rapportVisite);

            // Récupération du médicament
            if (Integer.valueOf(selectedQuantite) > 0) {
                MedicamentDAOImpl medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
                List<Medicament> medicaments = medicamentDAO.getMedicamentList(MedicamentDAO.MED_NOMCOM, OrderByDirection.ASC);
                String med_depot_legal = medicaments.get(positionSelectedMedicament).getMedDepotlegal();
                Medicament medicament = medicamentDAO.getByMedDepotlegal(med_depot_legal);

                // Ajout du médicament offert en BDD
                OffrirDAO offrirDAO = new OffrirDAOImpl(new PharmaSQLiteOpenHelper(getContext()));
                Offrir offrir = new Offrir();
                offrir.setOffQte(Integer.valueOf(selectedQuantite));
                offrir.setMedicamentMedDepotlegal(medicament.getMedDepotlegal());
                offrir.setRapportVisiteRapNum(rapportVisite.getRapNum());

                // Insertion du médicament offert en BDD
                offrirDAO.insert(offrir);

            }

            Toast.makeText(getContext(), "Rapport de visite ajouté avec succès.", Toast.LENGTH_LONG).show();
            FragmentManager manager = getFragmentManager();
            manager.popBackStack();

        }
    }

    private String getRapportVisiteDate() {
        return etRapportVisiteDate.getText().toString().trim();
    }

    private String getRapportVisiteBilan() {
        return etRapportVisitebilan.getText().toString().trim();
    }


}


