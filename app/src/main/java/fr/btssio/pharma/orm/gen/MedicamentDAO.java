package fr.btssio.pharma.orm.gen;

public interface MedicamentDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<Medicament> {

    /**
     * Table expression class representing table Medicament
     */
    class MedicamentTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        MedicamentTableExpression() {
            super("Medicament");
            addColumn("med_depotlegal", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("med_nomcom", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("med_compo", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("med_effets", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("med_contreind", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("Famille_fam_code", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
        }
    }

    /**
     * Result set handler class for table Medicament
     */
    class MedicamentResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<Medicament> {
        @Override
        public java.util.List<Medicament>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Medicament> ret = new java.util.LinkedList<Medicament>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Medicament obj = new Medicament();
                if (!cursor.isNull(0)) {
                    obj.setMedDepotlegal(cursor.getString(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setMedNomcom(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setMedCompo(cursor.getString(2));
                }
                if (!cursor.isNull(3)) {
                    obj.setMedEffets(cursor.getString(3));
                }
                if (!cursor.isNull(4)) {
                    obj.setMedContreind(cursor.getString(4));
                }
                if (!cursor.isNull(5)) {
                    obj.setFamilleFamCode(cursor.getString(5));
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
    Class<Medicament> POJO_CLASS = Medicament.class;
    /**
     * Table expression for the table.
     */
    MedicamentTableExpression TABLE_EXPRESSION = new MedicamentTableExpression();
    /**
     * Result set handler for the table.
     */
    MedicamentResultSetHandler RESULT_SET_HANDLER = new MedicamentResultSetHandler();
    /**
     * Column object representing column med_depotlegal
     */
    fr.btssio.pharma.orm.runtime.query.Column MED_DEPOTLEGAL = TABLE_EXPRESSION.getColumn("med_depotlegal");
    /**
     * Column object representing column med_nomcom
     */
    fr.btssio.pharma.orm.runtime.query.Column MED_NOMCOM = TABLE_EXPRESSION.getColumn("med_nomcom");
    /**
     * Column object representing column med_compo
     */
    fr.btssio.pharma.orm.runtime.query.Column MED_COMPO = TABLE_EXPRESSION.getColumn("med_compo");
    /**
     * Column object representing column med_effets
     */
    fr.btssio.pharma.orm.runtime.query.Column MED_EFFETS = TABLE_EXPRESSION.getColumn("med_effets");
    /**
     * Column object representing column med_contreind
     */
    fr.btssio.pharma.orm.runtime.query.Column MED_CONTREIND = TABLE_EXPRESSION.getColumn("med_contreind");
    /**
     * Column object representing column Famille_fam_code
     */
    fr.btssio.pharma.orm.runtime.query.Column FAMILLE_FAM_CODE = TABLE_EXPRESSION.getColumn("Famille_fam_code");

    /**
     * Returns all rows from table Medicament
     * @return all rows from table funkcja.
     */
    java.util.List<Medicament> getMedicamentList();

    /**
     * Returns all rows from table Medicament
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Medicament> getMedicamentList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Medicament
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Medicament> getMedicamentList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Medicament matching given where clause
     * @param where where clause
     * @return all rows from table Medicament matching given where clause
     */
    java.util.List<Medicament> getMedicamentList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Medicament matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Medicament matching given where clause
     */
    java.util.List<Medicament> getMedicamentList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Medicament matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Medicament matching given where clause
     */
    java.util.List<Medicament> getMedicamentList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Medicament based on value of primary key
     * @return row from table Medicament
     */
    Medicament getByMedDepotlegal(String medDepotlegal);

    /**
     * Returns list of rows from table Medicament referencing given row from table Famille
     * @param famille object representing row from referenced by rows from table Medicament
     * @return list of rows from table Medicament referencing given row from table Famille
     */
    java.util.List<Medicament> getMedicamentList(Famille famille);

    /**
     * Returns list of rows from table Medicament referencing given row from table Famille
     * @param famille object representing row from referenced by rows from table Medicament
     * @param orderBy column to sort by
     * @return list of rows from table Medicament referencing given row from table Famille
     */
    java.util.List<Medicament> getMedicamentList(Famille famille, fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns list of rows from table Medicament referencing given row from table Famille
     * @param famille object representing row from referenced by rows from table Medicament
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return list of rows from table Medicament referencing given row from table Famille
     */
    java.util.List<Medicament> getMedicamentList(Famille famille, fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Medicament referenced by given row from table Offrir
     * @param offrir object representing row referencing row from table Offrir
     * @return row from table Medicament referenced by given row from table Offrir
     */
    Medicament getMedicament(Offrir offrir);

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
     * Inserts row into table Medicament
     * @param medicament medicament to be inserted.
     * @return id number of new row
     */
    long insert(Medicament medicament);

    /**
     * Inserts collection of rows into table Medicament
     * @param medicaments rows to be inserted
     */
    void insert(java.util.Collection<Medicament> medicaments);

    /**
     * Updates row in table Medicament
     * @param medicament medicament to be updated.
     */
    void update(Medicament medicament);

    /**
     * Updates collection of rows in table Medicament
     * @param medicaments rows to be update
     */
    void update(java.util.Collection<Medicament> medicaments);

    /**
     * Deletes row from table Medicament
     * @param medicament medicament to be deleted.
     */
    void delete(Medicament medicament);

    /**
     * Deletes row from table Medicament based on primary key
     */
    void delete(String medDepotlegal);

    /**
     * Deletes collection of rows from table Medicament
     * @param medicaments rows to be deleted
     */
    void delete(java.util.Collection<Medicament> medicaments);

    /**
     * Deletes all rows from table Medicament matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
