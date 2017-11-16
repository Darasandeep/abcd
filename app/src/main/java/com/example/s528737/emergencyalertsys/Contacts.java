package com.example.s528737.emergencyalertsys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
//created by anil akula

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.contacts);

        String[] contact = {"Sandeep                 select \n(122)-253-6655","Tilak                           select \n (254) 435-6546","Anil                          select \n (254) 643-6546","Raghu                       select\n (837) 924-6546"};
//        String[] select = {"select\n","select\n","select\n","select\n"};
        ListAdapter contAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contact);
        ListView lstContacts = (ListView) findViewById(R.id.lst_contacts);


        // Setting the adapter to listview
             lstContacts.setAdapter(contAdapter);
//        lstContacts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lstContacts.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i==0|i==1){

                }



            }
        });
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
