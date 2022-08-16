package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends AppCompatActivity {
    ListView l;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, tutorials);
        l = (ListView) findViewById(R.id.list);
        l.setAdapter(adapter);
    }
}