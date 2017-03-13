package fr.btssio.pharma;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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

import fr.btssio.pharma.fragment.FamilleFragment;
import fr.btssio.pharma.fragment.MedicamentDetailsFragment;
import fr.btssio.pharma.fragment.MedicamentFragment;
import fr.btssio.pharma.fragment.PraticienDetailsFragment;
import fr.btssio.pharma.fragment.PraticienFragment;
import fr.btssio.pharma.fragment.VisiteurDetailsFragment;
import fr.btssio.pharma.fragment.VisiteurFragment;
import fr.btssio.pharma.fragment.VisiteurProfilFragment;
import fr.btssio.pharma.orm.gen.Famille;
import fr.btssio.pharma.orm.gen.Medicament;
import fr.btssio.pharma.orm.gen.Praticien;
import fr.btssio.pharma.orm.gen.Visiteur;
import fr.btssio.pharma.orm.gen.VisiteurDAO;
import fr.btssio.pharma.fragment.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        VisiteurFragment.OnListFragmentInteractionListener,
        PraticienFragment.OnListFragmentInteractionListener,
        VisiteurProfilFragment.OnFragmentInteractionListener,
        FamilleFragment.OnListFragmentInteractionListener,
        MedicamentFragment.OnListFragmentInteractionListener {

    private static final String FAM_CODE = "fam_code";
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

        insertDataToDatabase();

        //Load fragment_main
        MainFragment mainFragment = new MainFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(
                        R.id.constraintlayout_for_fragment,
                        mainFragment,
                        mainFragment.getTag()
                ).commit();

        //Récupération du visiteur connecté
        vis_mat = getIntent().getExtras().getString("vis_mat");
//        visiteurDAO = new VisiteurDAOImpl(new PharmaSQLiteOpenHelper(getApplicationContext()));
//        Visiteur visiteur = visiteurDAO.getByVisMat(vis_mat);

    }

    @Override
    public void onBackPressed() {

        //Listener for back button on Fragment
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) { // back to the parent (fragment)
            fm.popBackStack();
        } else {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (!drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.openDrawer(GravityCompat.START);
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
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
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
                    .addToBackStack(null)
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
                    .addToBackStack(null)
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
                    .addToBackStack(null)
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
                    .addToBackStack(null)
                    .replace(
                            R.id.constraintlayout_for_fragment,
                            visiteurProfilFragment,
                            visiteurProfilFragment.getTag()
                    ).commit();
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

    private void insertDataToDatabase() {
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

        //--------------- INSERT FAMILLE ---------------------------//

//        Famille famille1 = new Famille("AA", "Antalgiques en association");
//        Famille famille2 = new Famille("AAA", "Antalgiques antipyrétiques en association");
//        Famille famille3 = new Famille("AAC", "Antidépresseur d'action centrale");
//        Famille famille4 = new Famille("AAH", "Antivertigineux antihistaminique H1");
//        Famille famille5 = new Famille("ABA", "Antibiotique antituberculeux");
//        Famille famille6 = new Famille("ABC", "Antibiotique antiacnéique local");
//        Famille famille7 = new Famille("ABP", "Antibiotique de la famille des béta-lactamines (pénicilline A)");
//        Famille famille8 = new Famille("AFC", "Antibiotique de la famille des cyclines");
//        Famille famille9 = new Famille("AFM", "Antibiotique de la famille des macrolides");
//        Famille famille10 = new Famille("AH", "Antihistaminique H1 local");
//        Famille famille11 = new Famille("AIM", "Antidépresseur imipraminique (tricyclique)");
//        Famille famille12 = new Famille("AIN", "Antidépresseur inhibiteur sélectif de la recapture de la sérotonine");
//        Famille famille13 = new Famille("ALO", "Antibiotique local (ORL)");
//        Famille famille14 = new Famille("ANS", "Antidépresseur IMAO non sélectif");
//        Famille famille15 = new Famille("AO", "Antibiotique ophtalmique");
//        Famille famille16 = new Famille("AP", "Antipsychotique normothymique");
//        Famille famille17 = new Famille("AUM", "Antibiotique urinaire minute");
//        Famille famille18 = new Famille("CRT", "Corticoïde, antibiotique et antifongique à  usage local");
//        Famille famille19 = new Famille("HYP", "Hypnotique antihistaminique");
//        Famille famille20 = new Famille("PSA", "Psychostimulant, antiasthénique");
//
//        SimpleSQLiteOpenHelper helper = new PharmaSQLiteOpenHelper(this.getApplicationContext());
//        FamilleDAO familleDAO = new FamilleDAOImpl(helper);
//
//        familleDAO.insert(famille1);
//        familleDAO.insert(famille2);
//        familleDAO.insert(famille3);
//        familleDAO.insert(famille4);
//        familleDAO.insert(famille5);
//        familleDAO.insert(famille6);
//        familleDAO.insert(famille7);
//        familleDAO.insert(famille8);
//        familleDAO.insert(famille9);
//        familleDAO.insert(famille10);
//        familleDAO.insert(famille11);
//        familleDAO.insert(famille12);
//        familleDAO.insert(famille13);
//        familleDAO.insert(famille14);
//        familleDAO.insert(famille15);
//        familleDAO.insert(famille16);
//        familleDAO.insert(famille17);
//        familleDAO.insert(famille18);
//        familleDAO.insert(famille19);
//        familleDAO.insert(famille20);
//        List<Famille> list = new ArrayList<>();
//        list.addAll(familleDAO.getFamilleList());
//        Log.d("famille", list.toString());

        //----------------------- INSERT MEDICAMENT -----------------------//

//        Medicament medicament1 = new Medicament("3MYC7"     ,"TRIMYCINE"            ,"Triamcinolone (acétonide) + Néomycine + Nystatine","Ce médicament est un corticoïde à  activité forte ou très forte associé à  un antibiotique et un antifongique, utilisé en application locale dans certaines atteintes cutanées surinfectées.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants, d\"infections de la peau ou de parasitisme non traités, d\"acné. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.","CRT");
//        Medicament medicament2 = new Medicament("ADIMOL9"   ,"ADIMOL"               ,"Amoxicilline + Acide clavulanique","Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie aux pénicillines ou aux céphalosporines.","ABP");
//        Medicament medicament3 = new Medicament("AMOPIL7"   ,"AMOPIL"               ,"Amoxicilline","Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie aux pénicillines. Il doit être administré avec prudence en cas d\"allergie aux céphalosporines.","ABP");
//        Medicament medicament4 = new Medicament("AMOX45"    ,"AMOXAR"               ,"Amoxicilline","Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.","La prise de ce médicament peut rendre positifs les tests de dépistage du dopage.","ABP");
//        Medicament medicament5 = new Medicament("AMOXIG12"  ,"AMOXI Gé"             ,"Amoxicilline","Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie aux pénicillines. Il doit être administré avec prudence en cas d\"allergie aux céphalosporines.","ABP");
//        Medicament medicament6 = new Medicament("APATOUX22" ,"APATOUX Vitamine C"   ,"Tyrothricine + Tétracaïne + Acide ascorbique (Vitamine C)","Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants, en cas de phénylcétonurie et chez l\"enfant de moins de 6 ans.","ALO");
//        Medicament medicament7 = new Medicament("BACTIG10"  ,"BACTIGEL"             ,"Erythromycine","Ce médicament est utilisé en application locale pour traiter l\"acné et les infections cutanées bactériennes associées.","Ce médicament est contre-indiqué en cas d\"allergie aux antibiotiques de la famille des macrolides ou des lincosanides.","ABC");
//        Medicament medicament8 = new Medicament("BACTIV13"  ,"BACTIVIL"             ,"Erythromycine","Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie aux macrolides (dont le chef de file est l\"érythromycine).","AFM");
//        Medicament medicament9 = new Medicament("BITALV"    ,"BIVALIC"              ,"Dextropropoxyphène + Paracétamol","Ce médicament est utilisé pour traiter les douleurs d\"intensité modérée ou intense.","Ce médicament est contre-indiqué en cas d\"allergie aux médicaments de cette famille, d\"insuffisance hépatique ou d\"insuffisance rénale.","AAA");
//        Medicament medicament10 = new Medicament("CARTION6" ,"CARTION"              ,"Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol","Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.","Ce médicament est contre-indiqué en cas de troubles de la coagulation (tendances aux hémorragies), d\"ulcère gastroduodénal, maladies graves du foie.","AAA");
//        Medicament medicament11 = new Medicament("CLAZER6"  ,"CLAZER"               ,"Clarithromycine","Ce médicament est utilisé pour traiter des infections bactériennes spécifiques. Il est également utilisé dans le traitement de l\"ulcère gastro-duodénal, en association avec d\"autres médicaments.","Ce médicament est contre-indiqué en cas d\"allergie aux macrolides (dont le chef de file est l\"érythromycine).","AFM");
//        Medicament medicament12 = new Medicament("DEPRIL9"  ,"DEPRAMIL"             ,"Clomipramine","Ce médicament est utilisé pour traiter les épisodes dépressifs sévères, certaines douleurs rebelles, les troubles obsessionnels compulsifs et certaines énurésies chez l\"enfant.","Ce médicament est contre-indiqué en cas de glaucome ou d\"adénome de la prostate, d\"infarctus récent, ou si vous avez reà§u un traitement par IMAO durant les 2 semaines précédentes ou en cas d\"allergie aux antidépresseurs imipraminiques.","AIM");
//        Medicament medicament13 = new Medicament("DIMIRTAM6","DIMIRTAM"             ,"Mirtazapine","Ce médicament est utilisé pour traiter les épisodes dépressifs sévères.","La prise de ce produit est contre-indiquée en cas de d\"allergie à  l\"un des constituants.","AAC");
//        Medicament medicament14 = new Medicament("DOLRIL7"  ,"DOLORIL"              ,"Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol","Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.","Ce médicament est contre-indiqué en cas d\"allergie au paracétamol ou aux salicylates.","AAA");
//        Medicament medicament15 = new Medicament("DORNOM8"  ,"NORMADOR"             ,"Doxylamine","Ce médicament est utilisé pour traiter l\"insomnie chez l\"adulte.","Ce médicament est contre-indiqué en cas de glaucome, de certains troubles urinaires (rétention urinaire) et chez l\"enfant de moins de 15 ans.","HYP");
//        Medicament medicament16 = new Medicament("EQUILARX6","EQUILAR"              ,"Méclozine","Ce médicament est utilisé pour traiter les vertiges et pour prévenir le mal des transports.","Ce médicament ne doit pas être utilisé en cas d\"allergie au produit, en cas de glaucome ou de rétention urinaire.","AAH");
//        Medicament medicament17 = new Medicament("EVILR7"   ,"EVEILLOR"             ,"Adrafinil","Ce médicament est utilisé pour traiter les troubles de la vigilance et certains symptomes neurologiques chez le sujet agé.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants.","PSA");
//        Medicament medicament18 = new Medicament("INSXT5"   ,"INSECTIL"             ,"Diphénydramine","Ce médicament est utilisé en application locale sur les piqûres d\"insecte et l\"urticaire.","Ce médicament est contre-indiqué en cas d\"allergie aux antihistaminiques.","AH" );
//        Medicament medicament19 = new Medicament("JOVAI8"   ,"JOVENIL"              ,"Josamycine","Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie aux macrolides (dont le chef de file est l\"érythromycine).","AFM");
//        Medicament medicament20 = new Medicament("LIDOXY23" ,"LIDOXYTRACINE"        ,"Oxytétracycline +Lidocaïne","Ce médicament est utilisé en injection intramusculaire pour traiter certaines infections spécifiques.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants. Il ne doit pas être associé aux rétinoïdes.","AFC");
//        Medicament medicament21 = new Medicament("LITHOR12" ,"LITHORINE"            ,"Lithium","Ce médicament est indiqué dans la prévention des psychoses maniaco-dépressives ou pour traiter les états maniaques.","Ce médicament ne doit pas être utilisé si vous êtes allergique au lithium. Avant de prendre ce traitement, signalez à  votre médecin traitant si vous souffrez d\"insuffisance rénale, ou si vous avez un régime sans sel.","AP" );
//        Medicament medicament22 = new Medicament("PARMOL16" ,"PARMOCODEINE"         ,"Codéine + Paracétamol","Ce médicament est utilisé pour le traitement des douleurs lorsque des antalgiques simples ne sont pas assez efficaces.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants, chez l\"enfant de moins de 15 Kg, en cas d\"insuffisance hépatique ou respiratoire, d\"asthme, de phénylcétonurie et chez la femme qui allaite.","AA" );
//        Medicament medicament23 = new Medicament("PHYSOI8"  ,"PHYSICOR"             ,"Sulbutiamine","Ce médicament est utilisé pour traiter les baisses d\"activité physique ou psychique, souvent dans un contexte de dépression.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants.","PSA");
//        Medicament medicament24 = new Medicament("PIRIZ8"   ,"PIRIZAN"              ,"Pyrazinamide","Ce médicament est utilisé, en association à  d\"autres antibiotiques, pour traiter la tuberculose.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants, d\"insuffisance rénale ou hépatique, d\"hyperuricémie ou de porphyrie.","ABA");
//        Medicament medicament25 = new Medicament("POMDI20"  ,"POMADINE"             ,"Bacitracine","Ce médicament est utilisé pour traiter les infections oculaires de la surface de l\"oeil.","Ce médicament est contre-indiqué en cas d\"allergie aux antibiotiques appliqués localement.","AO" );
//        Medicament medicament26 = new Medicament("TROXT21"  ,"TROXADET"             ,"Paroxétine","Ce médicament est utilisé pour traiter la dépression et les troubles obsessionnels compulsifs. Il peut également être utilisé en prévention des crises de panique avec ou sans agoraphobie.","Ce médicament est contre-indiqué en cas d\"allergie au produit.","AIN");
//        Medicament medicament27 = new Medicament("TXISOL22" ,"TOUXISOL Vitamine C"  ,"Tyrothricine + Acide ascorbique (Vitamine C)","Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.","Ce médicament est contre-indiqué en cas d\"allergie à  l\"un des constituants et chez l\"enfant de moins de 6 ans.","ALO");
//        Medicament medicament28 = new Medicament("URIEG6"   ,"URIREGUL"             ,"Fosfomycine trométamol","Ce médicament est utilisé pour traiter les infections urinaires simples chez la femme de moins de 65 ans.","La prise de ce médicament est contre-indiquée en cas d\"allergie à  l\"un des constituants et d\"insuffisance rénale.","AUM");
//
//        SimpleSQLiteOpenHelper helper = new PharmaSQLiteOpenHelper(this.getApplicationContext());
//        MedicamentDAO medicamentDAO = new MedicamentDAOImpl(helper);
//
//        medicamentDAO.insert(medicament1);
//        medicamentDAO.insert(medicament2);
//        medicamentDAO.insert(medicament3);
//        medicamentDAO.insert(medicament4);
//        medicamentDAO.insert(medicament5);
//        medicamentDAO.insert(medicament6);
//        medicamentDAO.insert(medicament7);
//        medicamentDAO.insert(medicament8);
//        medicamentDAO.insert(medicament9);
//        medicamentDAO.insert(medicament10);
//        medicamentDAO.insert(medicament11);
//        medicamentDAO.insert(medicament12);
//        medicamentDAO.insert(medicament13);
//        medicamentDAO.insert(medicament14);
//        medicamentDAO.insert(medicament15);
//        medicamentDAO.insert(medicament16);
//        medicamentDAO.insert(medicament17);
//        medicamentDAO.insert(medicament18);
//        medicamentDAO.insert(medicament19);
//        medicamentDAO.insert(medicament20);
//        medicamentDAO.insert(medicament21);
//        medicamentDAO.insert(medicament22);
//        medicamentDAO.insert(medicament23);
//        medicamentDAO.insert(medicament24);
//        medicamentDAO.insert(medicament25);
//        medicamentDAO.insert(medicament26);
//        medicamentDAO.insert(medicament27);
//        medicamentDAO.insert(medicament28);
//        List<Medicament> list = new ArrayList<>();
//        list.addAll(medicamentDAO.getMedicamentList());
//        Log.d("medicament", list.toString());

    }
}
