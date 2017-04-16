package fr.btssio.pharma.orm.gen;

public class FamilleDAOImpl
        extends fr.btssio.pharma.orm.runtime.dao.BaseDAO<Famille>
        implements FamilleDAO {

    public FamilleDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public FamilleDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource,
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Famille> getPojoClass() {
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
    public java.util.List<Famille> getFamilleList() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Famille getByFamCode(String famCode) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(FAM_CODE.eq(famCode));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Famille> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Famille getFamille(Medicament medicament) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(FAM_CODE.eq(medicament.getFamilleFamCode()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Famille> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Famille> getFamilleList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Famille>
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
    public long insert(Famille famille) {
        fr.btssio.pharma.orm.runtime.query.InsertStatement query =
                new fr.btssio.pharma.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(FAM_CODE, famille.getFamCode());
        values.put(FAM_LIBELLE, famille.getFamLibelle());

        query.setValues(values);

        long id = insert(query);


        return id;
    }

    @Override
    public void insert(java.util.Collection<Famille> familles) {
        for(Famille obj : familles) {
            insert(obj);
        }
    }

    @Override
    public void update(Famille famille) {
        fr.btssio.pharma.orm.runtime.query.UpdateStatement query =
                new fr.btssio.pharma.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(FAM_CODE, famille.getFamCode());
        values.put(FAM_LIBELLE, famille.getFamLibelle());

        query.setValues(values);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(FamilleDAO.FAM_CODE,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(famille.getFamCode())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Famille> familles) {
        for(Famille obj : familles) {
            update(obj);
        }
    }

    @Override
    public void delete(Famille famille) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(FamilleDAO.FAM_CODE,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(famille.getFamCode())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(String famCode) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(FAM_CODE.eq(famCode));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Famille> familles) {
        for(Famille obj : familles) {
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
