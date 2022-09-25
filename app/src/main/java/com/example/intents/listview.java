package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class listview extends AppCompatActivity {
    ListView l;
//    String tutorials[]
//            = { "Algorithms", "Data Structures",
//            "Languages", "Interview Corner",
//            "GATE", "ISRO CS",
//            "UGC NET CS", "CS Subjects",
//            "Web Technologies" };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_three,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.sort:
                Intent i=new Intent(this,listview2.class);
                startActivity(i);
            case R.id.cal:
//                Toast.makeText(this,"Calender", Toast.LENGTH_SHORT).show();
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                    }


                }, year, month, day);
                datePickerDialog.show();
                return true;
            case R.id.filter:
                Toast.makeText(this, "Filtered", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        l = (ListView) findViewById(R.id.listview);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Shatabdi Express");
        arrayList.add("Ispat Express");
        arrayList.add("Duronto Express");
        arrayList.add("Bokaro Express");
        arrayList.add("South Bihar Express");
        arrayList.add("Danapur Express");
        arrayList.add("YPR Express");
        arrayList.add("Janshatabdi Express");
        arrayList.add("GaribRath Express");
        arrayList.add("Agnipath Express");
        arrayList.add("Festival Express");
        arrayList.add("Goa Express");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        l.setAdapter(arrayAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listview.this,""+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}