package fr.btssio.pharma;

import android.app.Fragment;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.List;

import fr.btssio.pharma.fragment.FamilleFragment;
import fr.btssio.pharma.fragment.MedicamentDetailsFragment;
import fr.btssio.pharma.fragment.MedicamentFragment;
import fr.btssio.pharma.fragment.PraticienDetailsFragment;
import fr.btssio.pharma.fragment.PraticienFragment;
import fr.btssio.pharma.fragment.RapportVisiteDetailsFragment;
import fr.btssio.pharma.fragment.RapportVisiteFragment;
import fr.btssio.pharma.fragment.VisiteurDetailsFragment;
import fr.btssio.pharma.fragment.VisiteurFragment;
import fr.btssio.pharma.fragment.VisiteurProfilFragment;
import fr.btssio.pharma.orm.gen.Famille;
import fr.btssio.pharma.orm.gen.Medicament;
import fr.btssio.pharma.orm.gen.MedicamentDAO;
import fr.btssio.pharma.orm.gen.MedicamentDAOImpl;
import fr.btssio.pharma.orm.gen.Praticien;
import fr.btssio.pharma.orm.gen.PraticienDAO;
import fr.btssio.pharma.orm.gen.PraticienDAOImpl;
import fr.btssio.pharma.orm.gen.RapportVisite;
import fr.btssio.pharma.orm.gen.RapportVisiteDAO;
import fr.btssio.pharma.orm.gen.RapportVisiteDAOImpl;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.fragment.MainFragment;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;
import layout.MapFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        VisiteurFragment.OnListFragmentInteractionListener,
        PraticienFragment.OnListFragmentInteractionListener,
        VisiteurProfilFragment.OnFragmentInteractionListener,
        FamilleFragment.OnListFragmentInteractionListener,
        MedicamentFragment.OnListFragmentInteractionListener,
        RapportVisiteFragment.OnListFragmentInteractionListener,
        OnMapReadyCallback {

    private static final String FAM_CODE = "fam_code";
    boolean doubleBackToExitPressedOnce = false;
    private String vis_mat;

    // Badge navigation drawer
    TextView baCompteRendu, baVisiteur, baPraticien, baMedicament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Get view of badges
        baCompteRendu = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_compte_rendu));
        baVisiteur = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_visiteur));
        baPraticien = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_praticien));
        baMedicament = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().findItem(R.id.nav_medicament));

        // This method will initialize the count value
        initializeCountDrawer();

        //Récupération du visiteur connecté
        vis_mat = getIntent().getExtras().getString("vis_mat");

        //Load fragment_main
        MainFragment mainFragment = MainFragment.newInstance(vis_mat);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .addToBackStack("main")
                .replace(
                        R.id.constraintlayout_for_fragment,
                        mainFragment,
                        mainFragment.getTag()
                ).commit();

    }

    @Override
    public void onBackPressed() {
        String mainFragment = "main";
        //Listener for back button on Fragment
        FragmentManager fm = getSupportFragmentManager();
        int nb = fm.getBackStackEntryCount();

        if (fm.getBackStackEntryCount() > 0) { // back to the parent (fragment)
            String fragmentTag = fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName(); // name of the top stack fragment

            if (fragmentTag != null) {
                switch (fragmentTag) {
                    case "compte_rendu":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    case "visiteur":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    case "praticien":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    case "medicament":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    case "profil":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    case "map":
                        fm.popBackStack(mainFragment, 0);
                        setTitle("Pharma");
                        break;
                    default:
                        break;
                }
            } else {
                fm.popBackStack();
            }

            if (fm.getBackStackEntryCount() == 1) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                } else {
                    if (doubleBackToExitPressedOnce) {
                        finish();
                    }
                    this.doubleBackToExitPressedOnce = true;
                    Toast.makeText(this, "Appuyer deux fois pour quitter", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, 2000);
                }
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_compte_rendu) {
            RapportVisiteFragment rapportVisiteFragment = RapportVisiteFragment.newInstance(1, vis_mat);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("compte_rendu")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            rapportVisiteFragment,
                            rapportVisiteFragment.getTag()
                    ).commit();
        } else if (id == R.id.nav_visiteur) {
            VisiteurFragment visiteurFragment = VisiteurFragment.newInstance(1);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("visiteur")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            visiteurFragment,
                            visiteurFragment.getTag()
                    ).commit();
        } else if (id == R.id.nav_praticien) {
            PraticienFragment praticienFragment = PraticienFragment.newInstance(1);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("praticien")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            praticienFragment,
                            praticienFragment.getTag()
                    ).commit();
        } else if (id == R.id.nav_medicament) {
            FamilleFragment familleFragment = FamilleFragment.newInstance(1);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("medicament")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            familleFragment,
                            familleFragment.getTag()
                    ).commit();
        } else if (id == R.id.nav_profil) {
            VisiteurProfilFragment visiteurProfilFragment = VisiteurProfilFragment.newInstance(vis_mat);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("profil")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            visiteurProfilFragment,
                            visiteurProfilFragment.getTag()
                    ).commit();
        } else if (id == R.id.nav_map) {
            MapFragment mapFragment = MapFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .addToBackStack("map")
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            mapFragment,
                            mapFragment.getTag()
                    ).commit();

            mapFragment.getMapAsync(this);
        }

        // Set action bar title
        setTitle(item.getTitle());
        // Close the navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Visiteur visiteur) {
        VisiteurDetailsFragment visiteurDetailsFragment = VisiteurDetailsFragment.newInstance(visiteur.getVisMat());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        visiteurDetailsFragment,
                        visiteurDetailsFragment.getTag()
                ).commit();
