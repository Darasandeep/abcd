 
package com.example.s528737.emeralertsys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void toRegister(View v){
        Intent intentregister =new Intent(Login.this, Register.class);
        startActivity(intentregister);
    }
 
 
 
 
    public void toAlert(View v){


        final EditText email = (EditText) findViewById(R.id.email);
        final String emailID = email.getText().toString();
        final EditText password = (EditText) findViewById(R.id.password);
        final String passcode = password.getText().toString();




            if (email.getText().toString().length() > 0  ){

                if(password.getText().length()>0 ) {

                    IDataStore<RegisterInfo> userStorage = Backendless.Data.of(RegisterInfo.class);
                    DataQueryBuilder query = DataQueryBuilder.create();
                    String value="Email='"+emailID+"'";
                    query.setWhereClause(value);
                    Log.d("where condition",""+value);
                    userStorage.find(query, new AsyncCallback<List<RegisterInfo>>() {

                        @Override
                        public void handleResponse(List<RegisterInfo> response) {
//                            Log.d("Printing : ", "user Details: " + response);

                            String test = response.toString();
                            Log.d("Printing : ", "user test: " + test);
                            if ((test.contains(emailID) && test.contains(passcode))) {
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);


                            }
                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(getApplicationContext(), "please enter valid credentials", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
    }
}









