package com.example.markusrttker.mr_dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Log.e("MainActivity", "Hello World");
    }

    public void buttonOnClick(View v){
        // ใทย
        Locale localthai = new Locale("th");
        NumberFormat thainumber = NumberFormat.getNumberInstance(localthai);
        int testint = 3;
        String teststring ;
        teststring = thainumber.format(testint);

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Date date2 = null;
        try {
            date2 = dateFormat.parse("28052021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d = new Date();
        long diff = date2.getTime() - d.getTime();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        Button button=(Button)v;
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView2.setTextSize(20);
        textView2.setText(days + " to go " + teststring);
        textView3.setTextSize(10);
        textView3.setText(DateFormat.format("dd.MM.yyyy HH:mm:ss", d.getTime()));
        if(button.getText()!= "คลิก"){
            ((Button) v).setText("คลิก");
        } else {
            button.setText("ใทย");
        }
    }

}
