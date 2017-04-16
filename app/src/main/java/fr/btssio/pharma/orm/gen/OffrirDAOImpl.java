package fr.btssio.pharma.orm.gen;

public class OffrirDAOImpl
        extends fr.btssio.pharma.orm.runtime.dao.BaseDAO<Offrir>
        implements OffrirDAO {

    public OffrirDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public OffrirDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource,
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Offrir> getPojoClass() {
        return POJO_CLASS;
    }

    @Override
    public fr.btssio.pharma.orm.runtime.query.TableExpression getTableExpression() {
        return TABLE_EXPRESSION;
    }

    @Override
    public fr.btssio.pharma.orm.runtime.util.ResultSetHandler getResultSetHandler() {
        return RESULT_SET_HANDLER;
    }

    @Override
    public java.util.List<Offrir> getOffrirList() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(Medicament medicament) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(MEDICAMENT_MED_DEPOTLEGAL.eq(medicament.getMedDepotlegal()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(Medicament medicament,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(MEDICAMENT_MED_DEPOTLEGAL.eq(medicament.getMedDepotlegal()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(Medicament medicament,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(MEDICAMENT_MED_DEPOTLEGAL.eq(medicament.getMedDepotlegal()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAPPORT_VISITE_RAP_NUM.eq(rapportVisite.getRapNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAPPORT_VISITE_RAP_NUM.eq(rapportVisite.getRapNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(RapportVisite rapportVisite,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAPPORT_VISITE_RAP_NUM.eq(rapportVisite.getRapNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Offrir> getOffrirList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Offrir>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Long getCount() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION,
                fr.btssio.pharma.orm.runtime.query.AExp.fun("COUNT",
                        fr.btssio.pharma.orm.runtime.query.AExp.ASTERISK));
        java.util.List<Long> list = select(query, new fr.btssio.pharma.orm.runtime.util.handlers.LongResultSetHandler()).getObjectList();
        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new RuntimeException("Cannot retrieve count() method result");
        }
    }

    @Override
    public Long getCount(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION,
                fr.btssio.pharma.orm.runtime.query.AExp.fun("COUNT",
                        fr.btssio.pharma.orm.runtime.query.AExp.ASTERISK));
        query.setWhere(where);
        java.util.List<Long> list = select(query, new fr.btssio.pharma.orm.runtime.util.handlers.LongResultSetHandler()).getObjectList();
        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new RuntimeException("Cannot retrieve count() method result");
        }
    }

    @Override
    public long insert(Offrir offrir) {
        fr.btssio.pharma.orm.runtime.query.InsertStatement query =
                new fr.btssio.pharma.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(OFF_QTE, offrir.getOffQte());
        values.put(MEDICAMENT_MED_DEPOTLEGAL, offrir.getMedicamentMedDepotlegal());
        values.put(RAPPORT_VISITE_RAP_NUM, offrir.getRapportVisiteRapNum());

        query.setValues(values);

        long id = insert(query);


        return id;
    }

    @Override
    public void insert(java.util.Collection<Offrir> offrirs) {
        for(Offrir obj : offrirs) {
            insert(obj);
        }
    }

    @Override
    public void delete(Offrir offrir) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(OffrirDAO.OFF_QTE,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(offrir.getOffQte())));
        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(OffrirDAO.MEDICAMENT_MED_DEPOTLEGAL,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(offrir.getMedicamentMedDepotlegal())));
        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(OffrirDAO.RAPPORT_VISITE_RAP_NUM,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(offrir.getRapportVisiteRapNum())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Offrir> offrirs) {
        for(Offrir obj : offrirs) {
            delete(obj);
        }
    }

    @Override
    public void delete(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        query.setWhere(where);

        delete(query);
    }
}
