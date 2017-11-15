package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//created by raghavender
public class AlertPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_page);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }
    public void contactsPage(View v){

        Intent contacts= new Intent(this,AppContacts.class);
        startActivity(contacts);

            }

    public void toFeedback1(View v){
        Intent emer1= new Intent(this,Feedback.class);
        startActivity(emer1);
    }
    public void toFeedback2(View v){
        Intent emer2= new Intent(this,Feedback.class);
        startActivity(emer2);
    }
    public void toFeedback3(View v){
        Intent emer3 = new Intent(this,Feedback.class);
        startActivity(emer3);
    }
//    public void toLogout(View v){
//        Toast.makeText(getApplicationContext(),"Logout Succesful",Toast.LENGTH_SHORT).show();
//        Intent logout = new Intent(this,Login.class);
//        startActivity(logout);
//    }
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
