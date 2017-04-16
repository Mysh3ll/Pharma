package fr.btssio.pharma.orm.gen;

public interface VisiteurDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<Visiteur> {

    /**
     * Table expression class representing table Visiteur
     */
    class VisiteurTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        VisiteurTableExpression() {
            super("Visiteur");
            addColumn("vis_mat", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("vis_nom", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("vis_prenom", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("vis_adresse", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("vis_cp", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("vis_ville", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("vis_dateemb", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table Visiteur
     */
    class VisiteurResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<Visiteur> {
        @Override
        public java.util.List<Visiteur>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Visiteur> ret = new java.util.LinkedList<Visiteur>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Visiteur obj = new Visiteur();
                if (!cursor.isNull(0)) {
                    obj.setVisMat(cursor.getString(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setVisNom(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setVisPrenom(cursor.getString(2));
                }
                if (!cursor.isNull(3)) {
                    obj.setVisAdresse(cursor.getString(3));
                }
                if (!cursor.isNull(4)) {
                    obj.setVisCp(cursor.getInt(4));
                }
                if (!cursor.isNull(5)) {
                    obj.setVisVille(cursor.getString(5));
                }
                if (!cursor.isNull(6)) {
                    obj.setVisDateemb(cursor.getString(6));
                }
                ret.add(obj);
                cursor.moveToNext();
            }
            return ret;
        }
    }

    /**
     * Corresponding POJO class.
     */
    Class<Visiteur> POJO_CLASS = Visiteur.class;
    /**
     * Table expression for the table.
     */
    VisiteurTableExpression TABLE_EXPRESSION = new VisiteurTableExpression();
    /**
     * Result set handler for the table.
     */
    VisiteurResultSetHandler RESULT_SET_HANDLER = new VisiteurResultSetHandler();
    /**
     * Column object representing column vis_mat
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_MAT = TABLE_EXPRESSION.getColumn("vis_mat");
    /**
     * Column object representing column vis_nom
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_NOM = TABLE_EXPRESSION.getColumn("vis_nom");
    /**
     * Column object representing column vis_prenom
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_PRENOM = TABLE_EXPRESSION.getColumn("vis_prenom");
    /**
     * Column object representing column vis_adresse
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_ADRESSE = TABLE_EXPRESSION.getColumn("vis_adresse");
    /**
     * Column object representing column vis_cp
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_CP = TABLE_EXPRESSION.getColumn("vis_cp");
    /**
     * Column object representing column vis_ville
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_VILLE = TABLE_EXPRESSION.getColumn("vis_ville");
    /**
     * Column object representing column vis_dateemb
     */
    fr.btssio.pharma.orm.runtime.query.Column VIS_DATEEMB = TABLE_EXPRESSION.getColumn("vis_dateemb");

    /**
     * Returns all rows from table Visiteur
     * @return all rows from table funkcja.
     */
    java.util.List<Visiteur> getVisiteurList();

    /**
     * Returns all rows from table Visiteur
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Visiteur
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Visiteur matching given where clause
     * @param where where clause
     * @return all rows from table Visiteur matching given where clause
     */
    java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Visiteur matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Visiteur matching given where clause
     */
    java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Visiteur matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Visiteur matching given where clause
     */
    java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Visiteur based on value of primary key
     * @return row from table Visiteur
     */
    Visiteur getByVisMat(String visMat);

    /**
     * Returns row from table Visiteur referenced by given row from table Rapport_Visite
     * @param rapportVisite object representing row referencing row from table Rapport_Visite
     * @return row from table Visiteur referenced by given row from table Rapport_Visite
     */
    Visiteur getVisiteur(RapportVisite rapportVisite);

    /**
     * Returns number of all rows in table.
     * @return number of all rows in table
     */
    Long getCount();

    /**
     * Returns number of rows according to given WHERE query.
     * @param where where query
     * @return number of rows
     */
    Long getCount(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Inserts row into table Visiteur
     * @param visiteur visiteur to be inserted.
     * @return id number of new row
     */
    long insert(Visiteur visiteur);

    /**
     * Inserts collection of rows into table Visiteur
     * @param visiteurs rows to be inserted
     */
    void insert(java.util.Collection<Visiteur> visiteurs);

    /**
     * Updates row in table Visiteur
     * @param visiteur visiteur to be updated.
     */
    void update(Visiteur visiteur);

    /**
     * Updates collection of rows in table Visiteur
     * @param visiteurs rows to be update
     */
    void update(java.util.Collection<Visiteur> visiteurs);

    /**
     * Deletes row from table Visiteur
     * @param visiteur visiteur to be deleted.
     */
    void delete(Visiteur visiteur);

    /**
     * Deletes row from table Visiteur based on primary key
     */
    void delete(String visMat);

    /**
     * Deletes collection of rows from table Visiteur
     * @param visiteurs rows to be deleted
     */
    void delete(java.util.Collection<Visiteur> visiteurs);

    /**
     * Deletes all rows from table Visiteur matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
