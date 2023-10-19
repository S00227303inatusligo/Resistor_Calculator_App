package com.example.resistorcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
public class MainActivity extends AppCompatActivity {

    Spinner spinnerBand1 = findViewById(R.id.spinnerBand1);
    Spinner spinnerBand2 = findViewById(R.id.spinnerBand2);
    Spinner spinnerBand3 = findViewById(R.id.spinnerBand3);
    Spinner spinnerBand4 = findViewById(R.id.spinnerBand4);
    ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Band_Colours, android.R.layout.simple_spinner_item);

    adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

    spinnerBand1.setAdapter(adapter);


}