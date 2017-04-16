package fr.btssio.pharma.orm.gen;

public interface OffrirDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<Offrir> {

    /**
     * Table expression class representing table Offrir
     */
    class OffrirTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        OffrirTableExpression() {
            super("Offrir");
            addColumn("off_qte", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER);
            addColumn("Medicament_med_depotlegal", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT);
            addColumn("Rapport_Visite_rap_num", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER);
        }
    }

    /**
     * Result set handler class for table Offrir
     */
    class OffrirResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<Offrir> {
        @Override
        public java.util.List<Offrir>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Offrir> ret = new java.util.LinkedList<Offrir>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Offrir obj = new Offrir();
                if (!cursor.isNull(0)) {
                    obj.setOffQte(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setMedicamentMedDepotlegal(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setRapportVisiteRapNum(cursor.getInt(2));
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
    Class<Offrir> POJO_CLASS = Offrir.class;
    /**
     * Table expression for the table.
     */
    OffrirTableExpression TABLE_EXPRESSION = new OffrirTableExpression();
    /**
     * Result set handler for the table.
     */
    OffrirResultSetHandler RESULT_SET_HANDLER = new OffrirResultSetHandler();
    /**
     * Column object representing column off_qte
     */
    fr.btssio.pharma.orm.runtime.query.Column OFF_QTE = TABLE_EXPRESSION.getColumn("off_qte");
    /**
     * Column object representing column Medicament_med_depotlegal
     */
    fr.btssio.pharma.orm.runtime.query.Column MEDICAMENT_MED_DEPOTLEGAL = TABLE_EXPRESSION.getColumn("Medicament_med_depotlegal");
    /**
     * Column object representing column Rapport_Visite_rap_num
     */
    fr.btssio.pharma.orm.runtime.query.Column RAPPORT_VISITE_RAP_NUM = TABLE_EXPRESSION.getColumn("Rapport_Visite_rap_num");

    /**
     * Returns all rows from table Offrir
     * @return all rows from table funkcja.
     */
    java.util.List<Offrir> getOffrirList();

    /**
     * Returns all rows from table Offrir
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Offrir
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Offrir matching given where clause
     * @param where where clause
     * @return all rows from table Offrir matching given where clause
     */
    java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Offrir matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Offrir matching given where clause
     */
    java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Offrir matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Offrir matching given where clause
     */
    java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns list of rows from table Offrir referencing given row from table Medicament
     * @param medicament object representing row from referenced by rows from table Offrir
     * @return list of rows from table Offrir referencing given row from table Medicament
     */
    java.util.List<Offrir> getOffrirList(Medicament medicament);

    /**
     * Returns list of rows from table Offrir referencing given row from table Medicament
     * @param medicament object representing row from referenced by rows from table Offrir
     * @param orderBy column to sort by
     * @return list of rows from table Offrir referencing given row from table Medicament
     */
    java.util.List<Offrir> getOffrirList(Medicament medicament, fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table Offrir referencing given row from table Medicament
     * @param medicament object representing row from referenced by rows from table Offrir
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table Offrir referencing given row from table Medicament
     */
    java.util.List<Offrir> getOffrirList(Medicament medicament, fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns list of rows from table Offrir referencing given row from table Rapport_Visite
     * @param rapportVisite object representing row from referenced by rows from table Offrir
     * @return list of rows from table Offrir referencing given row from table Rapport_Visite
     */
    java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite);

    /**
     * Returns list of rows from table Offrir referencing given row from table Rapport_Visite
     * @param rapportVisite object representing row from referenced by rows from table Offrir
     * @param orderBy column to sort by
     * @return list of rows from table Offrir referencing given row from table Rapport_Visite
     */
    java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite, fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table Offrir referencing given row from table Rapport_Visite
     * @param rapportVisite object representing row from referenced by rows from table Offrir
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table Offrir referencing given row from table Rapport_Visite
     */
    java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite, fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

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
     * Inserts row into table Offrir
     * @param offrir offrir to be inserted.
     * @return id number of new row
     */
    long insert(Offrir offrir);

    /**
     * Inserts collection of rows into table Offrir
     * @param offrirs rows to be inserted
     */
    void insert(java.util.Collection<Offrir> offrirs);

    /**
     * Deletes row from table Offrir
     * @param offrir offrir to be deleted.
     */
    void delete(Offrir offrir);

    /**
     * Deletes collection of rows from table Offrir
     * @param offrirs rows to be deleted
     */
    void delete(java.util.Collection<Offrir> offrirs);

    /**
     * Deletes all rows from table Offrir matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
