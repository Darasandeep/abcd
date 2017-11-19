package com.example.s528737.emeralertsys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ThirdActivity extends Activity {
    String MySms = null;
    private EditText edittext1, edittext2,textSMS;
    private TextView t,t1,t2;
    Button button;
    Button btnupdate;
    Button btndisplay;
    String log;
    int count=0;
    Button buttonSend;
     
    private LocationManager locationMangaer=null;
    private LocationListener locationListener=null;

    private Button btnGetLocation = null;
    private EditText editLocation = null;

     

    private static final String TAG = "Debug";
    private Boolean flag = false;

     

     

    String name, phone, name1,phone1;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_third);
        t=new TextView(this);
         
         

         
         


         
         

        textSMS = (EditText) findViewById(R.id.editTextSMS);
        textSMS.setKeyListener(null);
         
        t=(TextView)findViewById(R.id.textView1);
        t.setTextColor(Color.parseColor("#ffffff"));


         
        setRequestedOrientation(ActivityInfo
                .SCREEN_ORIENTATION_PORTRAIT);

        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

        flag = displayGpsStatus();
        if (flag)
        {

            Log.v(TAG, "onClick");

            textSMS.setText("Please help me I am at 800 1115 N college drive, maryville");

             
            locationListener = new MyLocationListener();

            locationMangaer.requestLocationUpdates(LocationManager
                    .GPS_PROVIDER, 5000, 10,locationListener);

        } else {
            alertbox("Gps Status!!", "Your GPS is: OFF");
        }



        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber()+"Count: "+count;
            String ll = ""+count;
            Log.d("Name: ", log);
             
            count++;
        }


        addListenerOnButton();
    }

    public void addListenerOnButton() {



        btnGetLocation = (Button) findViewById(R.id.button2);

        btnGetLocation.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(),
                        "SMS sent!",
                        Toast.LENGTH_LONG).show();
                flag = displayGpsStatus();
                if (flag)
                {

                    Log.v(TAG, "onClick");

                    textSMS.setText("Please help me I am at 800 1115 N college drive, maryville");

                     
                    locationListener = new MyLocationListener();

                    locationMangaer.requestLocationUpdates(LocationManager
                            .GPS_PROVIDER, 5000, 10,locationListener);

                } else {
                    alertbox("Gps Status!!", "Your GPS is: OFF");
                }

            }
        });

    }



    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {
            Toast.makeText(getApplicationContext(),
                    "SMS sent",
                    Toast.LENGTH_LONG).show();
            String ad1 = null, ad2 = null;
            String s=null;
            textSMS.setText("");
             
             
            String longitude = "Longitude: " +loc.getLongitude();
            Log.v(TAG, longitude);
            String latitude = "Latitude: " +loc.getLatitude();
            Log.v(TAG, latitude);

			  
            String cityName=null;
            Geocoder gcd = new Geocoder(getBaseContext(),Locale.getDefault());
            List<Address>  addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (addresses.size() > 0)
                     
                    cityName=addresses.get(0).getLocality();
                 
                ad1=addresses.get(0).getCountryName();
                ad2=addresses.get(0).getAddressLine(0);

                 
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(ad1 == null)
                s = "Help me.. I am here";
            else
                s = "Help me.. I am here: "+ad2+" "+cityName+" "+ad1;
            textSMS.setText(s);
            MySms = s+"";
            System.out.println(s);

            try {
                Log.d("Sending: ", "Sending message..");
                List<Contact> contacts = db.getAllContacts();
                for (Contact cn : contacts) {
                    System.out.println("PhNo: "+cn.getPhoneNumber()+" "+"Message: "+MySms);
                    t.setText("Message send");

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(cn.getPhoneNumber(), null, MySms, null, null);

                    Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();

                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "SMS faild, please try again later!",
                        Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }

        @Override
        public void onProviderDisabled(String provider) {
             
        }

        @Override
        public void onProviderEnabled(String provider) {
             
        }

        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
             
        }
    }

      
    protected void alertbox(String title, String mymessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is Disable")
                .setCancelable(false)
                .setTitle("** Gps Status **")
                .setPositiveButton("Gps On",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                 
                                 
                                Intent myIntent = new Intent(
                                        Settings.ACTION_SECURITY_SETTINGS);
                                startActivity(myIntent);
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                 
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }



      
    private Boolean displayGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        boolean gpsStatus = Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.GPS_PROVIDER);
        if (gpsStatus) {
            return true;

        } else {
            return false;
        }
    }


}


