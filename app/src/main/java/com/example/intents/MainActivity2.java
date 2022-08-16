package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button button2;
    TextView textView4;
    String valFromAct1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button2=(Button)findViewById(R.id.button2);
        textView4=(TextView)findViewById(R.id.textView4);
        valFromAct1= getIntent().getExtras().getString("Value");
        textView4.setText(valFromAct1);
    }

    public void btnClickAct2(View view) {
        Intent i=new Intent(this,MainActivity3.class);
        startActivity(i);
//        finish();
    }

    public void btnClickAct3(View view) {
        Intent l = new Intent(this, booktickets.class);
        startActivity(l);
//        finish();
    }

    public void btnClickAct4(View view) {
        Intent f = new Intent(this, webview.class);
        startActivity(f);
//        finish();
    }

    public void btnClickAct5(View view) {
        Intent a = new Intent(this, listview.class);
        startActivity(a);
    }
}