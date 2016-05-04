package com.yiptv.sam.flightinfoapp.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yiptv.sam.flightinfoapp.Model.AirlineInfo;

import java.util.List;

/**
 * Created by Sam on 5/3/16.
 */
public class DBTools extends SQLiteOpenHelper {


    final String FAVORITES_TABLE = "favorites";

    public DBTools(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // onCreate is called the first time the database is created
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + FAVORITES_TABLE + " (" +
                "code TEXT PRIMARY KEY," +
                "defaultName TEXT," +
                "logoURL TEXT," +
                "name TEXT," +
                "phone TEXT," +
                "site TEXT," +
                "usName TEXT," +
                "isFavorite )";

        // Executes the query provided as long as the query isn't a SELECT
        // or if the query doesn't return any data
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS" + FAVORITES_TABLE;
        db.execSQL(query);
        onCreate(db);
    }

    public void insertIntoFavorites(AirlineInfo airlineInfo){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("__clazz", airlineInfo.get__clazz());
        values.put("code", airlineInfo.getCode());
        values.put("defaultName", airlineInfo.getDefaultName());
        values.put("logoURL", airlineInfo.getLogoURL());
        values.put("name", airlineInfo.getName());
        values.put("phone", airlineInfo.getPhone());
        values.put("site", airlineInfo.getSite());
        values.put("usName", airlineInfo.getUsName());
        values.put("isFavorite", 1);

        database.insert( FAVORITES_TABLE ,null,values);
    }

    public void updateFavoritesItem(AirlineInfo airlineInfo, int isFavorite){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("isFavorite", isFavorite);
        database.update(
                FAVORITES_TABLE,
                values,
                "code='" + airlineInfo.getCode() + "'",
                null );
    }

    public void deleteFavoritesItem(AirlineInfo airlineInfo){

    }

    public void isFavorite(AirlineInfo airlineInfo){

        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT isFavorite FROM "+
                FAVORITES_TABLE +
                "WHERE code=" +
                airlineInfo.getCode() + "'";
        Cursor cursor = database.rawQuery(query,null);

    }

    public List<AirlineInfo> getFavorites(){

        List<AirlineInfo> airlineInfoList = null;

        String selectQuery = "";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){

            do {
                AirlineInfo airlineInfo = new AirlineInfo(
                        cursor.getString(cursor.getColumnIndex("__clazz")),
                        cursor.getString(cursor.getColumnIndex("code")),
                        cursor.getString(cursor.getColumnIndex("defaultName")),
                        cursor.getString(cursor.getColumnIndex("logoURL")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("phone")),
                        cursor.getString(cursor.getColumnIndex("site")),
                        cursor.getString(cursor.getColumnIndex("usName")) );

                airlineInfoList.add(airlineInfo);

            } while(cursor.moveToNext()); // Move Cursor to the next row

            return airlineInfoList;

        }

        return null;
    }
}
