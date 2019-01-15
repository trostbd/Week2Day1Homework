package com.example.lawre.week2day1homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PassForResult extends AppCompatActivity
{
    EditText year, make, model, color, engine, transmissionType, titleStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_for_result);
        year = findViewById(R.id.etYearEdit2);
        make = findViewById(R.id.etMakeEdit2);
        model = findViewById(R.id.etModel2);
        color = findViewById(R.id.etColorEdit2);
        engine = findViewById(R.id.etEngineEdit2);
        transmissionType = findViewById(R.id.etTransmissionEdit2);
        titleStatus = findViewById(R.id.etTitleEdit2);
    }

    public void onClick(View view)
    {
        if(view.getId()==R.id.btBackToMain2)
        {
            Car newCar = new Car(year.getText().toString(),
                    make.getText().toString(),
                    model.getText().toString(),
                    color.getText().toString(),
                    engine.getText().toString(),
                    transmissionType.getText().toString(),
                    titleStatus.getText().toString());
            Intent intentToMain = new Intent(this, MainActivity.class);
            intentToMain.putExtra("car",newCar);
            setResult(413,intentToMain);
            finish();
        }
    }
}
