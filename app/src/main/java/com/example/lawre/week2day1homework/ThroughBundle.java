package com.example.lawre.week2day1homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThroughBundle extends AppCompatActivity
{
    EditText year, make, model, color, engine, transmissionType, titleStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_through_bundle);
        year = findViewById(R.id.etYearEdit3);
        make = findViewById(R.id.etMakeEdit3);
        model = findViewById(R.id.etModel3);
        color = findViewById(R.id.etColorEdit3);
        engine = findViewById(R.id.etEngineEdit3);
        transmissionType = findViewById(R.id.etTransmissionEdit3);
        titleStatus = findViewById(R.id.etTransmissionEdit3);
    }

    public void onClick(View view)
    {
        if(view.getId()==R.id.btBackToMain3)
        {
            Intent myIntent = new Intent(this, MainActivity.class);
            Bundle myBundle = new Bundle();
            myBundle.putString("year",year.getText().toString());
            myBundle.putString("make",make.getText().toString());
            myBundle.putString("model",model.getText().toString());
            myBundle.putString("color",color.getText().toString());
            myBundle.putString("engine",engine.getText().toString());
            myBundle.putString("transmission",transmissionType.getText().toString());
            myBundle.putString("title",titleStatus.getText().toString());
            myIntent.putExtras(myBundle);
            startActivity(myIntent);
        }
    }
}
