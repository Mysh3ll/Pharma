package fr.btssio.pharma.orm.gen;

public interface PraticienDAO extends
        fr.btssio.pharma.orm.runtime.dao.DAO<Praticien> {

    /**
     * Table expression class representing table Praticien
     */
    class PraticienTableExpression extends fr.btssio.pharma.orm.runtime.query.TableExpression {
        /**
         * Default constructor.
         */
        PraticienTableExpression() {
            super("Praticien");
            addColumn("pra_num", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("pra_nom", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("pra_prenom", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("pra_adresse", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("pra_cp", fr.btssio.pharma.orm.runtime.util.SQLiteType.INTEGER, true);
            addColumn("pra_ville", fr.btssio.pharma.orm.runtime.util.SQLiteType.TEXT, true);
            addColumn("pra_coef", fr.btssio.pharma.orm.runtime.util.SQLiteType.NUMERIC, true);
        }
    }

    /**
     * Result set handler class for table Praticien
     */
    class PraticienResultSetHandler implements
            fr.btssio.pharma.orm.runtime.util.ResultSetHandler<Praticien> {
        @Override
        public java.util.List<Praticien>
                getObjects(android.database.Cursor cursor) {
            java.util.List<Praticien> ret = new java.util.LinkedList<Praticien>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Praticien obj = new Praticien();
                if (!cursor.isNull(0)) {
                    obj.setPraNum(cursor.getInt(0));
                }
                if (!cursor.isNull(1)) {
                    obj.setPraNom(cursor.getString(1));
                }
                if (!cursor.isNull(2)) {
                    obj.setPraPrenom(cursor.getString(2));
                }
                if (!cursor.isNull(3)) {
                    obj.setPraAdresse(cursor.getString(3));
                }
                if (!cursor.isNull(4)) {
                    obj.setPraCp(cursor.getInt(4));
                }
                if (!cursor.isNull(5)) {
                    obj.setPraVille(cursor.getString(5));
                }
                if (!cursor.isNull(6)) {
                    obj.setPraCoef(cursor.getFloat(6));
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
    Class<Praticien> POJO_CLASS = Praticien.class;
    /**
     * Table expression for the table.
     */
    PraticienTableExpression TABLE_EXPRESSION = new PraticienTableExpression();
    /**
     * Result set handler for the table.
     */
    PraticienResultSetHandler RESULT_SET_HANDLER = new PraticienResultSetHandler();
    /**
     * Column object representing column pra_num
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_NUM = TABLE_EXPRESSION.getColumn("pra_num");
    /**
     * Column object representing column pra_nom
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_NOM = TABLE_EXPRESSION.getColumn("pra_nom");
    /**
     * Column object representing column pra_prenom
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_PRENOM = TABLE_EXPRESSION.getColumn("pra_prenom");
    /**
     * Column object representing column pra_adresse
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_ADRESSE = TABLE_EXPRESSION.getColumn("pra_adresse");
    /**
     * Column object representing column pra_cp
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_CP = TABLE_EXPRESSION.getColumn("pra_cp");
    /**
     * Column object representing column pra_ville
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_VILLE = TABLE_EXPRESSION.getColumn("pra_ville");
    /**
     * Column object representing column pra_coef
     */
    fr.btssio.pharma.orm.runtime.query.Column PRA_COEF = TABLE_EXPRESSION.getColumn("pra_coef");

    /**
     * Returns all rows from table Praticien
     * @return all rows from table funkcja.
     */
    java.util.List<Praticien> getPraticienList();

    /**
     * Returns all rows from table Praticien
     * @param orderBy column to sort by
     * @return all rows from table funkcja.
     */
    java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Praticien
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table funkcja.
     */
    java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns all rows from table Praticien matching given where clause
     * @param where where clause
     * @return all rows from table Praticien matching given where clause
     */
    java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where);

    /**
     * Returns all rows from table Praticien matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @return all rows from table Praticien matching given where clause
     */
    java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy);

    /**
     * Returns all rows from table Praticien matching given where clause
     * @param where where clause
     * @param orderBy column to sort by
     * @param asc true to sort in ascending order, false otherwise
     * @return all rows from table Praticien matching given where clause
     */
    java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where, 
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc);

    /**
     * Returns row from table Praticien based on value of primary key
     * @return row from table Praticien
     */
    Praticien getByPraNum(Integer praNum);

    /**
     * Returns row from table Praticien referenced by given row from table Rapport_Visite
     * @param rapportVisite object representing row referencing row from table Rapport_Visite
     * @return row from table Praticien referenced by given row from table Rapport_Visite
     */
    Praticien getPraticien(RapportVisite rapportVisite);

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
     * Inserts row into table Praticien
     * @param praticien praticien to be inserted.
     * @return id number of new row
     */
    long insert(Praticien praticien);

    /**
     * Inserts collection of rows into table Praticien
     * @param praticiens rows to be inserted
     */
    void insert(java.util.Collection<Praticien> praticiens);

    /**
     * Updates row in table Praticien
     * @param praticien praticien to be updated.
     */
    void update(Praticien praticien);

    /**
     * Updates collection of rows in table Praticien
     * @param praticiens rows to be update
     */
    void update(java.util.Collection<Praticien> praticiens);

    /**
     * Deletes row from table Praticien
     * @param praticien praticien to be deleted.
     */
    void delete(Praticien praticien);

    /**
     * Deletes row from table Praticien based on primary key
     */
    void delete(Integer praNum);

    /**
     * Deletes collection of rows from table Praticien
     * @param praticiens rows to be deleted
     */
    void delete(java.util.Collection<Praticien> praticiens);

    /**
     * Deletes all rows from table Praticien matching given where clause
     * @param where where clause
     */
    void delete(fr.btssio.pharma.orm.runtime.query.LExp where);
}
