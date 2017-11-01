//created by Tilak Dhulipalla
package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void toRegister(View v){
        Intent intentregister =new Intent(this, Register.class);
        startActivity(intentregister);
    }
    public void toForgot(View v){
        Intent intentforgot = new Intent(this, ForgotPassword.class);
        startActivity(intentforgot);
    }
    public void toAlert(View v){



            EditText email = (EditText) findViewById(R.id.email);
            EditText password = (EditText) findViewById(R.id.password);

            if (email.getText().toString().length() > 0 && !email.getText().toString().matches("\\s+") ){

                if(password.getText().length()>0 && !password.getText().toString().matches("\\s+")) {

                    if (email.getText().toString().equals("mike@gmail.com") && password.getText().toString().equals("mike")) {
                        Intent intentalert = new Intent(this,AlertPage.class);
                        startActivity(intentalert);

                    }
                    else
                    {
                        Toast.makeText(Login.this,
                                "Please enter valid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    password.setError("Please enter password");
                    //Toast.makeText(LoginActivity.this,
                    // "Please enter password", Toast.LENGTH_SHORT).show();
                }

            }
            else
            {
                email.setError("Please enter email address");
                // Toast.makeText(LoginActivity.this,
                // "Please enter email address", Toast.LENGTH_SHORT).show();
            }
        }


    }


