package com.example.resistorcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerBand1, spinnerBand2, spinnerBand3, spinnerBand4;
    int resistorValue, tolerancePercentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBand1 = findViewById(R.id.spinnerBand1);
        spinnerBand2 = findViewById(R.id.spinnerBand2);
        spinnerBand3 = findViewById(R.id.spinnerBand3);
        spinnerBand4 = findViewById(R.id.spinnerBand4);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(MainActivity.this, R.array.Band_Colours, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBand1.setAdapter(adapter);
        spinnerBand2.setAdapter(adapter);
        spinnerBand3.setAdapter(adapter);
        spinnerBand4.setAdapter(adapter);

        spinnerBand1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = parentView.getItemAtPosition(position).toString();
                if(selectedItem == "Black"){
                    resistorValue = 0;
                }
                if(selectedItem == "Brown"){
                    resistorValue = 1;
                }
                if(selectedItem == "Red"){
                    resistorValue = 2;
                }
                if(selectedItem == "Orange"){
                    resistorValue = 3;
                }
                if(selectedItem == "Yellow"){
                    resistorValue = 4;
                }
                if(selectedItem == "Green"){
                    resistorValue = 5;
                }
                if(selectedItem == "Blue"){
                    resistorValue = 6;
                }
                if(selectedItem == "Violet"){
                    resistorValue = 7;
                }
                if(selectedItem == "Gray"){
                    resistorValue = 8;
                }
                if(selectedItem == "White"){
                    resistorValue = 9;
                }
                if(selectedItem == "Gold"){
                    resistorValue = 0;
                }
                if(selectedItem == "Silver"){
                    resistorValue = 0;
                }

            }
            public void onNothingSelected(AdapterView<?> parentView) {
                resistorValue = 0;
            }
        });
        spinnerBand2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
        spinnerBand3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
        spinnerBand4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }
    public void doCalculate() {
        TextView result = findViewById(R.id.textViewResult);
        result.setText(Integer.toString(resistorValue));
    }
    public void doClear() {

    }
}