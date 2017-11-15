package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//Created by Sandeep Dara
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sign_out) {

            Intent ini = new Intent(this, Login.class);
            startActivity(ini);
            Toast.makeText(getApplicationContext(),"Logout successfull",Toast.LENGTH_SHORT).show();

        }


        return super.onOptionsItemSelected(item);


    }
}
