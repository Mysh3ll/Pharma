package fr.btssio.pharma.orm.gen;

public class VisiteurDAOImpl
        extends fr.btssio.pharma.orm.runtime.dao.BaseDAO<Visiteur>
        implements VisiteurDAO {

    public VisiteurDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource) {
        super(dataSource);
    }

    public VisiteurDAOImpl(fr.btssio.pharma.orm.runtime.util.SQLiteDataSource dataSource,
            fr.btssio.pharma.orm.runtime.util.DAOMonitor daoMonitor) {
        super(dataSource, daoMonitor);
    }

    @Override
    public Class<Visiteur> getPojoClass() {
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
    public java.util.List<Visiteur> getVisiteurList() {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public Visiteur getByVisMat(String visMat) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VIS_MAT.eq(visMat));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Visiteur> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Visiteur getVisiteur(RapportVisite rapportVisite) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VIS_MAT.eq(rapportVisite.getVisiteurVisMat()));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        java.util.List<Visiteur> list = select(query, RESULT_SET_HANDLER).getObjectList();

        if (list.size() > 1) {
            throw new RuntimeException("More than one object returned");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
                selectObjectListResult = select(query, RESULT_SET_HANDLER);
        return selectObjectListResult.getObjectList();
    }

    @Override
    public java.util.List<Visiteur> getVisiteurList(fr.btssio.pharma.orm.runtime.query.LExp where,
            fr.btssio.pharma.orm.runtime.query.AExp orderBy, fr.btssio.pharma.orm.runtime.query.OrderByDirection asc) {
        fr.btssio.pharma.orm.runtime.query.SelectQuery query =
                new fr.btssio.pharma.orm.runtime.query.SelectQuery(TABLE_EXPRESSION);
        query.setWhere(where);
        query.orderBy(orderBy, asc);

        fr.btssio.pharma.orm.runtime.dao.SelectObjectListResult<Visiteur>
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
    public long insert(Visiteur visiteur) {
        fr.btssio.pharma.orm.runtime.query.InsertStatement query =
                new fr.btssio.pharma.orm.runtime.query.InsertStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(VIS_MAT, visiteur.getVisMat());
        values.put(VIS_NOM, visiteur.getVisNom());
        values.put(VIS_PRENOM, visiteur.getVisPrenom());
        values.put(VIS_ADRESSE, visiteur.getVisAdresse());
        values.put(VIS_CP, visiteur.getVisCp());
        values.put(VIS_VILLE, visiteur.getVisVille());
        values.put(VIS_DATEEMB, visiteur.getVisDateemb());

        query.setValues(values);

        long id = insert(query);


        return id;
    }

    @Override
    public void insert(java.util.Collection<Visiteur> visiteurs) {
        for(Visiteur obj : visiteurs) {
            insert(obj);
        }
    }

    @Override
    public void update(Visiteur visiteur) {
        fr.btssio.pharma.orm.runtime.query.UpdateStatement query =
                new fr.btssio.pharma.orm.runtime.query.UpdateStatement (TABLE_EXPRESSION);
        java.util.Map<fr.btssio.pharma.orm.runtime.query.Column, Object> values =
                new java.util.HashMap<fr.btssio.pharma.orm.runtime.query.Column, Object>();

        values.put(VIS_MAT, visiteur.getVisMat());
        values.put(VIS_NOM, visiteur.getVisNom());
        values.put(VIS_PRENOM, visiteur.getVisPrenom());
        values.put(VIS_ADRESSE, visiteur.getVisAdresse());
        values.put(VIS_CP, visiteur.getVisCp());
        values.put(VIS_VILLE, visiteur.getVisVille());
        values.put(VIS_DATEEMB, visiteur.getVisDateemb());

        query.setValues(values);

        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(VisiteurDAO.VIS_MAT,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(visiteur.getVisMat())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        update(query);
    }

    @Override
    public void update(java.util.Collection<Visiteur> visiteurs) {
        for(Visiteur obj : visiteurs) {
            update(obj);
        }
    }

    @Override
    public void delete(Visiteur visiteur) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(fr.btssio.pharma.orm.runtime.query.LExp.eq(VisiteurDAO.VIS_MAT,
                fr.btssio.pharma.orm.runtime.query.AExp.exp(visiteur.getVisMat())));
        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);

        delete(query);
    }

    @Override
    public void delete(String visMat) {
        fr.btssio.pharma.orm.runtime.query.DeleteStatement query =
                new fr.btssio.pharma.orm.runtime.query.DeleteStatement (TABLE_EXPRESSION);
        java.util.List<fr.btssio.pharma.orm.runtime.query.LExp> lExps =
                new java.util.LinkedList<fr.btssio.pharma.orm.runtime.query.LExp>();

        lExps.add(VIS_MAT.eq(visMat));

        fr.btssio.pharma.orm.runtime.query.LExp where = fr.btssio.pharma.orm.runtime.query.LExp.and(lExps);

        query.setWhere(where);
        delete(query);
    }

    @Override
    public void delete(java.util.Collection<Visiteur> visiteurs) {
        for(Visiteur obj : visiteurs) {
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
