package fr.btssio.pharma;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.orm.gen.VisiteurDAOImpl;
import fr.btssio.pharma.orm.runtime.util.SimpleSQLiteOpenHelper;
import fr.btssio.pharma.sqllite.PharmaSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SimpleSQLiteOpenHelper helper = new PharmaSQLiteOpenHelper(this.getApplicationContext());
        VisiteurDAO visiteurDAO = new VisiteurDAOImpl(helper);

        Visiteur michel = new Visiteur();
        michel.setVisMat("mic64");
        michel.setVisNom("Pompas");
        michel.setVisPrenom("Michel");
        michel.setVisAdresse("9 rue d'iraty");
        michel.setVisCp(64510);
        michel.setVisVille("Bordes");
        michel.setVisDateemb("10-mar-17");

        Visiteur arnaud = new Visiteur();
        michel.setVisMat("arn64");
        michel.setVisNom("Ayrem");
        michel.setVisPrenom("Arnaud");
        michel.setVisAdresse("10 rue des lilas");
        michel.setVisCp(64000);
        michel.setVisVille("Pau");
        michel.setVisDateemb("10-jan-17");

        Visiteur alison = new Visiteur();
        michel.setVisMat("ali64");
        michel.setVisNom("Bonnan");
        michel.setVisPrenom("Alison");
        michel.setVisAdresse("11 rue du poney");
        michel.setVisCp(64000);
        michel.setVisVille("Pau");
        michel.setVisDateemb("15-sep-17");

        Visiteur flo = new Visiteur();
        michel.setVisMat("flo64");
        michel.setVisNom("Nunes");
        michel.setVisPrenom("Florence");
        michel.setVisAdresse("1 rue du stade");
        michel.setVisCp(64230);
        michel.setVisVille("Poey de Lescar");
        michel.setVisDateemb("20-nov-15");

        Visiteur xavi = new Visiteur();
        michel.setVisMat("xav64");
        michel.setVisNom("Salaberria");
        michel.setVisPrenom("Xavier");
        michel.setVisAdresse(" 52 Rue Emile Guichenné");
        michel.setVisCp(64000);
        michel.setVisVille("Pau");
        michel.setVisDateemb("25-oct-15");

        visiteurDAO.insert(michel);
        visiteurDAO.insert(arnaud);
        visiteurDAO.insert(alison);
        visiteurDAO.insert(flo);
        visiteurDAO.insert(xavi);
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

        } else if (id == R.id.nav_praticien) {

        } else if (id == R.id.nav_medicament) {

        } else if (id == R.id.nav_profil) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
