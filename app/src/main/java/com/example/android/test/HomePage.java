package com.example.android.test;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView txt = (TextView)findViewById(R.id.vayamos_home);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Lobster_1.3.otf");
        txt.setTypeface(custom_font);
        setButtonListener();
    }

    private void setButtonListener(){
        final Button b = (Button) findViewById(R.id.register);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToRegister(view);
            }
        });
    }

    private void sendToRegister(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}
