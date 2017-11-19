package com.example.s528737.emeralertsys;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends Activity {
    String MySms = null;
    private EditText edittext1, edittext2;
    private TextView t, t1, t2, t3, t4;
    Button button;
    Button btnupdate;
    Button btndisplay;
    String log;
    int count = 0;
    Button buttonSend;
    Button btndelete;

      
    private LocationManager locationMangaer = null;
    private LocationListener locationListener = null;

    private Button btnGetLocation = null;
    private EditText editLocation = null;

      

    private static final String TAG = "Debug";
    private Boolean flag = false;

      

      

    String name, phone, name1, phone1;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_second);
        t = new TextView(this);
        t1 = new TextView(this);
        t2 = new TextView(this);

        edittext1 = new EditText(this);
        edittext1 = (EditText) findViewById(R.id.editText1);

        edittext2 = new EditText(this);
        edittext2 = (EditText) findViewById(R.id.editText2);

          
          
        t = (TextView) findViewById(R.id.textView1);
        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView3);
        t3 = (TextView) findViewById(R.id.textView4);
        t4 = (TextView) findViewById(R.id.textView5);


        t.setTextColor(Color.parseColor("#000000"));
        t1.setTextColor(Color.parseColor("#000000"));
        t2.setTextColor(Color.parseColor("#000000"));
        t3.setTextColor(Color.parseColor("#000000"));
        t4.setTextColor(Color.parseColor("#000000"));


          
        setRequestedOrientation(ActivityInfo
                .SCREEN_ORIENTATION_PORTRAIT);


        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);


        List<Contact> contacts = db.getAllContacts();
        count = 0;
        for (Contact cn : contacts) {
            log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + "Count: " + count;
            String NameNumber = null;
            NameNumber = cn.getName() + " : " + cn.getPhoneNumber();
            String ll = "" + count;
            Log.d("Name: ", log);
              
            if (count == 0)
                t.setText(NameNumber);
            else if (count == 1)
                t1.setText(NameNumber);
            else if (count == 2)
                t2.setText(NameNumber);
            else if (count == 3)
                t3.setText(NameNumber);


            count++;

        }


        System.out.println("count = " + count);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

          
        button = (Button) findViewById(R.id.button1);
          
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                if (edittext2.length() < 10) {
                    Toast.makeText(getApplicationContext(), "Phone number should be 10 digits", Toast.LENGTH_LONG).show();
                } else {

                      
                    System.out.println(count);
                    if (count < 4) {
                          
                        name = edittext1.getText().toString();
                        phone = edittext2.getText().toString();
                        if (name.length() > 0 && (phone.length() == 10 || phone.length() == 11)) {

                            Log.d("Insert: ", "Inserting ..");
                            db.addContact(new Contact(name, phone));
                            count++;

                        }

                    }

                    Log.d("Dislaying: ", "Displaying all contacts..");
                    List<Contact> contactsd = db.getAllContacts();
                    count = 0;
                    for (Contact cn : contactsd) {
                        log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + "Count: " + count;
                        String NameNumber = null;
                        NameNumber = cn.getName() + " : " + cn.getPhoneNumber();
                        String ll = "" + count;
                        Log.d("Name: ", log);

                        if (count == 0)
                            t.setText(NameNumber);
                        else if (count == 1)
                            t1.setText(NameNumber);
                        else if (count == 2)
                            t2.setText(NameNumber);
                        else if (count == 3)
                            t3.setText(NameNumber);

                        count++;

                    }
                }
            }

        });


        btnupdate = (Button) findViewById(R.id.button2);

        btnupdate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                if (edittext2.length() < 10) {
                    Toast.makeText(getApplicationContext(), "Phone number should be 10 digits", Toast.LENGTH_LONG).show();
                }else{
                  
                int idd;
                name = edittext1.getText().toString();
                phone = edittext2.getText().toString();
                Log.d("Update: ", "Updating ..");
                  
                  
                List<Contact> contacts2 = db.getAllContacts();
                for (Contact cn : contacts2) {
                    if (cn.getName().equals(name)) {
                        idd = cn.getID();
                        db.updateContact2(idd, name, phone);
                        break;
                    }

                }
                Log.d("Dislaying: ", "Displaying all contacts..");
                List<Contact> contactsd = db.getAllContacts();
                count = 0;
                for (Contact cn : contactsd) {
                    log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + "Count: " + count;
                    String NameNumber = null;
                    NameNumber = cn.getName() + " : " + cn.getPhoneNumber();
                    String ll = "" + count;
                    Log.d("Name: ", log);
                      
                    if (count == 0)
                        t.setText(NameNumber);
                    else if (count == 1)
                        t1.setText(NameNumber);
                    else if (count == 2)
                        t2.setText(NameNumber);
                    else if (count == 3)
                        t3.setText(NameNumber);

                    count++;
                      
                }
            }}

        });

        btndisplay = (Button) findViewById(R.id.button3);

        btndisplay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                  
                Log.d("Dislaying: ", "Displaying all contacts..");
                List<Contact> contactsd = db.getAllContacts();
                count = 0;
                for (Contact cn : contactsd) {
                    log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + "Count: " + count;
                    String NameNumber = null;
                    NameNumber = cn.getName() + " : " + cn.getPhoneNumber();
                    String ll = "" + count;
                    Log.d("Name: ", log);
                      
                    if (count == 0)
                        t.setText(NameNumber);
                    else if (count == 1)
                        t1.setText(NameNumber);
                    else if (count == 2)
                        t2.setText(NameNumber);
                    else if (count == 3)
                        t3.setText(NameNumber);

                    count++;
                      
                }

            }

        });


        btndelete = (Button) findViewById(R.id.button4);

        btndelete.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                  
                int idd;
                name = edittext1.getText().toString();
                phone = edittext2.getText().toString();
                Log.d("Delete: ", "Deleting ..");
                List<Contact> contacts2 = db.getAllContacts();
                for (Contact cn : contacts2) {
                    if (cn.getName().equals(name)) {
                        idd = cn.getID();
                        db.deleteContact2(idd);
                        break;
                    }

                }

            }

        });


    }


}