package fr.btssio.pharma.orm.runtime.util.handlers;

import android.database.Cursor;
import android.database.SQLException;
import fr.btssio.pharma.orm.runtime.util.ResultSetHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts first column of every row in cursor into List<Long>.
 */
public class LongResultSetHandler implements ResultSetHandler<Long> {
    @Override
    public List<Long> getObjects(Cursor cursor) throws SQLException {
        List<Long> ret = new LinkedList<Long>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ret.add(cursor.getLong(0));
            cursor.moveToNext();
        }
        return ret;
    }
}
