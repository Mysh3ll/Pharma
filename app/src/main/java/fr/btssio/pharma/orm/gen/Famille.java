package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Famille.
 */
public class Famille implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = 7346040343812663409L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<FamilleDAO> DAO_INTERFACE_CLASS = FamilleDAO.class;
    /**
     * Property representing column fam_code
     */
    protected String famCode;
    /**
     * Property representing column fam_libelle
     */
    protected String famLibelle;

    /**
     * Default constructor.
     */
    public Famille() {
    }

    /**
     * All columns constructor.
     * @param famCode value of column fam_code.
     * @param famLibelle value of column fam_libelle.
     */
    public Famille(String famCode, String famLibelle) {
        setFamCode(famCode);
        setFamLibelle(famLibelle);
    }

    /**
     * Returns value of property {@link #famCode}.
     * @return value of property {@link #famCode}.
     */
    public String getFamCode() {
        return this.famCode;
    }
    /**
     * Sets new value of property {@link #famCode}.
     * @param famCode new value of property {@link #famCode}.
     */
    public void setFamCode(String famCode) {
        this.famCode = famCode;
    }
    /**
     * Returns value of property {@link #famLibelle}.
     * @return value of property {@link #famLibelle}.
     */
    public String getFamLibelle() {
        return this.famLibelle;
    }
    /**
     * Sets new value of property {@link #famLibelle}.
     * @param famLibelle new value of property {@link #famLibelle}.
     */
    public void setFamLibelle(String famLibelle) {
        this.famLibelle = famLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Famille famille = (Famille) o;

        if (famCode != null ? !famCode.equals(famille.famCode) : famille.famCode != null) {
            return false;
        }
        if (famLibelle != null ? !famLibelle.equals(famille.famLibelle) : famille.famLibelle != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (famCode != null ? famCode.hashCode() : 0);
        result = 31 * result + (famLibelle != null ? famLibelle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Famille{"
                + "famCode='" + famCode + '\''
                + ", famLibelle='" + famLibelle + '\''
                + '}';
    }
}
