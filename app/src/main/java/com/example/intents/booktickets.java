package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class booktickets extends AppCompatActivity {
    TextView dateView,timeView, alarm, person;
    EditText source,destination;
    Button dateButton,timeButton,bookTicket;
    ToggleButton acToggle;
    SwitchCompat type;
    int year,month,day,hour,minute;
    FloatingActionButton fabbtn, alarmfab, personfab;
    Boolean isAllFabVisible;
    String src,destn,switchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktickets);
        dateView = (TextView)findViewById(R.id.date_text);
        timeView = (TextView)findViewById(R.id.time_text);
        source = (EditText)findViewById(R.id.source_text);
        destination = (EditText)findViewById(R.id.destination_text);
        dateButton = (Button)findViewById(R.id.date_button);
        timeButton = (Button)findViewById(R.id.time_button);
        bookTicket = (Button)findViewById(R.id.bookTicket_button);
//        acToggle = (ToggleButton)findViewById(R.id.nonactoggle);
        type = (SwitchCompat)findViewById(R.id.actoggle);
        fabbtn = (FloatingActionButton)findViewById(R.id.fabbtn);
        alarmfab = (FloatingActionButton)findViewById(R.id.add_alarm_fab);
        personfab = (FloatingActionButton)findViewById(R.id.add_person_fab);
        alarm = (TextView)findViewById(R.id.add_alarm_action_text);
        person = (TextView)findViewById(R.id.add_person_action_text);

        alarmfab.setVisibility(View.GONE);
        personfab.setVisibility(View.GONE);
        alarm.setVisibility(View.GONE);
        isAllFabVisible = false;
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(booktickets.this, new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int

                                    dayOfMonth) {

                                dateView.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                            }
                        },year,month,day);
                dpd.show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR);
                minute = c.get(Calendar.MINUTE);
                TimePickerDialog.OnTimeSetListener mTimeSetListener = new

                        TimePickerDialog.OnTimeSetListener() {

                            public void onTimeSet(TimePicker view, int hourOfDay, int

                                    minute) {

                                timeView.setText(hourOfDay+":"+minute);
                            }
                        };
                TimePickerDialog tpd = new TimePickerDialog(booktickets.this,
                        mTimeSetListener, hour, minute, false);
                tpd.show();
            }
        });
        bookTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                src = source.getText().toString();
                destn = destination.getText().toString();
                if(type.isChecked()){
                    switchText = "Non AC";
                }
                else
                    switchText = "AC";
                AlertDialog.Builder alertDialogBuilder = new

                        AlertDialog.Builder(booktickets.this);

                alertDialogBuilder.setMessage("Confirm ticket?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1)

                            {

                                Toast.makeText(booktickets.this,"Ticket Booked\n"+"From: "+src+"\nTo: "+destn+"\n"+switchText+" Coach",Toast.LENGTH_LONG).show();
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new

                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        fabbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                if(!isAllFabVisible){
                    alarmfab.show();
                    personfab.show();
                    alarm.setVisibility(View.VISIBLE);
                    person.setVisibility(View.VISIBLE);
                    isAllFabVisible = true;

                } else {
                    alarmfab.hide();
                    personfab.hide();
                    alarm.setVisibility(View.GONE);
                    person.setVisibility(View.GONE);
                    isAllFabVisible = false;
                }
            }

        });

        personfab.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(booktickets.this,"Person Added",Toast.LENGTH_SHORT).show();
                    }
                });
        alarmfab.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(booktickets.this,"Alarm Added",Toast.LENGTH_SHORT).show();
                    }
                });
//    spin.setOnItemSelectedListener(this);
//        List<String> categories = new ArrayList<String>();
//        categories.add("Automobile");
//        categories.add("Business Services");
//        categories.add("Computers");
//        categories.add("Education");
//        categories.add("Personal");
//        categories.add("Travel");
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spin.setAdapter(dataAdapter);
    }
//    @Override
//    public void onItemSelected(AdapterView<?> parent,View view,int position, long id) {
//        String item = parent.getItemAtPosition(position).toString();
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//        public void onNothingSelected(AdapterView<?> arg0)
//    }
//    }



}