package com.example.anila.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATA_BASE_NAME="ContactsManager";
    public static final String TABLE_NAME="Contacts";
    public static final String KEY_ID="id";
    public static final String KEY_NAME="name";
    public static final String KEY_PHONE_NO="phone_number";



    public DataBaseHelper(Context context) {
        super(context,DATA_BASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE=" CREATE TABLE "+ TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+" TEXT,"+KEY_PHONE_NO+" TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addContact(Contacts contact)
    {
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,contact.getmName());
        contentValues.put(KEY_PHONE_NO,contact.getmPhoneNumber());
        dataBase.insert(TABLE_NAME,null,contentValues);
        dataBase.close();

    }
    public List<Contacts> getContacts()
    {
        List<Contacts> contactsList=new ArrayList<Contacts>();
        String selectQuery=" SELECT * FROM "+TABLE_NAME;

    SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery(selectQuery,null );
        if(cursor.moveToFirst()){
            do {
                Contacts c=new Contacts();
                c.setmId(Integer.parseInt(cursor.getString(0)));
                c.setmName(cursor.getString(1));
                c.setmPhoneNumber(cursor.getString(2));
                contactsList.add(c);
            }while (cursor.moveToNext());
        }
    return contactsList;
    }
    public int updateContact(Contacts contact){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,contact.getmName());
        contentValues.put(KEY_PHONE_NO,contact.getmPhoneNumber());
        return sqLiteDatabase.update(TABLE_NAME,contentValues,KEY_ID+" =?",new String[]{String.valueOf(contact.getmId())});
    }
    public void deleteContact(Contacts contacts){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID+" =?",new String[]{String.valueOf(contacts.getmId())});
        db.close();

    }

}
