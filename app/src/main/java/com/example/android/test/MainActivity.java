package com.example.android.test;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView)findViewById(R.id.vayamos);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Lobster_1.3.otf");
        txt.setTypeface(custom_font);
        setButtonListener();
    }

    public void setButtonListener(){
        final ImageButton b = (ImageButton) findViewById(R.id.coffeeButton);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                sendToHome(view);
            }


        });
    }

    public void sendToHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}

