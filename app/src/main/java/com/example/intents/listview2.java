package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview2 extends AppCompatActivity {

    ListView l;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);
        l = findViewById(R.id.listview1);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tutorials);
        l.setAdapter(arr);
    }
}