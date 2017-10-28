package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AppContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_contacts);
    }

public void Implicit(View v)
{
                Intent intent= new Intent(this,Contacts.class);
              startActivity(intent);
}

    public void groupManger(View v)
    {
        Intent intent= new Intent(this, Contacts.class);

        startActivity(intent);
    }
    public void toLogout(View v){
        Toast.makeText(getApplicationContext(),"Logout Succesful",Toast.LENGTH_SHORT).show();
        Intent logout = new Intent(this,Login.class);
        startActivity(logout);
    }
    public void toFeedback3(View v){
        Intent emer3 = new Intent(this,Feedback.class);
        startActivity(emer3);
    }
}
