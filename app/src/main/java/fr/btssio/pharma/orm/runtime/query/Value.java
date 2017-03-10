package fr.btssio.pharma.orm.runtime.query;

import java.util.List;

/**
 * Represents literal arithmetical expression.
 */
public class Value extends AExp {

    /**
     * Value of the expression
     */
    private Object value;

    /**
     * SQLite type of the value
     */
    private fr.btssio.pharma.orm.runtime.util.SQLiteType type;

    public Value(Object value, fr.btssio.pharma.orm.runtime.util.SQLiteType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void build(StringBuilder sb, List<Value> objects) {
        sb.append(QUESTION_MARK);
        objects.add(this);
    }

    public Object getValue() {
        return value;
    }

    public fr.btssio.pharma.orm.runtime.util.SQLiteType getType() {
        return type;
    }
}
