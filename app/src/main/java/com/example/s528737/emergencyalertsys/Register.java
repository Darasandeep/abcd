//created by Tilak Dhulipalla
package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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


//        if (radioGroup.getCheckedRadioButtonId() <= 0) {
//
//            radioButton.setError("Select Item");
//
//        }
//        if (radioGroup2.getCheckedRadioButtonId() <= 0) {
//
//            radioButton1.setError("Select Item");
//
//        }

        else {
            Toast.makeText(getApplicationContext(),
                    "Please login", Toast.LENGTH_SHORT).show();
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        }

    }
}
