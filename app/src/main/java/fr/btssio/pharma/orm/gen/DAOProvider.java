package fr.btssio.pharma.orm.gen;

public class DAOProvider {

    /**
     * Data source for this DAOProvider.
     */
    protected fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource;

    /**
     * DAOMonitor for this DAOProvider.
     */
    protected fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor;

    /**
     * DAO instance for tableVisiteur
     */
    protected VisiteurDAO visiteurDAO = null;

    /**
     * DAO instance for tablePraticien
     */
    protected PraticienDAO praticienDAO = null;

    /**
     * DAO instance for tableMedicament
     */
    protected MedicamentDAO medicamentDAO = null;

    /**
     * DAO instance for tableFamille
     */
    protected FamilleDAO familleDAO = null;

    /**
     * DAO instance for tableRapport_Visite
     */
    protected RapportVisiteDAO rapportVisiteDAO = null;

    /**
     * DAO instance for tableOffrir
     */
    protected OffrirDAO offrirDAO = null;

    /**
     * Constructor.
     * @param dataSource SQLiteDataSource implementation for DAOProvider
     */
    public DAOProvider(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        this.dataSource = dataSource;
        this.daoMonitor = new fr.btssio.pharma.orm.runtime.util.monitors.EmptyDAOMonitor();
    }

    /**
     * Constructor.
     * @param dataSource SQLiteDataSource implementation for DAOProvider
     * @param daoMonitor DAOMonitor implementation for DAOProvider
     */
    public DAOProvider(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource, 
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        this.dataSource = dataSource;
        this.daoMonitor = daoMonitor;
    }

    /**
     * Returns DAO implementation object for table Visiteur
     * @return DAO implementation object for table Visiteur
     */
    public VisiteurDAO getVisiteurDAO() {
        if (this.visiteurDAO == null) {
            this.visiteurDAO = new VisiteurDAOImpl(dataSource, daoMonitor);
        }
        return this.visiteurDAO;
    }

    /**
     * Returns DAO implementation object for table Praticien
     * @return DAO implementation object for table Praticien
     */
    public PraticienDAO getPraticienDAO() {
        if (this.praticienDAO == null) {
            this.praticienDAO = new PraticienDAOImpl(dataSource, daoMonitor);
        }
        return this.praticienDAO;
    }

    /**
     * Returns DAO implementation object for table Medicament
     * @return DAO implementation object for table Medicament
     */
    public MedicamentDAO getMedicamentDAO() {
        if (this.medicamentDAO == null) {
            this.medicamentDAO = new MedicamentDAOImpl(dataSource, daoMonitor);
        }
        return this.medicamentDAO;
    }

    /**
     * Returns DAO implementation object for table Famille
     * @return DAO implementation object for table Famille
     */
    public FamilleDAO getFamilleDAO() {
        if (this.familleDAO == null) {
            this.familleDAO = new FamilleDAOImpl(dataSource, daoMonitor);
        }
        return this.familleDAO;
    }

    /**
     * Returns DAO implementation object for table Rapport_Visite
     * @return DAO implementation object for table Rapport_Visite
     */
    public RapportVisiteDAO getRapportVisiteDAO() {
        if (this.rapportVisiteDAO == null) {
            this.rapportVisiteDAO = new RapportVisiteDAOImpl(dataSource, daoMonitor);
        }
        return this.rapportVisiteDAO;
    }

    /**
     * Returns DAO implementation object for table Offrir
     * @return DAO implementation object for table Offrir
     */
    public OffrirDAO getOffrirDAO() {
        if (this.offrirDAO == null) {
            this.offrirDAO = new OffrirDAOImpl(dataSource, daoMonitor);
        }
        return this.offrirDAO;
    }

}
