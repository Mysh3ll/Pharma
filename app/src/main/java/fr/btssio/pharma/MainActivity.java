package fr.btssio.pharma;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

import fr.btssio.pharma.fragment.PraticienFragment;
import fr.btssio.pharma.fragment.VisiteurFragment;
import fr.btssio.pharma.fragment.VisiteurProfilFragment;
import fr.btssio.pharma.orm.gen.Praticien;
import fr.btssio.pharma.orm.gen.PraticienDAO;
import fr.btssio.pharma.orm.gen.PraticienDAOImpl;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.orm.runtime.util.SimpleSQLiteOpenHelper;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

import static fr.btssio.pharma.orm.gen.PraticienDAO.PRA_NUM;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        VisiteurFragment.OnListFragmentInteractionListener,
        PraticienFragment.OnListFragmentInteractionListener, VisiteurProfilFragment.OnFragmentInteractionListener {

    private VisiteurDAO visiteurDAO;
    private TextView tvVisiteurNom, tvVisiteurPrenom;
    boolean doubleBackToExitPressedOnce = false;
    private String vis_mat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //---------------------- INSERT VISITEUR ------------------------------------//
//        SimpleSQLiteOpenHelper helper = new PharmaSQLiteOpenHelper(this.getApplicationContext());
//        VisiteurDAO visiteurDAO = new VisiteurDAOImpl(helper);
//
//        Visiteur michel = new Visiteur();
//        michel.setVisMat("mic64");
//        michel.setVisNom("Pompas");
//        michel.setVisPrenom("Michel");
//        michel.setVisAdresse("9 rue d'iraty");
//        michel.setVisCp(64510);
//        michel.setVisVille("Bordes");
//        michel.setVisDateemb("10-mar-17");
//
//        Visiteur arnaud = new Visiteur();
//        arnaud.setVisMat("arn64");
//        arnaud.setVisNom("Ayrem");
//        arnaud.setVisPrenom("Arnaud");
//        arnaud.setVisAdresse("10 rue des lilas");
//        arnaud.setVisCp(64000);
//        arnaud.setVisVille("Pau");
//        arnaud.setVisDateemb("10-jan-17");
//
//        Visiteur alison = new Visiteur();
//        alison.setVisMat("ali64");
//        alison.setVisNom("Bonnan");
//        alison.setVisPrenom("Alison");
//        alison.setVisAdresse("11 rue du poney");
//        alison.setVisCp(64000);
//        alison.setVisVille("Pau");
//        alison.setVisDateemb("15-sep-17");
//
//        Visiteur flo = new Visiteur();
//        flo.setVisMat("flo64");
//        flo.setVisNom("Nunes");
//        flo.setVisPrenom("Florence");
//        flo.setVisAdresse("1 rue du stade");
//        flo.setVisCp(64230);
//        flo.setVisVille("Poey de Lescar");
//        flo.setVisDateemb("20-nov-15");
//
//        Visiteur xavi = new Visiteur();
//        xavi.setVisMat("xav64");
//        xavi.setVisNom("Salaberria");
//        xavi.setVisPrenom("Xavier");
//        xavi.setVisAdresse(" 52 Rue Emile Guichenné");
//        xavi.setVisCp(64000);
//        xavi.setVisVille("Pau");
//        xavi.setVisDateemb("25-oct-15");
//
//        visiteurDAO.insert(michel);
//        visiteurDAO.insert(arnaud);
//        visiteurDAO.insert(alison);
//        visiteurDAO.insert(flo);
//        visiteurDAO.insert(xavi);

//        VisiteurDAO visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(this.getApplicationContext()));
//        List<Visiteur> list = new ArrayList<>();
//        list.addAll(visiteurDAO.getVisiteurList());
//        Log.d("visiteur", list.toString());

//
//        tvVisiteurNom = (TextView) findViewById(R.id.tvVisiteurNom);
//        tvVisiteurPrenom = (TextView) findViewById(R.id.tvVisiteurPrenom);
//
//        tvVisiteurPrenom.setText(visiteur.getVisPrenom());
//        tvVisiteurNom.setText(visiteur.getVisNom());

        //---------------------- INSERT PRATICIEN ------------------------------------//
//        Praticien praticien1 = new Praticien(1,"Notini","Alain","114 r Authie",85000,"LA ROCHE SUR YON", (float) 290.03);
//        Praticien praticien2 = new Praticien(2, "Gosselin", "Albert", "13 r Devon", 41000, "BLOIS",(float) 307.49);
//        Praticien praticien3 = new Praticien(3, "Delahaye", "André", "36 av 6 Juin",25000, "BESANCON", (float) 185.79);
//        Praticien praticien4 = new Praticien(4, "Leroux", "André", "47 av Robert Schuman",60000, "BEAUVAIS", (float) 172.04);
//        Praticien praticien5 = new Praticien(5, "Desmoulins", "Anne", "31 r St Jean",30000, "NIMES", (float) 94.75);
//        Praticien praticien6 = new Praticien(6, "Mouel", "Anne", "27 r Auvergne",80000, "AMIENS", (float) 45.2);
//        Praticien praticien7 = new Praticien(7, "Desgranges-Lentz", "Antoine", "1 r Albert de Mun",29000, "MORLAIX", (float) 20.07);
//        Praticien praticien8 = new Praticien(8, "Marcouiller", "Arnaud", "31 r St Jean",68000, "MULHOUSE", (float) 396.52);
//        Praticien praticien9 = new Praticien(9, "Dupuy", "Benoit", "9 r Demolombe",34000, "MONTPELLIER", (float) 395.66);
//        Praticien praticien10 = new Praticien(10, "Lerat", "Bernard", "31 r St Jean",59000, "LILLE", (float) 257.79);
//        Praticien praticien11 = new Praticien(11, "Marçais-Lefebvre", "Bertrand", "86Bis r Basse",67000, "STRASBOURG", (float) 450.96);
//        Praticien praticien12 = new Praticien(12, "Boscher", "Bruno", "94 r Falaise",10000, "TROYES", (float) 356.14);
//        Praticien praticien13 = new Praticien(13, "Morel", "Catherine", "21 r Chateaubriand",75000, "PARIS", (float) 379.57);
//        Praticien praticien14 = new Praticien(14, "Guivarch", "Chantal", "4 av Gén Laperrine",45000, "ORLEANS", (float) 114.56);
//        Praticien praticien15 = new Praticien(15, "Bessin-Grosdoit", "Christophe", "92 r Falaise",6000, "NICE", (float) 222.06);
//        Praticien praticien16 = new Praticien(16, "Rossa", "Claire", "14 av Thiès",6000, "NICE", (float) 529.78);
//        Praticien praticien17 = new Praticien(17, "Cauchy", "Denis", "5 av Ste Thérèse",11000, "NARBONNE", (float) 458.82);
//        Praticien praticien18 = new Praticien(18, "Gaffé", "Dominique", "9 av 1ère Armée Française",35000, "RENNES", (float) 213.4);
//        Praticien praticien19 = new Praticien(19, "Guenon", "Dominique", "98 bd Mar Lyautey",44000, "NANTES", (float) 175.89);
//        Praticien praticien20 = new Praticien(20, "Prévot", "Dominique", "29 r Lucien Nelle",87000, "LIMOGES", (float) 151.36);
//
//        SimpleSQLiteOpenHelper helper = new PharmaSQLiteOpenHelper(this.getApplicationContext());
//        PraticienDAO praticienDAO = new PraticienDAOImpl(helper);
//
//        praticienDAO.insert(praticien1);
//        praticienDAO.insert(praticien2);
//        praticienDAO.insert(praticien3);
//        praticienDAO.insert(praticien4);
//        praticienDAO.insert(praticien5);
//        praticienDAO.insert(praticien6);
//        praticienDAO.insert(praticien7);
//        praticienDAO.insert(praticien8);
//        praticienDAO.insert(praticien9);
//        praticienDAO.insert(praticien10);
//        praticienDAO.insert(praticien11);
//        praticienDAO.insert(praticien12);
//        praticienDAO.insert(praticien13);
//        praticienDAO.insert(praticien14);
//        praticienDAO.insert(praticien15);
//        praticienDAO.insert(praticien16);
//        praticienDAO.insert(praticien17);
//        praticienDAO.insert(praticien18);
//        praticienDAO.insert(praticien19);
//        praticienDAO.insert(praticien20);
//        PraticienDAO praticienDAO = new PraticienDAOImpl(new PharmaSQLiteOpenHelper(this.getApplicationContext()));
//        List<Praticien> list = new ArrayList<>();
//        list.addAll(praticienDAO.getPraticienList());
//        Log.d("praticien", list.toString());


        //Récupération du visiteur connecté
        vis_mat = getIntent().getExtras().getString("vis_mat");
//        visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
//        Visiteur visiteur = visiteurDAO.getByVisMat(vis_mat);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Appuyer deux fois pour quitter", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_compte_rendu) {
            // Handle the camera action
        } else if (id == R.id.nav_visiteur) {
            VisiteurFragment visiteurFragment = VisiteurFragment.newInstance(1);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
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
                    .replace(
                    R.id.constraintlayout_for_fragment,
                    praticienFragment,
                    praticienFragment.getTag()
            ).commit();
        } else if (id == R.id.nav_medicament) {

        } else if (id == R.id.nav_profil) {
            VisiteurProfilFragment visiteurProfilFragment = VisiteurProfilFragment.newInstance(vis_mat);
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left, R.anim.anim_slide_out_from_left)
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            visiteurProfilFragment,
                            visiteurProfilFragment.getTag()
                    ).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Visiteur visiteur) {
        Toast.makeText(getApplicationContext(), visiteur.getVisMat(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onListFragmentInteraction(Praticien praticien) {
        Toast.makeText(getApplicationContext(), praticien.getPraNum().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }
}
