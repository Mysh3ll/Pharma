package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Praticien.
 */
public class Praticien implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -5616264300414736225L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<PraticienDAO> DAO_INTERFACE_CLASS = PraticienDAO.class;
    /**
     * Property representing column pra_num
     */
    protected Integer praNum;
    /**
     * Property representing column pra_nom
     */
    protected String praNom;
    /**
     * Property representing column pra_prenom
     */
    protected String praPrenom;
    /**
     * Property representing column pra_adresse
     */
    protected String praAdresse;
    /**
     * Property representing column pra_cp
     */
    protected Integer praCp;
    /**
     * Property representing column pra_ville
     */
    protected String praVille;
    /**
     * Property representing column pra_coef
     */
    protected Float praCoef;

    /**
     * Default constructor.
     */
    public Praticien() {
    }

    /**
     * All columns constructor.
     * @param praNum value of column pra_num.
     * @param praNom value of column pra_nom.
     * @param praPrenom value of column pra_prenom.
     * @param praAdresse value of column pra_adresse.
     * @param praCp value of column pra_cp.
     * @param praVille value of column pra_ville.
     * @param praCoef value of column pra_coef.
     */
    public Praticien(Integer praNum, String praNom, String praPrenom, String praAdresse, Integer praCp, String praVille, Float praCoef) {
        setPraNum(praNum);
        setPraNom(praNom);
        setPraPrenom(praPrenom);
        setPraAdresse(praAdresse);
        setPraCp(praCp);
        setPraVille(praVille);
        setPraCoef(praCoef);
    }

    /**
     * Returns value of property {@link #praNum}.
     * @return value of property {@link #praNum}.
     */
    public Integer getPraNum() {
        return this.praNum;
    }
    /**
     * Sets new value of property {@link #praNum}.
     * @param praNum new value of property {@link #praNum}.
     */
    public void setPraNum(Integer praNum) {
        this.praNum = praNum;
    }
    /**
     * Returns value of property {@link #praNom}.
     * @return value of property {@link #praNom}.
     */
    public String getPraNom() {
        return this.praNom;
    }
    /**
     * Sets new value of property {@link #praNom}.
     * @param praNom new value of property {@link #praNom}.
     */
    public void setPraNom(String praNom) {
        this.praNom = praNom;
    }
    /**
     * Returns value of property {@link #praPrenom}.
     * @return value of property {@link #praPrenom}.
     */
    public String getPraPrenom() {
        return this.praPrenom;
    }
    /**
     * Sets new value of property {@link #praPrenom}.
     * @param praPrenom new value of property {@link #praPrenom}.
     */
    public void setPraPrenom(String praPrenom) {
        this.praPrenom = praPrenom;
    }
    /**
     * Returns value of property {@link #praAdresse}.
     * @return value of property {@link #praAdresse}.
     */
    public String getPraAdresse() {
        return this.praAdresse;
    }
    /**
     * Sets new value of property {@link #praAdresse}.
     * @param praAdresse new value of property {@link #praAdresse}.
     */
    public void setPraAdresse(String praAdresse) {
        this.praAdresse = praAdresse;
    }
    /**
     * Returns value of property {@link #praCp}.
     * @return value of property {@link #praCp}.
     */
    public Integer getPraCp() {
        return this.praCp;
    }
    /**
     * Sets new value of property {@link #praCp}.
     * @param praCp new value of property {@link #praCp}.
     */
    public void setPraCp(Integer praCp) {
        this.praCp = praCp;
    }
    /**
     * Returns value of property {@link #praVille}.
     * @return value of property {@link #praVille}.
     */
    public String getPraVille() {
        return this.praVille;
    }
    /**
     * Sets new value of property {@link #praVille}.
     * @param praVille new value of property {@link #praVille}.
     */
    public void setPraVille(String praVille) {
        this.praVille = praVille;
    }
    /**
     * Returns value of property {@link #praCoef}.
     * @return value of property {@link #praCoef}.
     */
    public Float getPraCoef() {
        return this.praCoef;
    }
    /**
     * Sets new value of property {@link #praCoef}.
     * @param praCoef new value of property {@link #praCoef}.
     */
    public void setPraCoef(Float praCoef) {
        this.praCoef = praCoef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Praticien praticien = (Praticien) o;

        if (praNum != null ? !praNum.equals(praticien.praNum) : praticien.praNum != null) {
            return false;
        }
        if (praNom != null ? !praNom.equals(praticien.praNom) : praticien.praNom != null) {
            return false;
        }
        if (praPrenom != null ? !praPrenom.equals(praticien.praPrenom) : praticien.praPrenom != null) {
            return false;
        }
        if (praAdresse != null ? !praAdresse.equals(praticien.praAdresse) : praticien.praAdresse != null) {
            return false;
        }
        if (praCp != null ? !praCp.equals(praticien.praCp) : praticien.praCp != null) {
            return false;
        }
        if (praVille != null ? !praVille.equals(praticien.praVille) : praticien.praVille != null) {
            return false;
        }
        if (praCoef != null ? !praCoef.equals(praticien.praCoef) : praticien.praCoef != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (praNum != null ? praNum.hashCode() : 0);
        result = 31 * result + (praNom != null ? praNom.hashCode() : 0);
        result = 31 * result + (praPrenom != null ? praPrenom.hashCode() : 0);
        result = 31 * result + (praAdresse != null ? praAdresse.hashCode() : 0);
        result = 31 * result + (praCp != null ? praCp.hashCode() : 0);
        result = 31 * result + (praVille != null ? praVille.hashCode() : 0);
        result = 31 * result + (praCoef != null ? praCoef.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Praticien{"
                + "praNum='" + praNum + '\''
                + ", praNom='" + praNom + '\''
                + ", praPrenom='" + praPrenom + '\''
                + ", praAdresse='" + praAdresse + '\''
                + ", praCp='" + praCp + '\''
                + ", praVille='" + praVille + '\''
                + ", praCoef='" + praCoef + '\''
                + '}';
    }
}
