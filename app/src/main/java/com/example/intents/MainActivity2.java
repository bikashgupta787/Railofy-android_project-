package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

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
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemReselectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Fragment()).commit();

        valFromAct1= getIntent().getExtras().getString("Value");
        textView4.setText(valFromAct1);
    }

    private NavigationBarView.OnItemReselectedListener navListener = new NavigationBarView.OnItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;

                case R.id.settings:
                    selectedFragment = new SettingsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();


        }
    };

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