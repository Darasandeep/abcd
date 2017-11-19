package com.example.s528737.emeralertsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
    }
    //    public void toAlertPage(View v){
//        Intent iniregister = new Intent(this,AlertPage.class);
//        startActivity(iniregister);
//    }
    public void register(View v) {
        EditText firstName = (EditText) findViewById(R.id.editText4);
        EditText lastName = (EditText) findViewById(R.id.editText3);

        EditText passwd =(EditText) findViewById(R.id.editText);
        EditText phNum = (EditText) findViewById(R.id.editText5);
        EditText email = (EditText) findViewById(R.id.editText7);

//        radioGroup = (RadioGroup) findViewById(R.id.empwork);
//        RadioButton radioButton = (RadioButton) findViewById(R.id.radioEmployr);
//        radioGroup2 = (RadioGroup) findViewById(R.id.gender);
//        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioFemale);




        if (firstName.getText().toString().trim().equals("")) {
            firstName.setError("First name is required!");
        }
        if (lastName.getText().toString().trim().equals("")) {
            lastName.setError("Last name is required!");
        }
        if(passwd.getText().toString().trim().equals("")){
            passwd.setError("Password is required!");
        }


        if (phNum.getText().toString().trim().equals("")) {
            phNum.setError("Phone number is required!");
        }
        if (email.getText().toString().trim().equals("")) {
            email.setError("Email is required!");
        }




        else {

            RegisterInfo registerUser = new RegisterInfo();
            registerUser.F_Name=firstName.getText().toString();
            registerUser.L_Name=lastName.getText().toString();
            registerUser.Email=email.getText().toString();
            registerUser.Password=passwd.getText().toString();
            registerUser.MobileNumber=phNum.getText().toString();
            Log.d("key", String.valueOf(registerUser));
            Backendless.Data.of( RegisterInfo.class ).save(registerUser, new AsyncCallback<RegisterInfo>() {


                @Override
                public void handleResponse(RegisterInfo response) {
                    Log.d("DB","Inserted values into table"+response);
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Log.e( "MYAPP", "Server reported an error " + fault.getMessage() );
                }
            });
            Toast.makeText(getApplicationContext(),
                    "Please login", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }

    }}
//}
