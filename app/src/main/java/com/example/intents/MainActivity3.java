package com.example.intents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity3 extends AppCompatActivity {
    Button call;
    Button reach;
    Button visit;
    Button mail;
    Button button;
    ImageButton imageButton;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    RatingBar rate;
    CoordinatorLayout coordinatorLayout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item1:
                Intent j=new Intent(Intent.ACTION_SEND);
                j.setData(Uri.parse("email"));
                String[] s={"bikashgupta787@gmail.com"};
                j.putExtra(Intent.EXTRA_EMAIL,s);
                j.putExtra(Intent.EXTRA_SUBJECT,"Share App");
                j.putExtra(Intent.EXTRA_TEXT,"");
                j.setType("message/rfc822");
                Intent chooser = Intent.createChooser(j,"Mail Us Via:");
                startActivity(chooser);
//                Toast.makeText(this, "Item 1 is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
//                Toast.makeText(this, "Item 2 is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 is selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        button = (Button)findViewById(R.id.button);
        rate = (RatingBar)findViewById(R.id.ratingBar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:+919348462044"));
                startActivity(i);
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("geo:12.3656489.88.4569875"));
                Intent chooser= Intent.createChooser(a, "Reach us via: ");
                startActivity(chooser);
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(Intent.ACTION_SEND);
                j.setData(Uri.parse("email"));
                String[] s={"bikashgupta787@gmail.com"};
                j.putExtra(Intent.EXTRA_EMAIL,s);
                j.putExtra(Intent.EXTRA_SUBJECT,"Share App");
                j.putExtra(Intent.EXTRA_TEXT,"");
                j.setType("message/rfc822");
                Intent chooser = Intent.createChooser(j,"Mail Us Via:");
                startActivity(chooser);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.irctc.co.in/";
                Intent s=new Intent(Intent.ACTION_VIEW);
                s.setData(Uri.parse(url));
                startActivity(s);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totalStars = "Total Stars:: " + rate.getNumStars();
                String rating = "Your Rating :: " + rate.getRating();
//                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                Snackbar.make(view,  totalStars+" "+ rating, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }}




