package fr.btssio.pharma.orm.gen;

public class PraticienDAOImpl
        extends fr.btssio.pharma.orm.runtime.dao.BaseDAO<Praticien>
        implements PraticienDAO {

    public PraticienDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public PraticienDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource,
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Praticien> getPojoClass() {
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
    public java.util.List<Praticien> getPraticienList() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Praticien getByPraNum(Integer praNum) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRA_NUM.eq(praNum));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Praticien> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Praticien getPraticien(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRA_NUM.eq(rapportVisite.getPraticienPraNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Praticien> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Praticien> getPraticienList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Praticien>
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
    public long insert(Praticien praticien) {
        fr.btssio.pharma.orm.runtime.query.InsertStatement query =
                new fr.btssio.pharma.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(PRA_NUM, praticien.getPraNum());
        values.put(PRA_NOM, praticien.getPraNom());
        values.put(PRA_PRENOM, praticien.getPraPrenom());
        values.put(PRA_ADRESSE, praticien.getPraAdresse());
        values.put(PRA_CP, praticien.getPraCp());
        values.put(PRA_VILLE, praticien.getPraVille());
        values.put(PRA_COEF, praticien.getPraCoef());

        query.setValues(values);

        long id = insert(query);

        praticien.setPraNum(new Long(id).intValue());

        return id;
    }

    @Override
    public void insert(java.util.Collection<Praticien> praticiens) {
        for(Praticien obj : praticiens) {
            insert(obj);
        }
    }

    @Override
    public void update(Praticien praticien) {
        fr.btssio.pharma.orm.runtime.query.UpdateStatement query =
                new fr.btssio.pharma.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(PRA_NUM, praticien.getPraNum());
        values.put(PRA_NOM, praticien.getPraNom());
        values.put(PRA_PRENOM, praticien.getPraPrenom());
        values.put(PRA_ADRESSE, praticien.getPraAdresse());
        values.put(PRA_CP, praticien.getPraCp());
        values.put(PRA_VILLE, praticien.getPraVille());
        values.put(PRA_COEF, praticien.getPraCoef());

        query.setValues(values);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(PraticienDAO.PRA_NUM,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(praticien.getPraNum())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Praticien> praticiens) {
        for(Praticien obj : praticiens) {
            update(obj);
        }
    }

    @Override
    public void delete(Praticien praticien) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(PraticienDAO.PRA_NUM,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(praticien.getPraNum())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(Integer praNum) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRA_NUM.eq(praNum));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Praticien> praticiens) {
        for(Praticien obj : praticiens) {
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
