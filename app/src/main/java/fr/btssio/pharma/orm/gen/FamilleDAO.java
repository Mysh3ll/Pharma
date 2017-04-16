package fr.btssio.pharma.orm.gen;

public interface FamilleDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<Famille> {

    /**
     * Table expression class representing table Famille
     */
    class FamilleTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        FamilleTableExpression() {
            super("Famille");
            addColumn("fam_code", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("fam_libelle", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table Famille
     */
    class FamilleResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<Famille> {
        @Override
        public java.util.List<Famille>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Famille> ret = new java.util.LinkedList<Famille>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Famille obj = new Famille();
                if (!cursor.isNull(0)) {
                    obj.setFamCode(cursor.getString(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setFamLibelle(cursor.getString(1));
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
    Class<Famille> POJO_CLASS = Famille.class;
    /**
     * Table expression for the table.
     */
    FamilleTableExpression TABLE_EXPRESSION = new FamilleTableExpression();
    /**
     * Result set handler for the table.
     */
    FamilleResultSetHandler RESULT_SET_HANDLER = new FamilleResultSetHandler();
    /**
     * Column object representing column fam_code
     */
    fr.btssio.pharma.orm.runtime.query.Column FAM_CODE = TABLE_EXPRESSION.getColumn("fam_code");
    /**
     * Column object representing column fam_libelle
     */
    fr.btssio.pharma.orm.runtime.query.Column FAM_LIBELLE = TABLE_EXPRESSION.getColumn("fam_libelle");

    /**
     * Returns all rows from table Famille
     * @return all rows from table funkcja.
     */
    java.util.List<Famille> getFamilleList();

    /**
     * Returns all rows from table Famille
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Famille
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Famille matching given where clause
     * @param where where clause
     * @return all rows from table Famille matching given where clause
     */
    java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Famille matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Famille matching given where clause
     */
    java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Famille matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Famille matching given where clause
     */
    java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Famille based on value of primary key
     * @return row from table Famille
     */
    Famille getByFamCode(String famCode);

    /**
     * Returns row from table Famille referenced by given row from table Medicament
     * @param medicament object representing row referencing row from table Medicament
     * @return row from table Famille referenced by given row from table Medicament
     */
    Famille getFamille(Medicament medicament);

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
     * Inserts row into table Famille
     * @param famille famille to be inserted.
     * @return id number of new row
     */
    long insert(Famille famille);

    /**
     * Inserts collection of rows into table Famille
     * @param familles rows to be inserted
     */
    void insert(java.util.Collection<Famille> familles);

    /**
     * Updates row in table Famille
     * @param famille famille to be updated.
     */
    void update(Famille famille);

    /**
     * Updates collection of rows in table Famille
     * @param familles rows to be update
     */
    void update(java.util.Collection<Famille> familles);

    /**
     * Deletes row from table Famille
     * @param famille famille to be deleted.
     */
    void delete(Famille famille);

    /**
     * Deletes row from table Famille based on primary key
     */
    void delete(String famCode);

    /**
     * Deletes collection of rows from table Famille
     * @param familles rows to be deleted
     */
    void delete(java.util.Collection<Famille> familles);

    /**
     * Deletes all rows from table Famille matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
