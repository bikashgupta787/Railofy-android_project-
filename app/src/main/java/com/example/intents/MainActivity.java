package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText, editText2;
    String editTextVal;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent i = new Intent(getBaseContext(), MainActivity2.class);
                    editTextVal = editText.getText().toString();
                    i.putExtra("Value", editTextVal);
                    startActivity(i);
                    finish();

                }


            }
        });
    }


        private boolean CheckAllFields () {
            if (editText.length() == 0){
                Toast t = Toast.makeText(this, "Enter UserId", Toast.LENGTH_SHORT);
                t.show();
//                editText.setError("This Field is required");
                return false;

            }
            if (editText2.length() == 0) {
                Toast t = Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT);
                t.show();
//                editText2.setError("This Field is required");
                return false;
            }
            return true;
        }
        }



