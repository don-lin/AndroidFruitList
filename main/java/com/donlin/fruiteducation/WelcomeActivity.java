package com.donlin.fruiteducation;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class WelcomeActivity extends AppCompatActivity {

    //set the language
    private void setLocale(String language){

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    //initialize the view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button startEnglish=(Button)findViewById(R.id.start_english);

        //set english language to the application
        startEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
                Intent intent = new Intent(WelcomeActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        //set chinese language to the application
        Button startChinese=(Button)findViewById(R.id.start_chinese);
        startChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("zh");
                Intent intent = new Intent(WelcomeActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
