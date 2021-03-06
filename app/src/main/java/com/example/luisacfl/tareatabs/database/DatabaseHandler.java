package com.example.luisacfl.tareatabs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luisacfl on 16/10/17.
 */



public class DatabaseHandler extends SQLiteOpenHelper{

    // Table names
    public static final String TABLE_STORE = "store";
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_CITY = "city";
    public static final String TABLE_CATEGORY = "category";

    // Store
    public static final String KEY_STORE_ID = "idStore";
    public static final String KEY_STORE_NAME = "name";
    public static final String KEY_STORE_PHONE = "phone";
    public static final String KEY_STORE_CITY = "idCity";
    public static final String KEY_STORE_THUMBNAIL = "thumbnail";
    public static final String KEY_STORE_LAT = "latitude";
    public static final String KEY_STORE_LNG = "longitude";
    private static DatabaseHandler databaseHandler;
    private static final String DATABASE_NAME = "MyProducts.db";
    private static final int DATABASE_VERSION = 2;

    // Columns Cities
    public static final String KEY_CITY_ID = "idCity";
    public static final String KEY_CITY_NAME = "name";

    // Columns Category
    public static final String KEY_CATEGORY_ID = "idCategory";
    public static final String KEY_CATEGORY_NAME = "name";

    // Columns Products
    public static final String KEY_PRODUCT_ID = "idProduct";
    public static final String KEY_PRODUCT_TITLE = "name";
    public static final String KEY_PRODUCT_IMAGE = "image";
    public static final String KEY_PRODUCT_CATEGORY = "idCategory";

    //SQL Statements to create new databases
    private static final String CREATE_CITY_TABLE = "CREATE TABLE " + TABLE_CITY + "("
            + KEY_CITY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CITY_NAME + " TEXT)";

    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
            + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_CATEGORY_NAME + " TEXT)";

    private static final String CREATE_STORE_TABLE = "CREATE TABLE " + TABLE_STORE + "("
            + KEY_STORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_STORE_NAME + " TEXT,"
            + KEY_STORE_PHONE + " TEXT,"
            + KEY_STORE_CITY + " INTEGER,"
            + KEY_STORE_THUMBNAIL + " INTEGER,"
            + KEY_STORE_LAT + " DOUBLE,"
            + KEY_STORE_LNG + " DOUBLE)";

    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_PRODUCT + "("
            + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_PRODUCT_TITLE + " TEXT,"
            + KEY_PRODUCT_IMAGE + " INTEGER,"
            + KEY_PRODUCT_CATEGORY + " INTEGER)";


    private DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHandler getInstance(Context context){
        if(databaseHandler == null){
            databaseHandler = new DatabaseHandler(context);
        }
        return databaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CITY_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_STORE_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('TECHNOLOGY')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('HOME')");
        db.execSQL("INSERT INTO " + TABLE_CATEGORY + " (" + KEY_CATEGORY_NAME + ") VALUES ('ELECTRONICS')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (1, 'El Salto')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (2, 'Guadalajara')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (3, 'Ixtlahuacán de los Membrillos')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (4, 'Juanacatlán')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (5, 'San Pedro Tlaquepaque')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (6, 'Tlajomulco')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (7, 'Tonalá')");
        db.execSQL("INSERT INTO " + TABLE_CITY + " (" + KEY_CITY_ID + "," + KEY_CITY_NAME + ") VALUES (8, 'Zapopan')");
        db.execSQL("INSERT INTO " + TABLE_STORE
                + " (" + KEY_STORE_NAME + "," + KEY_STORE_PHONE + ","
                + KEY_STORE_CITY + "," + KEY_STORE_THUMBNAIL + ","
                + KEY_STORE_LAT + "," + KEY_STORE_LNG
                + ") VALUES ('BESTBUY', '01 800 237 8289', 2, 0, 20.6489713, -103.4207757)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//NOT SURE IF I HAVE TO ADD THIS
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

}
