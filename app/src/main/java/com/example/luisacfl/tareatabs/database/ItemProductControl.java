package com.example.luisacfl.tareatabs.database;

/**
 * Created by luisacfl on 16/10/17.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.luisacfl.tareatabs.beans.ItemProduct;
import com.example.luisacfl.tareatabs.beans.Category;

import java.util.ArrayList;


public class ItemProductControl {

    public ItemProductControl() {
    }

    public long addItemProduct(ItemProduct product, DatabaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHandler.KEY_PRODUCT_TITLE, product.getTitle());
        values.put(DatabaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DatabaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getIdCategory());
        // Inserting Row
        inserted = db.insert(DatabaseHandler.TABLE_PRODUCT, null, values);
        // Closing database connection
        try {db.close();} catch (Exception e) {}
        db = null; values = null;
        return inserted;
    }
    public int updateProduct(ItemProduct product, DatabaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseHandler.KEY_PRODUCT_TITLE, product.getTitle());
        values.put(DatabaseHandler.KEY_PRODUCT_IMAGE, product.getImage());
        values.put(DatabaseHandler.KEY_PRODUCT_CATEGORY, product.getCategory().getIdCategory());
        int count = db.update(DatabaseHandler.TABLE_PRODUCT, values,
                DatabaseHandler.KEY_PRODUCT_ID + " = ?",
                new String[] { String.valueOf(product.getCode()) });
        try { db.close();} catch (Exception e) {}
        db = null;
        return count;
    }
    public void deleteProduct(int idProduct, DatabaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DatabaseHandler.TABLE_STORE, DatabaseHandler.KEY_PRODUCT_ID
                + " = ?", new String[] { String.valueOf(idProduct) });
        try {
            db.close();
        } catch (Exception e) {
        }
        db = null;
    }
    public ItemProduct getProductById(int idProduct, DatabaseHandler dh){
        ItemProduct product = new ItemProduct();
        String selectQuery = "SELECT P." + DatabaseHandler.KEY_PRODUCT_ID + ","
                + "P." + DatabaseHandler.KEY_PRODUCT_TITLE + ","
                + "P." + DatabaseHandler.KEY_PRODUCT_IMAGE + ","
                + "C." + DatabaseHandler.KEY_CATEGORY_ID + ","
                + "C." + DatabaseHandler.KEY_CATEGORY_NAME + " FROM "
                + DatabaseHandler.TABLE_PRODUCT + " P,"
                + DatabaseHandler.TABLE_CATEGORY + " C WHERE P."
                + DatabaseHandler.KEY_PRODUCT_ID + "= " + idProduct
                + " AND P." + DatabaseHandler.KEY_PRODUCT_CATEGORY
                + " = C." + DatabaseHandler.KEY_CATEGORY_ID;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            product.setCode(cursor.getInt(0));
            product.setTitle(cursor.getString(1));
            product.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setIdCategory(cursor.getInt(3));
            category.setName(cursor.getString(4));
            product.setCategory(category);
        }
        try {cursor.close();db.close();
        } catch (Exception e) {}
        db = null;
        cursor = null;
        return product;
    }
    public ArrayList<ItemProduct> getProductsWhere(String strWhere, String strOrderBy, DatabaseHandler dh){
        ArrayList<ItemProduct> products = new ArrayList<ItemProduct>();
        String query;
        if(strWhere != null){
            query = "SELECT P." + DatabaseHandler.KEY_PRODUCT_ID + ","
                    + "P." + DatabaseHandler.KEY_PRODUCT_TITLE + ","
                    + "P." + DatabaseHandler.KEY_PRODUCT_IMAGE + ","
                    + "C." + DatabaseHandler.KEY_CATEGORY_ID + ","
                    + "C." + DatabaseHandler.KEY_CATEGORY_NAME + " FROM "
                    + DatabaseHandler.TABLE_PRODUCT + " P,"
                    + DatabaseHandler.TABLE_CATEGORY + " C WHERE "
                    + " P." + DatabaseHandler.KEY_PRODUCT_CATEGORY
                    + " = C." + DatabaseHandler.KEY_CATEGORY_ID + " "
                    + strWhere + " ORDER BY " + strOrderBy;
        }else{
            query = "SELECT P." + DatabaseHandler.KEY_PRODUCT_ID + ","
                    + "P." + DatabaseHandler.KEY_PRODUCT_TITLE + ","
                    + "P." + DatabaseHandler.KEY_PRODUCT_IMAGE + ","
                    + "C." + DatabaseHandler.KEY_CATEGORY_ID + ","
                    + "C." + DatabaseHandler.KEY_CATEGORY_NAME + " FROM "
                    + DatabaseHandler.TABLE_PRODUCT + " P,"
                    + DatabaseHandler.TABLE_CATEGORY + " C WHERE "
                    + " P." + DatabaseHandler.KEY_PRODUCT_CATEGORY
                    + " = C." + DatabaseHandler.KEY_CATEGORY_ID
                    + " ORDER BY " + strOrderBy;
        }
        SQLiteDatabase db = dh.getReadableDatabase();

        // El null funcion como en el where del delete, ahi iria el arreglo
        Cursor cursor = db.rawQuery(query,null);

        while (cursor.moveToNext()) {
            ItemProduct product = new ItemProduct();
            product.setCode(cursor.getInt(0));
            product.setTitle(cursor.getString(1));
            product.setImage(cursor.getInt(2));
            Category category = new Category();
            category.setIdCategory(cursor.getInt(3));
            category.setName(cursor.getString(4));
            product.setCategory(category);
            products.add(product);
        }

        try {
            db.close();
        } catch (Exception e) {

        }
        db = null;
        cursor = null;

        return products;
    }
}