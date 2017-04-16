package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Offrir.
 */
public class Offrir implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -4084709047662146728L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<OffrirDAO> DAO_INTERFACE_CLASS = OffrirDAO.class;
    /**
     * Property representing column off_qte
     */
    protected Integer offQte;
    /**
     * Property representing column Medicament_med_depotlegal
     */
    protected String medicamentMedDepotlegal;
    /**
     * Property representing column Rapport_Visite_rap_num
     */
    protected Integer rapportVisiteRapNum;

    /**
     * Default constructor.
     */
    public Offrir() {
    }

    /**
     * All columns constructor.
     * @param offQte value of column off_qte.
     * @param medicamentMedDepotlegal value of column Medicament_med_depotlegal.
     * @param rapportVisiteRapNum value of column Rapport_Visite_rap_num.
     */
    public Offrir(Integer offQte, String medicamentMedDepotlegal, Integer rapportVisiteRapNum) {
        setOffQte(offQte);
        setMedicamentMedDepotlegal(medicamentMedDepotlegal);
        setRapportVisiteRapNum(rapportVisiteRapNum);
    }

    /**
     * Returns value of property {@link #offQte}.
     * @return value of property {@link #offQte}.
     */
    public Integer getOffQte() {
        return this.offQte;
    }
    /**
     * Sets new value of property {@link #offQte}.
     * @param offQte new value of property {@link #offQte}.
     */
    public void setOffQte(Integer offQte) {
        this.offQte = offQte;
    }
    /**
     * Returns value of property {@link #medicamentMedDepotlegal}.
     * @return value of property {@link #medicamentMedDepotlegal}.
     */
    public String getMedicamentMedDepotlegal() {
        return this.medicamentMedDepotlegal;
    }
    /**
     * Sets new value of property {@link #medicamentMedDepotlegal}.
     * @param medicamentMedDepotlegal new value of property {@link #medicamentMedDepotlegal}.
     */
    public void setMedicamentMedDepotlegal(String medicamentMedDepotlegal) {
        this.medicamentMedDepotlegal = medicamentMedDepotlegal;
    }
    /**
     * Returns value of property {@link #rapportVisiteRapNum}.
     * @return value of property {@link #rapportVisiteRapNum}.
     */
    public Integer getRapportVisiteRapNum() {
        return this.rapportVisiteRapNum;
    }
    /**
     * Sets new value of property {@link #rapportVisiteRapNum}.
     * @param rapportVisiteRapNum new value of property {@link #rapportVisiteRapNum}.
     */
    public void setRapportVisiteRapNum(Integer rapportVisiteRapNum) {
        this.rapportVisiteRapNum = rapportVisiteRapNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Offrir offrir = (Offrir) o;

        if (offQte != null ? !offQte.equals(offrir.offQte) : offrir.offQte != null) {
            return false;
        }
        if (medicamentMedDepotlegal != null ? !medicamentMedDepotlegal.equals(offrir.medicamentMedDepotlegal) : offrir.medicamentMedDepotlegal != null) {
            return false;
        }
        if (rapportVisiteRapNum != null ? !rapportVisiteRapNum.equals(offrir.rapportVisiteRapNum) : offrir.rapportVisiteRapNum != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (offQte != null ? offQte.hashCode() : 0);
        result = 31 * result + (medicamentMedDepotlegal != null ? medicamentMedDepotlegal.hashCode() : 0);
        result = 31 * result + (rapportVisiteRapNum != null ? rapportVisiteRapNum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Offrir{"
                + "offQte='" + offQte + '\''
                + ", medicamentMedDepotlegal='" + medicamentMedDepotlegal + '\''
                + ", rapportVisiteRapNum='" + rapportVisiteRapNum + '\''
                + '}';
    }
}
