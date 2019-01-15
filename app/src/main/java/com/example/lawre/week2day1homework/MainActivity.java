package com.example.lawre.week2day1homework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView year, make, model, color, engine, transmissionType, titleStatus;
    public static final int REQUEST_CODE = 413;
    public static final String TAG = "tag";
    SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = findViewById(R.id.tvYear);
        make = findViewById(R.id.tvMake);
        model = findViewById(R.id.tvModel);
        color = findViewById(R.id.tvColor);
        engine = findViewById(R.id.tvEngine);
        transmissionType = findViewById(R.id.tvTransmission);
        titleStatus = findViewById(R.id.tvTitle);
        myPrefs = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPrefs.edit();
        myEditor.putString("make",make.getText().toString());
        myEditor.putString("model",model.getText().toString());
        myEditor.commit();
        Log.d(TAG, "make: " + myPrefs.getString("make","") + "\nmodel: " + myPrefs.getString("model",""));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null)
        {
            Car theCar = data.getParcelableExtra("car");
            year.setText(theCar.getYear());
            make.setText(theCar.getMake());
            model.setText(theCar.getModel());
            color.setText(theCar.getColor());
            engine.setText(theCar.getEngine());
            transmissionType.setText(theCar.getTransmissionType());
            titleStatus.setText(theCar.getTitleStatus());
        }
    }


    public void onClick(View view)
    {
        if(view.getId()==R.id.btOne)
        {
            Intent resultIntent = new Intent(this,PassForResult.class);
            startActivityForResult(resultIntent,REQUEST_CODE);
        }
        else if(view.getId()==R.id.btTwo)
        {
            Intent bundleIntent = new Intent(this,ThroughBundle.class);
            startActivity(bundleIntent);
        }
    }
}
