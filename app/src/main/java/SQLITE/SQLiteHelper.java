package SQLITE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import SQLITEModel.Category;
import SQLITEModel.Product;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "PAB.db";
    private static final  int DATABASE_VERSION = 1;

    public static final  String TABLE_CATEGORY = "category";
    public static final String COLUMN_ID = "_id";
    public static final  String COLUMN_NAMECATEGORY = "nameCategory";


    private static final String TAG = "SQLite";
    public static final  String TABLE_PRODUCT = "product";
    public static final String COLUMN_ID_PRODUCT = "_id";
    public static final  String COLUMN_NAME_PRODUCT = "nameProduct";
    public static final String COLUMN_ID_CATEGORY = "_idCategory";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_PRICE = "price";
    public static final  String COLUMN_DESCRIPTIONS = "descriptions";

    public static final String DROP_TABLE_CATEGORY =
            "DROP TABLE IF EXISTS " + TABLE_CATEGORY;
    public static final String DROP_TABLE_PRODUCT =
            "DROP TABLE IF EXISTS " + TABLE_PRODUCT;


    private static final String DATABASE_CREATE_CATEGORY = " create table "
            + TABLE_CATEGORY + "(" + COLUMN_ID
            + "integer primary key autoincrement ," + COLUMN_NAMECATEGORY
            + "text not null);";


    private static final String DATABASE_CREATE_PRODUCT = " create table "
            + TABLE_PRODUCT + "(" + COLUMN_ID_PRODUCT
            + "integer primary key autoincrement ," + COLUMN_NAME_PRODUCT
            + "text not null ," + COLUMN_PRICE + "interger ," + COLUMN_LOCATION +"text not null ,"
            + COLUMN_ID_CATEGORY + "interger not null,"
            + COLUMN_DESCRIPTIONS + "text not null ,"
            +"FOREIGN KEY (" +COLUMN_ID_CATEGORY +") REFERENCES category(id))";

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME , null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE_CATEGORY);
        sqLiteDatabase.execSQL(DATABASE_CREATE_PRODUCT);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v(SQLiteHelper.class.getName(),
                "Upgrade database form version" + oldVersion + " to " + newVersion
                    + "which will destroy all old data"
        );
        sqLiteDatabase.execSQL(DROP_TABLE_CATEGORY);
        sqLiteDatabase.execSQL(DROP_TABLE_PRODUCT);
        onCreate(sqLiteDatabase);
    }

    //// CATEGORY METHOD
    public void addCategory(Category category) {
        Log.i(TAG, "MyDatabaseHelper.addCategory ... " + category.getNameCategory());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMECATEGORY, category.getNameCategory());
        db.insert(TABLE_CATEGORY, null, values);

        db.close();
    }
    public Category getCategoryById(int id) {
        Log.i(TAG, "MyDatabaseHelper.getCategory ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCT, new String[] { COLUMN_ID, COLUMN_NAMECATEGORY}, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Category category = new Category(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1)
        );
        // return note
        return category;
    }

    public List<Category> getAllCategories() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<Category> categoriesList = new ArrayList<Category>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.set_id(Integer.parseInt(cursor.getString(0)));
                category.setNameCategory((cursor.getString(1)));

                // Adding note to list
                categoriesList.add(category);
            } while (cursor.moveToNext());
        }

        // return note list
        return categoriesList;
    }

    public int getCategoryCount() {
        Log.i(TAG, "MyDatabaseHelper.getCategoryCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_CATEGORY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public int updateCategory(Category category) {
        Log.i(TAG, "MyDatabaseHelper.updateCategory ... "  + category.getNameCategory());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMECATEGORY, category.getNameCategory());



        // updating row
        return db.update(TABLE_CATEGORY, values, COLUMN_ID_PRODUCT + " = ?",
                new String[]{String.valueOf(category.get_id())});
    }

    public void deleteCategory(Category category) {
        Log.i(TAG, "MyDatabaseHelper.deleteCategory ... " + category.getNameCategory());

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CATEGORY, COLUMN_ID_CATEGORY + " = ?",
                new String[] { String.valueOf(category.get_id()) });
        db.close();
    }


    /// PRODUCT METHOD
    public void addProduct(Product product) {
        Log.i(TAG, "MyDatabaseHelper.addProduct ... " + product.getNameProduct());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_PRODUCT, product.getNameProduct());
        values.put(COLUMN_ID_CATEGORY, product.get_idCategory());
        values.put(COLUMN_LOCATION, product.getLocation());
        values.put(COLUMN_PRICE,product.getPrice());
        values.put(COLUMN_DESCRIPTIONS,product.getDescriptions());

        db.insert(TABLE_PRODUCT, null, values);

        db.close();
    }

    public Product getProductById(int id) {
        Log.i(TAG, "MyDatabaseHelper.getProduct ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCT, new String[] { COLUMN_ID_PRODUCT,
                        COLUMN_NAME_PRODUCT,  COLUMN_ID_CATEGORY , COLUMN_LOCATION ,
                        COLUMN_PRICE , COLUMN_DESCRIPTIONS}, COLUMN_ID_PRODUCT + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(2)),
                cursor.getString(1),
                Double.parseDouble(cursor.getString(4)),
                cursor.getString(3),
                cursor.getString(5)
        );
        // return note
        return product;
    }

    public List<Product> getAllProducts() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<Product> productList = new ArrayList<Product>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.set_id(Integer.parseInt(cursor.getString(0)));
                product.set_idCategory(Integer.parseInt(cursor.getString(1)));
                product.setNameProduct(cursor.getString(2));
                product.setPrice(Double.parseDouble(cursor.getString(3)));
                product.setDescriptions(cursor.getString(4));
                product.setLocation(cursor.getString(5));

                // Adding note to list
                productList.add(product);
            } while (cursor.moveToNext());
        }

        // return note list
        return productList;
    }

    public int getProductCount() {
        Log.i(TAG, "MyDatabaseHelper.getProductCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }

    public int updateProduct(Product product) {
        Log.i(TAG, "MyDatabaseHelper.updateProduct ... "  + product.getNameProduct());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_PRODUCT, product.getNameProduct());
        values.put(COLUMN_DESCRIPTIONS, product.getDescriptions());
        values.put(COLUMN_PRICE,product.getPrice());
        values.put(COLUMN_ID_CATEGORY,product.get_idCategory());


        // updating row
        return db.update(TABLE_PRODUCT, values, COLUMN_ID_PRODUCT + " = ?",
                new String[]{String.valueOf(product.get_id())});
    }

    public void deleteProduct(Product product) {
        Log.i(TAG, "MyDatabaseHelper.deleteProduct ... " + product.getNameProduct() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCT, COLUMN_ID_PRODUCT + " = ?",
                new String[] { String.valueOf(product.get_id()) });
        db.close();
    }

}
