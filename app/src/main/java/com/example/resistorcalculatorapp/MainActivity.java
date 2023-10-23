package com.example.resistorcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerBand1, spinnerBand2, spinnerBand3, spinnerBand4;
    int toleranceValue;
    int[] resistanceValues;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBand1 = findViewById(R.id.spinnerBand1);
        spinnerBand2 = findViewById(R.id.spinnerBand2);
        spinnerBand3 = findViewById(R.id.spinnerBand3);
        spinnerBand4 = findViewById(R.id.spinnerBand4);

        // Load the color array from resources
        int[] colors = getResources().getIntArray(R.array.androidcolors);
        String[] colorNames = getResources().getStringArray(R.array.Band_Colours);

        // Create custom adapters for each Spinner
        SpinnerAdapter adapter1 = new SpinnerAdapter(this, colors, colorNames);
        SpinnerAdapter adapter2 = new SpinnerAdapter(this, colors, colorNames);
        SpinnerAdapter adapter3 = new SpinnerAdapter(this, colors, colorNames);
        SpinnerAdapter adapter4 = new SpinnerAdapter(this, colors, colorNames);

        // Set the custom adapters for each Spinner
        spinnerBand1.setAdapter(adapter1);
        spinnerBand2.setAdapter(adapter2);
        spinnerBand3.setAdapter(adapter3);
        spinnerBand4.setAdapter(adapter4);

        resistanceValues = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -2
        };



    }

    public void doCalculate(View view) {
        int band1 = spinnerBand1.getSelectedItemPosition();
        int band2 = spinnerBand2.getSelectedItemPosition();
        int band3 = spinnerBand3.getSelectedItemPosition();
        int band4 = spinnerBand4.getSelectedItemPosition();
        resultTextView = findViewById(R.id.textViewResult);

        if (band1 != -1 && band2 != -1 && band3 != -1) {
            int resistance = (resistanceValues[band1] * 10 + resistanceValues[band2]) * (int) Math.pow(10, resistanceValues[band3]);
            resultTextView.setText("Resistance: " + resistance + " ohms");
        } else {
            resultTextView.setText("Please select all three color bands.");
        }
    }
}