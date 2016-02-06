package com.example.android.test;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    public static final String PREFERENCES = "myPreferences";

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

        if(!validEmail(email)){                         //Email is not valid.
            //Exit and return message
        }else{
            if(!(password.equals(reenterPassword))){    //Passwords don't match.
                //LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.popup, null, false), 100, 100, true);
                //pw.showAtLocation(this.findViewById(R.id.registerMain), Gravity.CENTER, 0, 0);
            }else{
                if(!emailExists(email)) {
                    newRegister(email, password);
                }
            }
        }
    }
    
    //// TODO: 21/01/2016 Find a way to check for valid email.
    private boolean validEmail(String email){
        return true;
    }

    private boolean newRegister(String email, String pw){
        SharedPreferences prefs = getSharedPreferences(PREFERENCES, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(email, pw);
        editor.commit();
        return true;
    }

    private boolean emailExists(String email){
        SharedPreferences prefs = getSharedPreferences(PREFERENCES, 0);
        if(prefs.getString(email, "ERROR!").equals("ERROR!")){
            //POPUP: Email already exists
            return true;
        }
        return false;
    }
}

