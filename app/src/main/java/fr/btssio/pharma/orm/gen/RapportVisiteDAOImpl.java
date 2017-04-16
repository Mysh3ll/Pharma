package fr.btssio.pharma.orm.gen;

public class RapportVisiteDAOImpl
        extends fr.btssio.pharma.orm.runtime.dao.BaseDAO<RapportVisite>
        implements RapportVisiteDAO {

    public RapportVisiteDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public RapportVisiteDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource,
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<RapportVisite> getPojoClass() {
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
    public java.util.List<RapportVisite> getRapportVisiteList() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public RapportVisite getByRapNum(Integer rapNum) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAP_NUM.eq(rapNum));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<RapportVisite> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public RapportVisite getRapportVisite(Offrir offrir) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAP_NUM.eq(offrir.getRapportVisiteRapNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<RapportVisite> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VISITEUR_VIS_MAT.eq(visiteur.getVisMat()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VISITEUR_VIS_MAT.eq(visiteur.getVisMat()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Visiteur visiteur,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VISITEUR_VIS_MAT.eq(visiteur.getVisMat()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRATICIEN_PRA_NUM.eq(praticien.getPraNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRATICIEN_PRA_NUM.eq(praticien.getPraNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(Praticien praticien,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(PRATICIEN_PRA_NUM.eq(praticien.getPraNum()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<RapportVisite> getRapportVisiteList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<RapportVisite>
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
    public long insert(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.InsertStatement query =
                new fr.btssio.pharma.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(RAP_NUM, rapportVisite.getRapNum());
        values.put(RAP_DATE, rapportVisite.getRapDate());
        values.put(RAP_MOTIF, rapportVisite.getRapMotif());
        values.put(RAP_BILAN, rapportVisite.getRapBilan());
        values.put(VISITEUR_VIS_MAT, rapportVisite.getVisiteurVisMat());
        values.put(PRATICIEN_PRA_NUM, rapportVisite.getPraticienPraNum());

        query.setValues(values);

        long id = insert(query);

        rapportVisite.setRapNum(new Long(id).intValue());

        return id;
    }

    @Override
    public void insert(java.util.Collection<RapportVisite> rapportVisites) {
        for(RapportVisite obj : rapportVisites) {
            insert(obj);
        }
    }

    @Override
    public void update(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.UpdateStatement query =
                new fr.btssio.pharma.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(RAP_NUM, rapportVisite.getRapNum());
        values.put(RAP_DATE, rapportVisite.getRapDate());
        values.put(RAP_MOTIF, rapportVisite.getRapMotif());
        values.put(RAP_BILAN, rapportVisite.getRapBilan());
        values.put(VISITEUR_VIS_MAT, rapportVisite.getVisiteurVisMat());
        values.put(PRATICIEN_PRA_NUM, rapportVisite.getPraticienPraNum());

        query.setValues(values);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(RapportVisiteDAO.RAP_NUM,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(rapportVisite.getRapNum())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<RapportVisite> rapportVisites) {
        for(RapportVisite obj : rapportVisites) {
            update(obj);
        }
    }

    @Override
    public void delete(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(RapportVisiteDAO.RAP_NUM,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(rapportVisite.getRapNum())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(Integer rapNum) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(RAP_NUM.eq(rapNum));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<RapportVisite> rapportVisites) {
        for(RapportVisite obj : rapportVisites) {
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
