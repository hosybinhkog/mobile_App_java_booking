package SQLITE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import SQLITEModel.Category;

public class CRUDMethod {
    private CategorySQLiteHelper dbHelper;
    private SQLiteDatabase database;
    private String[] allColumns = {CategorySQLiteHelper.COLUMN_ID, CategorySQLiteHelper.COLUMN_NAMECATEGORY};

    public  CRUDMethod(Context context){
        dbHelper = new CategorySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public  void close() {
        dbHelper.close();
    }

    public Category createCategory(String nameCategory){
        ContentValues values = new ContentValues();
        values.put(dbHelper.COLUMN_NAMECATEGORY,nameCategory);
        long insertId = database.insert(dbHelper.TABLE_CATEGORY, null , values);
        Cursor cursor = database.query(dbHelper.TABLE_CATEGORY,allColumns,dbHelper.COLUMN_ID + " = "
            + insertId , null,null,null,null);
        cursor.moveToFirst();
        Category newCategory = cursorToCategory(cursor);
        cursor.close();
        return  newCategory;
    }



    public void deleteCategory(Category category){
        int id = category.get_id();
        Log.e("SQLite","Category is deleted with id " + category.getNameCategory());
        database.delete(dbHelper.TABLE_CATEGORY, dbHelper.COLUMN_ID + " = " +id, null);
    }

    private Category cursorToCategory(Cursor cursor) {
        Category category = new Category();
        category.set_id(cursor.getInt(0));
        category.setNameCategory(cursor.getString(1));
        return  category;
    }


}
