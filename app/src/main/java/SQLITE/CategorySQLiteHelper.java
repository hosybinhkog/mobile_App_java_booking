package SQLITE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class CategorySQLiteHelper extends SQLiteOpenHelper {

    public static final  String TABLE_CATEGORY = "category";
    public static final String COLUMN_ID = "_id";
    public static final  String COLUMN_NAMECATEGORY = "nameCategory";

    private static final  String DATABASE_NAME = "PAB.db";
    private static final  int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = " create table "
            + TABLE_CATEGORY + "(" + COLUMN_ID
            + "integer primary key autoincrement ," + COLUMN_NAMECATEGORY
            + "text not null);";

    public CategorySQLiteHelper(Context context){
        super(context, DATABASE_NAME , null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(CategorySQLiteHelper.class.getName(),
                "Upgrade database form version" + oldVersion + " to " + newVersion
                    + "which will destroy all old data"
        );
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_CATEGORY );
        onCreate(sqLiteDatabase);
    }
}
