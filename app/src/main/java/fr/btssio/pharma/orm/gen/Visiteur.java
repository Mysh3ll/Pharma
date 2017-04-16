package fr.btssio.pharma.orm.gen;

/**
 * POJO representing table Visiteur.
 */
public class Visiteur implements java.io.Serializable {

    /**
     * Serial verion UID
     */
    static final long serialVerionUID = -7127667860947469315L;
    /**
     * Corresponding DAO interface class.
     */
    public static final Class<VisiteurDAO> DAO_INTERFACE_CLASS = VisiteurDAO.class;
    /**
     * Property representing column vis_mat
     */
    protected String visMat;
    /**
     * Property representing column vis_nom
     */
    protected String visNom;
    /**
     * Property representing column vis_prenom
     */
    protected String visPrenom;
    /**
     * Property representing column vis_adresse
     */
    protected String visAdresse;
    /**
     * Property representing column vis_cp
     */
    protected Integer visCp;
    /**
     * Property representing column vis_ville
     */
    protected String visVille;
    /**
     * Property representing column vis_dateemb
     */
    protected String visDateemb;

    /**
     * Default constructor.
     */
    public Visiteur() {
    }

    /**
     * All columns constructor.
     * @param visMat value of column vis_mat.
     * @param visNom value of column vis_nom.
     * @param visPrenom value of column vis_prenom.
     * @param visAdresse value of column vis_adresse.
     * @param visCp value of column vis_cp.
     * @param visVille value of column vis_ville.
     * @param visDateemb value of column vis_dateemb.
     */
    public Visiteur(String visMat, String visNom, String visPrenom, String visAdresse, Integer visCp, String visVille, String visDateemb) {
        setVisMat(visMat);
        setVisNom(visNom);
        setVisPrenom(visPrenom);
        setVisAdresse(visAdresse);
        setVisCp(visCp);
        setVisVille(visVille);
        setVisDateemb(visDateemb);
    }

    /**
     * Returns value of property {@link #visMat}.
     * @return value of property {@link #visMat}.
     */
    public String getVisMat() {
        return this.visMat;
    }
    /**
     * Sets new value of property {@link #visMat}.
     * @param visMat new value of property {@link #visMat}.
     */
    public void setVisMat(String visMat) {
        this.visMat = visMat;
    }
    /**
     * Returns value of property {@link #visNom}.
     * @return value of property {@link #visNom}.
     */
    public String getVisNom() {
        return this.visNom;
    }
    /**
     * Sets new value of property {@link #visNom}.
     * @param visNom new value of property {@link #visNom}.
     */
    public void setVisNom(String visNom) {
        this.visNom = visNom;
    }
    /**
     * Returns value of property {@link #visPrenom}.
     * @return value of property {@link #visPrenom}.
     */
    public String getVisPrenom() {
        return this.visPrenom;
    }
    /**
     * Sets new value of property {@link #visPrenom}.
     * @param visPrenom new value of property {@link #visPrenom}.
     */
    public void setVisPrenom(String visPrenom) {
        this.visPrenom = visPrenom;
    }
    /**
     * Returns value of property {@link #visAdresse}.
     * @return value of property {@link #visAdresse}.
     */
    public String getVisAdresse() {
        return this.visAdresse;
    }
    /**
     * Sets new value of property {@link #visAdresse}.
     * @param visAdresse new value of property {@link #visAdresse}.
     */
    public void setVisAdresse(String visAdresse) {
        this.visAdresse = visAdresse;
    }
    /**
     * Returns value of property {@link #visCp}.
     * @return value of property {@link #visCp}.
     */
    public Integer getVisCp() {
        return this.visCp;
    }
    /**
     * Sets new value of property {@link #visCp}.
     * @param visCp new value of property {@link #visCp}.
     */
    public void setVisCp(Integer visCp) {
        this.visCp = visCp;
    }
    /**
     * Returns value of property {@link #visVille}.
     * @return value of property {@link #visVille}.
     */
    public String getVisVille() {
        return this.visVille;
    }
    /**
     * Sets new value of property {@link #visVille}.
     * @param visVille new value of property {@link #visVille}.
     */
    public void setVisVille(String visVille) {
        this.visVille = visVille;
    }
    /**
     * Returns value of property {@link #visDateemb}.
     * @return value of property {@link #visDateemb}.
     */
    public String getVisDateemb() {
        return this.visDateemb;
    }
    /**
     * Sets new value of property {@link #visDateemb}.
     * @param visDateemb new value of property {@link #visDateemb}.
     */
    public void setVisDateemb(String visDateemb) {
        this.visDateemb = visDateemb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Visiteur visiteur = (Visiteur) o;

        if (visMat != null ? !visMat.equals(visiteur.visMat) : visiteur.visMat != null) {
            return false;
        }
        if (visNom != null ? !visNom.equals(visiteur.visNom) : visiteur.visNom != null) {
            return false;
        }
        if (visPrenom != null ? !visPrenom.equals(visiteur.visPrenom) : visiteur.visPrenom != null) {
            return false;
        }
        if (visAdresse != null ? !visAdresse.equals(visiteur.visAdresse) : visiteur.visAdresse != null) {
            return false;
        }
        if (visCp != null ? !visCp.equals(visiteur.visCp) : visiteur.visCp != null) {
            return false;
        }
        if (visVille != null ? !visVille.equals(visiteur.visVille) : visiteur.visVille != null) {
            return false;
        }
        if (visDateemb != null ? !visDateemb.equals(visiteur.visDateemb) : visiteur.visDateemb != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (visMat != null ? visMat.hashCode() : 0);
        result = 31 * result + (visNom != null ? visNom.hashCode() : 0);
        result = 31 * result + (visPrenom != null ? visPrenom.hashCode() : 0);
        result = 31 * result + (visAdresse != null ? visAdresse.hashCode() : 0);
        result = 31 * result + (visCp != null ? visCp.hashCode() : 0);
        result = 31 * result + (visVille != null ? visVille.hashCode() : 0);
        result = 31 * result + (visDateemb != null ? visDateemb.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Visiteur{"
                + "visMat='" + visMat + '\''
                + ", visNom='" + visNom + '\''
                + ", visPrenom='" + visPrenom + '\''
                + ", visAdresse='" + visAdresse + '\''
                + ", visCp='" + visCp + '\''
                + ", visVille='" + visVille + '\''
                + ", visDateemb='" + visDateemb + '\''
                + '}';
    }
}
