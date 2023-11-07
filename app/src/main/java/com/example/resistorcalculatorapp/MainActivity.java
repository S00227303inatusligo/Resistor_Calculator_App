package com.example.resistorcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare variables
    Spinner spinnerBand1, spinnerBand2, spinnerBand3, spinnerBand4;
    double toleranceValue;
    int[] resistanceValues;
    TextView resultTextView, textViewTolerance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialise Spinners
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

        // Declare array for Resistance Values
        resistanceValues = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -2
        };

    }

    public void doCalculate(View view) {
        // Get selected items of each band
        int band1 = spinnerBand1.getSelectedItemPosition();
        int band2 = spinnerBand2.getSelectedItemPosition();
        int band3 = spinnerBand3.getSelectedItemPosition();
        int band4 = spinnerBand4.getSelectedItemPosition();
        resultTextView = findViewById(R.id.textViewResult);

        // Calculating the resistance value based on band selections and set text
        if (band1 != -1 && band2 != -1 && band3 != -1) {
            int resistance = (resistanceValues[band1] * 10 + resistanceValues[band2]) * (int) Math.pow(10, resistanceValues[band3]);
            resultTextView.setText("Resistance: " + resistance + " Ω");
        } else {
            resultTextView.setText("Please select all three color bands.");
        }

        // Takes the value of band 4 and sets the tolerance value based on selection
        if(band4 == 0)
        {
            toleranceValue = 0;
        }
        else if(band4 == 1)
        {
            toleranceValue = 1;
        }
        else if(band4 == 2)
        {
            toleranceValue = 2;
        }
        else if(band4 == 3)
        {
            toleranceValue = 0;
        }
        else if(band4 == 4)
        {
            toleranceValue = 0;
        }
        else if(band4 == 5)
        {
            toleranceValue = 0.5;
        }
        else if(band4 == 6)
        {
            toleranceValue = 0.25;
        }
        else if(band4 == 7)
        {
            toleranceValue = 0.1;
        }
        else if(band4 == 8)
        {
            toleranceValue = 0.05;
        }
        else if(band4 == 9)
        {
            toleranceValue = 0;
        }
        else if(band4 == 10)
        {
            toleranceValue = 5;
        }
        else if(band4 == 11)
        {
            toleranceValue = 10;
        }
        else if(band4 == 12)
        {
            toleranceValue = 20;
        }

        textViewTolerance = findViewById(R.id.textViewTolerance);

        textViewTolerance.setText("Tolerance : ±" + toleranceValue + "%");
    }

    // Clear button functionality
    public void doClear(View view) {
        resultTextView.setText("");
        textViewTolerance.setText("");

        spinnerBand1.setSelection(0);
        spinnerBand2.setSelection(0);
        spinnerBand3.setSelection(0);
        spinnerBand4.setSelection(0);
    }
}