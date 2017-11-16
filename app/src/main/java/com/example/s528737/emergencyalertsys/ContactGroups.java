package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ContactGroups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_groups);
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
