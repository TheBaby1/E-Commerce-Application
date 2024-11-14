package com.example.listview_shopphile_ecommerceapp_ensomo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "shoppingdb";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "shoppingitems";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String PRICE_COL = "price";
    private static final String BRAND_COL = "brand";
    private static final String IMAGE_PATH_COL = "imagePath";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PRICE_COL + " TEXT,"
                + BRAND_COL + " TEXT,"
                + "imagePath TEXT)"; // Add imagePath column
        db.execSQL(query);
    }

    public void addNewItem(String itemName, String itemPrice, String itemBrand, String imagePath) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, itemName);
        values.put(PRICE_COL, itemPrice);
        values.put(BRAND_COL, itemBrand);
        values.put(IMAGE_PATH_COL, imagePath); // Use constant here
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<ItemModal> readItems() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorItems = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<ItemModal> itemModalArrayList = new ArrayList<>();
        if (cursorItems.moveToFirst()) {
            do {
                itemModalArrayList.add(new ItemModal(
                        cursorItems.getString(1),
                        cursorItems.getString(2),
                        cursorItems.getString(3),
                        cursorItems.getString(4)));
            } while (cursorItems.moveToNext());
        }
        cursorItems.close();
        return itemModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
