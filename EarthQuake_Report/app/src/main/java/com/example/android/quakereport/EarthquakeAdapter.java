package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeObject> {

//    public EarthquakeAdapter(@NonNull Context context, int resource, @NonNull EarthquakeObject[] objects) {
//        super(context, resource, objects);
//    }
Context context;
List<EarthquakeObject> earthquakeObjects;
String kmString, place;
public final String LOCATION_SEPARATOR = " of ";
    public EarthquakeAdapter(@NonNull Context context, @NonNull List<EarthquakeObject> objects) {
        super(context, 0, objects);
        this.context = context;
        earthquakeObjects = objects;
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        view = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

        EarthquakeObject earthquakeObject = getItem(position);
        TextView size, location, date, locationname;
        size = (TextView) view.findViewById(R.id.size);
        location = (TextView) view.findViewById(R.id.location);
        locationname = (TextView) view.findViewById(R.id.locationname);
        date = (TextView) view.findViewById(R.id.date);
        assert earthquakeObject != null;

        String magnitude = formatMagnitude(earthquakeObject.getmEarthQuakeSize());
        size.setText(magnitude);
        // getting the background using gradientDrawable
        GradientDrawable gradientDrawable = (GradientDrawable) size.getBackground();
        // get color as per the value received
        int mag_color = getMagnitudeColor(earthquakeObject.getmEarthQuakeSize());
        // set the color on the circle
        gradientDrawable.setColor(mag_color);

        String originalLocation = earthquakeObject.getmLocation();
        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
           kmString =  parts[0] + LOCATION_SEPARATOR;
           place = parts[1];
            location.setText(kmString);
            locationname.setText(place);
        }else
        {
            locationname.setText(earthquakeObject.getmLocation());
//            locationname.setText(place);
        }



        Date date1 = new Date(earthquakeObject.getmDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM DD, yyyy");
        String formatter = simpleDateFormat.format(date1);

        date.setText(formatter);
        return view;
    }

    private String formatMagnitude(double d) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(d);
    }
    private int getMagnitudeColor(double mag){
        int colorid;
        int mag_number =(int) Math.floor(mag);

        switch (mag_number){
            case 1:
                colorid = R.color.magnitude1;
                break;
            case 2:
                colorid = R.color.magnitude2;
                break;
            case 3:
                colorid = R.color.magnitude3;
                break;
            case 4:
                colorid = R.color.magnitude4;
                break;
            case 5:
                colorid = R.color.magnitude5;
                break;
            case 6:
                colorid = R.color.magnitude6;
                break;
            case 7:
                colorid = R.color.magnitude7;
                break;
            case 8:
                colorid = R.color.magnitude8;
                break;
            case 9:
                colorid = R.color.magnitude9;
                break;
            case 10:
                colorid = R.color.magnitude10plus;
                break;
                default:
                    colorid = R.color.magnitude10plus;

        }
        return ContextCompat.getColor(getContext(),colorid);
        // converting color resource id into an sctual integer value
    }
}
