package com.example.android.test;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView txt = (TextView)findViewById(R.id.vayamos_register);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Lobster_1.3.otf");
        txt.setTypeface(custom_font);
        setButtonListener();
    }

    private void setButtonListener(){
        final Button b = (Button) findViewById(R.id.registerButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister(view);
            }
        });
    }

    private void attemptRegister(View view){
        EditText emailTxt = (EditText) findViewById(R.id.enterEmail);
        EditText passwordTxt = (EditText) findViewById(R.id.enterPassword);
        EditText reenterPasswordTxt = (EditText) findViewById(R.id.reenterPassword);
        String email = emailTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        String reenterPassword = reenterPasswordTxt.getText().toString();

        if(!validEmail(email)){
            //Exit and return message
        }else{
            //Check password.
        }
    }
    
    //// TODO: 21/01/2016 Find a way to check for valid email.
    private boolean validEmail(String email){
        return true;
    }
}
