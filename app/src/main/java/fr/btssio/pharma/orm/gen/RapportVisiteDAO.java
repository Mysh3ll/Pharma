package fr.btssio.pharma.orm.gen;

public interface RapportVisiteDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<RapportVisite> {

    /**
     * Table expression class representing table Rapport_Visite
     */
    class RapportVisiteTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        RapportVisiteTableExpression() {
            super("Rapport_Visite");
            addColumn("rap_num", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("rap_date", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("rap_motif", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("rap_bilan", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("Visiteur_vis_mat", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("Praticien_pra_num", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER, true);
        }
    }

    /**
     * Result set handler class for table Rapport_Visite
     */
    class RapportVisiteResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<RapportVisite> {
        @Override
        public java.util.List<RapportVisite>
                getObjects(android.database.Cursor cursor) {
            java.util.List<RapportVisite> ret = new java.util.LinkedList<RapportVisite>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                RapportVisite obj = new RapportVisite();
                if (!cursor.isNull(0)) {
                    obj.setRapNum(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setRapDate(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setRapMotif(cursor.getString(2));
                }
                if (!cursor.isNull(3)) {
                    obj.setRapBilan(cursor.getString(3));
                }
                if (!cursor.isNull(4)) {
                    obj.setVisiteurVisMat(cursor.getString(4));
                }
                if (!cursor.isNull(5)) {
                    obj.setPraticienPraNum(cursor.getInt(5));
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
    Class<RapportVisite> POJO_CLASS = RapportVisite.class;
    /**
     * Table expression for the table.
     */
    RapportVisiteTableExpression TABLE_EXPRESSION = new RapportVisiteTableExpression();
    /**
     * Result set handler for the table.
     */
    RapportVisiteResultSetHandler RESULT_SET_HANDLER = new RapportVisiteResultSetHandler();
    /**
     * Column object representing column rap_num
     */
    fr.btssio.pharma.orm.runtime.query.Column RAP_NUM = TABLE_EXPRESSION.getColumn("rap_num");
    /**
     * Column object representing column rap_date
     */
    fr.btssio.pharma.orm.runtime.query.Column RAP_DATE = TABLE_EXPRESSION.getColumn("rap_date");
    /**
     * Column object representing column rap_motif
     */
    fr.btssio.pharma.orm.runtime.query.Column RAP_MOTIF = TABLE_EXPRESSION.getColumn("rap_motif");
    /**
     * Column object representing column rap_bilan
     */
    fr.btssio.pharma.orm.runtime.query.Column RAP_BILAN = TABLE_EXPRESSION.getColumn("rap_bilan");
    /**
     * Column object representing column Visiteur_vis_mat
     */
    fr.btssio.pharma.orm.runtime.query.Column VISITEUR_VIS_MAT = TABLE_EXPRESSION.getColumn("Visiteur_vis_mat");
    /**
     * Column object representing column Praticien_pra_num
     */
    fr.btssio.pharma.orm.runtime.query.Column PRATICIEN_PRA_NUM = TABLE_EXPRESSION.getColumn("Praticien_pra_num");

    /**
     * Returns all rows from table Rapport_Visite
     * @return all rows from table funkcja.
     */
    java.util.List<RapportVisite> getRapportVisiteList();

    /**
     * Returns all rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Rapport_Visite matching given where clause
     * @param where where clause
     * @return all rows from table Rapport_Visite matching given where clause
     */
    java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Rapport_Visite matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Rapport_Visite matching given where clause
     */
    java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Rapport_Visite matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Rapport_Visite matching given where clause
     */
    java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Rapport_Visite based on value of primary key
     * @return row from table Rapport_Visite
     */
    RapportVisite getByRapNum(Integer rapNum);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Visiteur
     * @param visiteur object representing row from referenced by rows from table Rapport_Visite
     * @return list of rows from table Rapport_Visite referencing given row from table Visiteur
     */
    java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Visiteur
     * @param visiteur object representing row from referenced by rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @return list of rows from table Rapport_Visite referencing given row from table Visiteur
     */
    java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur, fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Visiteur
     * @param visiteur object representing row from referenced by rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table Rapport_Visite referencing given row from table Visiteur
     */
    java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur, fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Praticien
     * @param praticien object representing row from referenced by rows from table Rapport_Visite
     * @return list of rows from table Rapport_Visite referencing given row from table Praticien
     */
    java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Praticien
     * @param praticien object representing row from referenced by rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @return list of rows from table Rapport_Visite referencing given row from table Praticien
     */
    java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien, fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table Rapport_Visite referencing given row from table Praticien
     * @param praticien object representing row from referenced by rows from table Rapport_Visite
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table Rapport_Visite referencing given row from table Praticien
     */
    java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien, fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Rapport_Visite referenced by given row from table Offrir
     * @param offrir object representing row referencing row from table Offrir
     * @return row from table Rapport_Visite referenced by given row from table Offrir
     */
    RapportVisite getRapportVisite(Offrir offrir);

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
     * Inserts row into table Rapport_Visite
     * @param rapportVisite rapportVisite to be inserted.
     * @return id number of new row
     */
    long insert(RapportVisite rapportVisite);

    /**
     * Inserts collection of rows into table Rapport_Visite
     * @param rapportVisites rows to be inserted
     */
    void insert(java.util.Collection<RapportVisite> rapportVisites);

    /**
     * Updates row in table Rapport_Visite
     * @param rapportVisite rapportVisite to be updated.
     */
    void update(RapportVisite rapportVisite);

    /**
     * Updates collection of rows in table Rapport_Visite
     * @param rapportVisites rows to be update
     */
    void update(java.util.Collection<RapportVisite> rapportVisites);

    /**
     * Deletes row from table Rapport_Visite
     * @param rapportVisite rapportVisite to be deleted.
     */
    void delete(RapportVisite rapportVisite);

    /**
     * Deletes row from table Rapport_Visite based on primary key
     */
    void delete(Integer rapNum);

    /**
     * Deletes collection of rows from table Rapport_Visite
     * @param rapportVisites rows to be deleted
     */
    void delete(java.util.Collection<RapportVisite> rapportVisites);

    /**
     * Deletes all rows from table Rapport_Visite matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
