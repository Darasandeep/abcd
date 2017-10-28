package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }
    public void toLogout(View v){
        Toast.makeText(getApplicationContext(),"Logout Succesful",Toast.LENGTH_SHORT).show();
        Intent logout = new Intent(this,Login.class);
        startActivity(logout);
    }
}
