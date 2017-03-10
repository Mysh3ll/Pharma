package fr.btssio.pharma.sqllite;

import android.content.Context;

import fr.btssio.pharma.R;
import fr.btssio.pharma.orm.runtime.util.SimpleSQLiteOpenHelper;

/**
 * Created by Michel on 10/03/2017.
 */

public class PharmaSQLiteOpenHelper extends SimpleSQLiteOpenHelper {

    private static final String DATABASE_NAME = "pharma";

    private static final int DATABASE_VERSION = 1;

    public PharmaSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void configure() {
        addCreationScript(R.raw.pharma_create);
    }
}
