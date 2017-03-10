package fr.btssio.pharma.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import fr.btssio.pharma.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<Boolean>.
 */
public class BooleanResultSetHandler implements ResultSetHandler<Boolean> {
    @Override
    public List<Boolean> getObjects(Cursor cursor) throws SQLException {
        List<Boolean> ret = new LinkedList<Boolean>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getInt(0) > 0);
            cursor.moveToNext();
        }
        return ret;
    }
}
