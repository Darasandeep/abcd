package com.example.s528737.emeralertsys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

 
public class MainActivity extends Activity
        implements OnClickListener {
      
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
 
 
 

        View btnClick = findViewById(R.id.buttonClick);
         
        btnClick.setOnClickListener(this);
        View btnClick2 = findViewById(R.id.buttonClick2);
         
        btnClick2.setOnClickListener(this);

    }

     
    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.buttonClick){
             
            Intent intent = new Intent(this,SecondActivity.class);
             
            this.startActivity(intent);
        }
        else if(arg0.getId() == R.id.buttonClick2)
        {
            Intent intent = new Intent(this,ThirdActivity.class);
             
            this.startActivity(intent);
        }
    }
}
