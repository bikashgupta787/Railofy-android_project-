package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class tickets extends AppCompatActivity {
    TextView txtview1,txtview2, txtview3, txtview4, txtview5,txtview6;
    String val1,val2,val3,val4,val5,val6;
    Button btnnotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager  manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            val1 = bundle.getString("Name");
            val2 = bundle.getString("Age");
            val3 = bundle.getString("Number");
            val4 = bundle.getString("Source");
            val5 = bundle.getString("Destination");
//            val6 = bundle.getString("Gender");
            btnnotify = findViewById(R.id.notify);
            txtview1 = (TextView) findViewById(R.id.passname);
            txtview2 = (TextView) findViewById(R.id.passage);
            txtview3 = (TextView) findViewById(R.id.passnumber);
            txtview4 = (TextView) findViewById(R.id.src);
            txtview5 = (TextView) findViewById(R.id.dest);
//            txtview6 = (TextView) findViewById(R.id.passgender);
            txtview1.setText(val1);
            txtview2.setText(val2);
            txtview3.setText(val3);
            txtview4.setText(val4);
            txtview5.setText(val5);
//            txtview6.setText(val6);
        }
    }

    public void btnnotify(View view) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.itctc)).build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent i = new Intent(this,tickets.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(tickets.this,(int) Calendar.getInstance().getTimeInMillis(),i,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(tickets.this,"My Notification");
        builder.setSmallIcon(R.drawable.ic_save);
        builder.setContentTitle("Your ticket is downloaded");
        builder.setStyle(bigPictureStyle).addAction(R.drawable.ic_save,"Show ticket",pendingIntent);

        notificationManager.notify(0,builder.build());

    }
}