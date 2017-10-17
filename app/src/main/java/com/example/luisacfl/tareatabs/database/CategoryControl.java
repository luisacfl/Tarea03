package com.example.luisacfl.tareatabs.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.luisacfl.tareatabs.beans.Category;

import java.util.ArrayList;

/**
 * Created by luisacfl on 16/10/17.
 */

public class CategoryControl {
    public ArrayList<Category> getAllCategories(DatabaseHandler dh) {

        ArrayList<Category> categories = new ArrayList<Category>();
        String query = "SELECT C." + DatabaseHandler.KEY_CATEGORY_ID + ","
                + "C." + DatabaseHandler.KEY_CATEGORY_NAME + " FROM "
                + DatabaseHandler.TABLE_CATEGORY + " C";

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()) {
            Category category = new Category();
            category.setIdCategory(cursor.getInt(0));
            category.setName(cursor.getString(1));
            categories.add(category);
        }

        try {
            db.close();
        } catch (Exception e) {

        }
        db = null;
        cursor = null;

        return categories;
    }
}