//        Toast.makeText(getApplicationContext(), visiteur.getVisMat(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(Praticien praticien) {
        PraticienDetailsFragment praticienDetailsFragment = PraticienDetailsFragment.newInstance(praticien.getPraNum());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        praticienDetailsFragment,
                        praticienDetailsFragment.getTag()
                ).commit();
//        Toast.makeText(getApplicationContext(), praticien.getPraNum().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(Famille famille) {
        MedicamentFragment medicamentFragment = MedicamentFragment.newInstance(1, famille.getFamCode());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        medicamentFragment,
                        medicamentFragment.getTag()
                ).commit();
//        Toast.makeText(getApplicationContext(), famille.getFamCode().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(Medicament medicament) {
        MedicamentDetailsFragment medicamentDetailsFragment = MedicamentDetailsFragment.newInstance(medicament.getMedDepotlegal());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        medicamentDetailsFragment,
                        medicamentDetailsFragment.getTag()
                ).commit();
    }

    @Override
    public void onListFragmentInteraction(RapportVisite rapportVisite) {
        RapportVisiteDetailsFragment rapportVisiteDetailsFragment = RapportVisiteDetailsFragment.newInstance(rapportVisite.getRapNum());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                .addToBackStack(null)
                .replace(
                        R.id.constraintlayout_for_fragment,
                        rapportVisiteDetailsFragment,
                        rapportVisiteDetailsFragment.getTag()
                ).commit();
//        Toast.makeText(getApplicationContext(), rapportVisite.getRapNum().toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    private void initializeCountDrawer() {
        // Compte Rendu
        RapportVisiteDAO rapportVisiteDAO = new RapportVisiteDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
        List<RapportVisite> rapportVisites = rapportVisiteDAO.getRapportVisiteList();
        int countRapportVisite = rapportVisites.size();
        baCompteRendu.setGravity(Gravity.CENTER_VERTICAL);
        baCompteRendu.setTypeface(null, Typeface.BOLD);
        baCompteRendu.setTextColor(getResources().getColor(R.color.colorAccent));
        baCompteRendu.setText(String.valueOf(countRapportVisite));

        // Visiteur
        VisiteurDAO visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
        List<Visiteur> visiteurs = visiteurDAO.getVisiteurList();
        int countVisiteur = visiteurs.size();
        baVisiteur.setGravity(Gravity.CENTER_VERTICAL);
        baVisiteur.setTypeface(null, Typeface.BOLD);
        baVisiteur.setTextColor(getResources().getColor(R.color.colorAccent));
        baVisiteur.setText(String.valueOf(countVisiteur));

        // Praticien
        PraticienDAO praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
        List<Praticien> praticiens = praticienDAO.getPraticienList();
        int countPraticien = praticiens.size();
        baPraticien.setGravity(Gravity.CENTER_VERTICAL);
        baPraticien.setTypeface(null, Typeface.BOLD);
        baPraticien.setTextColor(getResources().getColor(R.color.colorAccent));
        baPraticien.setText(String.valueOf(countPraticien));

        // Médicaments
        MedicamentDAO medicamentDAO = new MedicamentDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
        List<Medicament> medicaments = medicamentDAO.getMedicamentList();
        int countMedicament = medicaments.size();
        baMedicament.setGravity(Gravity.CENTER_VERTICAL);
        baMedicament.setTypeface(null, Typeface.BOLD);
        baMedicament.setTextColor(getResources().getColor(R.color.colorAccent));
        baMedicament.setText(String.valueOf(countMedicament));

    }

}
