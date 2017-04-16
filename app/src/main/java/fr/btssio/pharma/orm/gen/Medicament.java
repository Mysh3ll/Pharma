package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Medicament.
 */
public class Medicament implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -8077746565135085330L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<MedicamentDAO> DAO_INTERFACE_CLASS = MedicamentDAO.class;
    /**
     * Property representing column med_depotlegal
     */
    protected String medDepotlegal;
    /**
     * Property representing column med_nomcom
     */
    protected String medNomcom;
    /**
     * Property representing column med_compo
     */
    protected String medCompo;
    /**
     * Property representing column med_effets
     */
    protected String medEffets;
    /**
     * Property representing column med_contreind
     */
    protected String medContreind;
    /**
     * Property representing column Famille_fam_code
     */
    protected String familleFamCode;

    /**
     * Default constructor.
     */
    public Medicament() {
    }

    /**
     * All columns constructor.
     * @param medDepotlegal value of column med_depotlegal.
     * @param medNomcom value of column med_nomcom.
     * @param medCompo value of column med_compo.
     * @param medEffets value of column med_effets.
     * @param medContreind value of column med_contreind.
     * @param familleFamCode value of column Famille_fam_code.
     */
    public Medicament(String medDepotlegal, String medNomcom, String medCompo, String medEffets, String medContreind, String familleFamCode) {
        setMedDepotlegal(medDepotlegal);
        setMedNomcom(medNomcom);
        setMedCompo(medCompo);
        setMedEffets(medEffets);
        setMedContreind(medContreind);
        setFamilleFamCode(familleFamCode);
    }

    /**
     * Returns value of property {@link #medDepotlegal}.
     * @return value of property {@link #medDepotlegal}.
     */
    public String getMedDepotlegal() {
        return this.medDepotlegal;
    }
    /**
     * Sets new value of property {@link #medDepotlegal}.
     * @param medDepotlegal new value of property {@link #medDepotlegal}.
     */
    public void setMedDepotlegal(String medDepotlegal) {
        this.medDepotlegal = medDepotlegal;
    }
    /**
     * Returns value of property {@link #medNomcom}.
     * @return value of property {@link #medNomcom}.
     */
    public String getMedNomcom() {
        return this.medNomcom;
    }
    /**
     * Sets new value of property {@link #medNomcom}.
     * @param medNomcom new value of property {@link #medNomcom}.
     */
    public void setMedNomcom(String medNomcom) {
        this.medNomcom = medNomcom;
    }
    /**
     * Returns value of property {@link #medCompo}.
     * @return value of property {@link #medCompo}.
     */
    public String getMedCompo() {
        return this.medCompo;
    }
    /**
     * Sets new value of property {@link #medCompo}.
     * @param medCompo new value of property {@link #medCompo}.
     */
    public void setMedCompo(String medCompo) {
        this.medCompo = medCompo;
    }
    /**
     * Returns value of property {@link #medEffets}.
     * @return value of property {@link #medEffets}.
     */
    public String getMedEffets() {
        return this.medEffets;
    }
    /**
     * Sets new value of property {@link #medEffets}.
     * @param medEffets new value of property {@link #medEffets}.
     */
    public void setMedEffets(String medEffets) {
        this.medEffets = medEffets;
    }
    /**
     * Returns value of property {@link #medContreind}.
     * @return value of property {@link #medContreind}.
     */
    public String getMedContreind() {
        return this.medContreind;
    }
    /**
     * Sets new value of property {@link #medContreind}.
     * @param medContreind new value of property {@link #medContreind}.
     */
    public void setMedContreind(String medContreind) {
        this.medContreind = medContreind;
    }
    /**
     * Returns value of property {@link #familleFamCode}.
     * @return value of property {@link #familleFamCode}.
     */
    public String getFamilleFamCode() {
        return this.familleFamCode;
    }
    /**
     * Sets new value of property {@link #familleFamCode}.
     * @param familleFamCode new value of property {@link #familleFamCode}.
     */
    public void setFamilleFamCode(String familleFamCode) {
        this.familleFamCode = familleFamCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Medicament medicament = (Medicament) o;

        if (medDepotlegal != null ? !medDepotlegal.equals(medicament.medDepotlegal) : medicament.medDepotlegal != null) {
            return false;
        }
        if (medNomcom != null ? !medNomcom.equals(medicament.medNomcom) : medicament.medNomcom != null) {
            return false;
        }
        if (medCompo != null ? !medCompo.equals(medicament.medCompo) : medicament.medCompo != null) {
            return false;
        }
        if (medEffets != null ? !medEffets.equals(medicament.medEffets) : medicament.medEffets != null) {
            return false;
        }
        if (medContreind != null ? !medContreind.equals(medicament.medContreind) : medicament.medContreind != null) {
            return false;
        }
        if (familleFamCode != null ? !familleFamCode.equals(medicament.familleFamCode) : medicament.familleFamCode != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (medDepotlegal != null ? medDepotlegal.hashCode() : 0);
        result = 31 * result + (medNomcom != null ? medNomcom.hashCode() : 0);
        result = 31 * result + (medCompo != null ? medCompo.hashCode() : 0);
        result = 31 * result + (medEffets != null ? medEffets.hashCode() : 0);
        result = 31 * result + (medContreind != null ? medContreind.hashCode() : 0);
        result = 31 * result + (familleFamCode != null ? familleFamCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicament{"
                + "medDepotlegal='" + medDepotlegal + '\''
                + ", medNomcom='" + medNomcom + '\''
                + ", medCompo='" + medCompo + '\''
                + ", medEffets='" + medEffets + '\''
                + ", medContreind='" + medContreind + '\''
                + ", familleFamCode='" + familleFamCode + '\''
                + '}';
    }
}
