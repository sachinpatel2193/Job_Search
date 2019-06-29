package com.myproject.sachinpatel.jobsearch;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.sachinpatel.jobsearch.R;

public class MainActivity extends AppCompatActivity {

    Spinner selectProvince;
    Button submitButton;
    EditText Job_poistion, location_City;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectProvince = (Spinner)findViewById(R.id.province);
        submitButton = (Button)findViewById(R.id.submit);
        Job_poistion = (EditText)findViewById(R.id.jobposition);
        location_City = (EditText)findViewById(R.id.city);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String position = Job_poistion.getText().toString();
                Log.d("position", position);
                String City = location_City.getText().toString();
                Log.d("city", City);
                String Province = selectProvince.getSelectedItem().toString();
                Log.d("Province", Province);

                Intent intent = new Intent(MainActivity.this, PortalPage.class);
                intent.putExtra("position", position);
                intent.putExtra("city", City);
                intent.putExtra("province", Province);
                startActivity(intent);

            }
        });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.province_names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectProvince.setAdapter(myAdapter);

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
