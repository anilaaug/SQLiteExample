package com.example.anila.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
        Log.d("Insert", "Inserting: ");
        dataBaseHelper.addContact(new Contacts("Ravi","1001000011"));
        dataBaseHelper.addContact(new Contacts("Anju","1212121200"));
        Log.d("Reading", "onCreate: ");
        List<Contacts>myList=dataBaseHelper.getContacts();
        for(Contacts c:myList){
            String log="Id"+c.getmId()+"Name"+c.getmName()+"Phone"+c.getmPhoneNumber();
            Log.d("Name",  log);

        }


    }
}
