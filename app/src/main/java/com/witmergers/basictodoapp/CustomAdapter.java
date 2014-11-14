package com.witmergers.basictodoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by WP8Dev on 14-11-2014.
 */
public class CustomAdapter extends ArrayAdapter {

    public  Context context;

    private final String[] values;

    public CustomAdapter(Context context, String[] values) {
        super(context, R.layout.listlayout1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listlayout1, parent, false);
        TextView textView = (TextView) row.findViewById(R.id.textview1);

        return row;
    }
}
