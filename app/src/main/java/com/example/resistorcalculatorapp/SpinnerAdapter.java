package com.example.resistorcalculatorapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends BaseAdapter {
    int[] colors;
    Context context;
    String[] colorNames;

    public SpinnerAdapter(Context context, int[] colors, String[] colorNames)
    {
        this.context = context;
        this.colors = colors;
        this.colorNames = this.colorNames;
    }

    @Override
    public int getCount() {
        return colors != null ? colors.length : 0; // Check if colors array is not null
    }

    @Override
    public Object getItem(int position) {
        return colors != null && position >= 0 && position < colors.length ? colors[position] : 0;
    }

    public long getItemId(int arg0) {
        return arg0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);

        TextView txv = view.findViewById(android.R.id.text1);

        int[] colorArray = context.getResources().getIntArray(R.array.androidcolors);
        colorNames = context.getResources().getStringArray(R.array.Band_Colours);
        if (pos < colorArray.length) {
            txv.setBackgroundColor(colorArray[pos]);
        }

        txv.setTextSize(20f);
        txv.setText(colorNames[pos]);

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView txv = convertView.findViewById(android.R.id.text1);
        txv.setBackgroundColor(colors[position]);
        txv.setTextSize(20f);
        txv.setText(colorNames[position]);

        if (colorNames[position].equals("Black")) {
            txv.setTextColor(colors[9]);
        } else {
            txv.setTextColor(colors[0]);
        }

        return convertView;
    }


}
