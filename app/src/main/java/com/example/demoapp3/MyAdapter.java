package com.example.demoapp3;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by NAVOKI on 2/25/2018.
 */

public class MyAdapter extends ArrayAdapter {

    ArrayList<String> list2;
    ArrayList<Integer> rateList2;
    Context context2;

    public MyAdapter(Context context, ArrayList<String> list, ArrayList<Integer> rateList) {
        super(context, R.layout.item);
        list2 = list;
        rateList2 = rateList;
        context2 = context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = View.inflate(context2, R.layout.item, null);
        final TextView textView2;
        RatingBar rate;

        textView2 = (TextView) view.findViewById(R.id.textView2);
        rate = (RatingBar) view.findViewById(R.id.rate);
        ImageView img;

        img = (ImageView) view.findViewById(R.id.img);

        textView2.setText(list2.get(position));

        if(position%2==0) {
            textView2.setTextColor(Color.GREEN);
        }

        rate.setMax(5);
        rate.setNumStars(5);
        Log.e("RATE", rateList2.get(position) + "");
        rate.setProgress(rateList2.get(position));

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context2, position + " " + list2.get(position), Toast.LENGTH_SHORT).show();
                textView2.setTextColor(Color.BLUE);
            }
        });

        return view;
    }


    @Override
    public int getCount() {
        return list2.size();
    }
}
