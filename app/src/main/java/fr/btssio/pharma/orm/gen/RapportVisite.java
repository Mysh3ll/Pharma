package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Rapport_Visite.
 */
public class RapportVisite implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -2478272959798001370L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<RapportVisiteDAO> DAO_INTERFACE_CLASS = RapportVisiteDAO.class;
    /**
     * Property representing column rap_num
     */
    protected Integer rapNum;
    /**
     * Property representing column rap_date
     */
    protected String rapDate;
    /**
     * Property representing column rap_motif
     */
    protected String rapMotif;
    /**
     * Property representing column rap_bilan
     */
    protected String rapBilan;
    /**
     * Property representing column Visiteur_vis_mat
     */
    protected String visiteurVisMat;
    /**
     * Property representing column Praticien_pra_num
     */
    protected Integer praticienPraNum;

    /**
     * Default constructor.
     */
    public RapportVisite() {
    }

    /**
     * All columns constructor.
     * @param rapNum value of column rap_num.
     * @param rapDate value of column rap_date.
     * @param rapMotif value of column rap_motif.
     * @param rapBilan value of column rap_bilan.
     * @param visiteurVisMat value of column Visiteur_vis_mat.
     * @param praticienPraNum value of column Praticien_pra_num.
     */
    public RapportVisite(Integer rapNum, String rapDate, String rapMotif, String rapBilan, String visiteurVisMat, Integer praticienPraNum) {
        setRapNum(rapNum);
        setRapDate(rapDate);
        setRapMotif(rapMotif);
        setRapBilan(rapBilan);
        setVisiteurVisMat(visiteurVisMat);
        setPraticienPraNum(praticienPraNum);
    }

    /**
     * Returns value of property {@link #rapNum}.
     * @return value of property {@link #rapNum}.
     */
    public Integer getRapNum() {
        return this.rapNum;
    }
    /**
     * Sets new value of property {@link #rapNum}.
     * @param rapNum new value of property {@link #rapNum}.
     */
    public void setRapNum(Integer rapNum) {
        this.rapNum = rapNum;
    }
    /**
     * Returns value of property {@link #rapDate}.
     * @return value of property {@link #rapDate}.
     */
    public String getRapDate() {
        return this.rapDate;
    }
    /**
     * Sets new value of property {@link #rapDate}.
     * @param rapDate new value of property {@link #rapDate}.
     */
    public void setRapDate(String rapDate) {
        this.rapDate = rapDate;
    }
    /**
     * Returns value of property {@link #rapMotif}.
     * @return value of property {@link #rapMotif}.
     */
    public String getRapMotif() {
        return this.rapMotif;
    }
    /**
     * Sets new value of property {@link #rapMotif}.
     * @param rapMotif new value of property {@link #rapMotif}.
     */
    public void setRapMotif(String rapMotif) {
        this.rapMotif = rapMotif;
    }
    /**
     * Returns value of property {@link #rapBilan}.
     * @return value of property {@link #rapBilan}.
     */
    public String getRapBilan() {
        return this.rapBilan;
    }
    /**
     * Sets new value of property {@link #rapBilan}.
     * @param rapBilan new value of property {@link #rapBilan}.
     */
    public void setRapBilan(String rapBilan) {
        this.rapBilan = rapBilan;
    }
    /**
     * Returns value of property {@link #visiteurVisMat}.
     * @return value of property {@link #visiteurVisMat}.
     */
    public String getVisiteurVisMat() {
        return this.visiteurVisMat;
    }
    /**
     * Sets new value of property {@link #visiteurVisMat}.
     * @param visiteurVisMat new value of property {@link #visiteurVisMat}.
     */
    public void setVisiteurVisMat(String visiteurVisMat) {
        this.visiteurVisMat = visiteurVisMat;
    }
    /**
     * Returns value of property {@link #praticienPraNum}.
     * @return value of property {@link #praticienPraNum}.
     */
    public Integer getPraticienPraNum() {
        return this.praticienPraNum;
    }
    /**
     * Sets new value of property {@link #praticienPraNum}.
     * @param praticienPraNum new value of property {@link #praticienPraNum}.
     */
    public void setPraticienPraNum(Integer praticienPraNum) {
        this.praticienPraNum = praticienPraNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RapportVisite rapportVisite = (RapportVisite) o;

        if (rapNum != null ? !rapNum.equals(rapportVisite.rapNum) : rapportVisite.rapNum != null) {
            return false;
        }
        if (rapDate != null ? !rapDate.equals(rapportVisite.rapDate) : rapportVisite.rapDate != null) {
            return false;
        }
        if (rapMotif != null ? !rapMotif.equals(rapportVisite.rapMotif) : rapportVisite.rapMotif != null) {
            return false;
        }
        if (rapBilan != null ? !rapBilan.equals(rapportVisite.rapBilan) : rapportVisite.rapBilan != null) {
            return false;
        }
        if (visiteurVisMat != null ? !visiteurVisMat.equals(rapportVisite.visiteurVisMat) : rapportVisite.visiteurVisMat != null) {
            return false;
        }
        if (praticienPraNum != null ? !praticienPraNum.equals(rapportVisite.praticienPraNum) : rapportVisite.praticienPraNum != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (rapNum != null ? rapNum.hashCode() : 0);
        result = 31 * result + (rapDate != null ? rapDate.hashCode() : 0);
        result = 31 * result + (rapMotif != null ? rapMotif.hashCode() : 0);
        result = 31 * result + (rapBilan != null ? rapBilan.hashCode() : 0);
        result = 31 * result + (visiteurVisMat != null ? visiteurVisMat.hashCode() : 0);
        result = 31 * result + (praticienPraNum != null ? praticienPraNum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RapportVisite{"
                + "rapNum='" + rapNum + '\''
                + ", rapDate='" + rapDate + '\''
                + ", rapMotif='" + rapMotif + '\''
                + ", rapBilan='" + rapBilan + '\''
                + ", visiteurVisMat='" + visiteurVisMat + '\''
                + ", praticienPraNum='" + praticienPraNum + '\''
                + '}';
    }
}
