package fr.btssio.pharma;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
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

import fr.btssio.pharma.fragment.VisiteurFragment;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        VisiteurFragment.OnListFragmentInteractionListener {

    private VisiteurDAO visiteurDAO;
    private TextView tvVisiteurNom, tvVisiteurPrenom;

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

        //Récupération du visiteur connecté
        String vis_mat = getIntent().getExtras().getString("vis_mat");
        visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
        Visiteur visiteur = visiteurDAO.getByVisMat(vis_mat);

        tvVisiteurNom = (TextView) findViewById(R.id.tvVisiteurNom);
        tvVisiteurPrenom = (TextView) findViewById(R.id.tvVisiteurPrenom);

        tvVisiteurPrenom.setText(visiteur.getVisPrenom());
        tvVisiteurNom.setText(visiteur.getVisNom());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
            manager.beginTransaction().replace(
                    R.id.constraintlayout_for_fragment,
                    visiteurFragment,
                    visiteurFragment.getTag()
            ).commit();
        } else if (id == R.id.nav_praticien) {

        } else if (id == R.id.nav_medicament) {

        } else if (id == R.id.nav_profil) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListFragmentInteraction(Visiteur item) {
        Toast.makeText(getApplicationContext(), item.getVisMat(), Toast.LENGTH_LONG).show();
    }
}
