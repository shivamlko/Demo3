package com.example.demoapp3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class ManiActivity2 extends AppCompatActivity {
    Spinner spinner;
    AutoCompleteTextView auto;
    ListView listView;
    GridView gridView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        spinner=findViewById(R.id.spinner);
        auto=findViewById(R.id.auto);
        listView=findViewById(R.id.list);
        gridView=findViewById(R.id.grid);

        final ArrayList<String> nameList=new ArrayList<>();
        final ArrayList<Integer> rateList=new ArrayList<>();

        nameList.add("Tea");
        nameList.add("Dosa");
        nameList.add("Milk TEA");
        nameList.add("122324");
        nameList.add("34235");
        nameList.add("1223213124");
        nameList.add("12312314");
        nameList.add("1242342342324");
        nameList.add("5654654645");

        rateList.add(2);
        rateList.add(1);
        rateList.add(3);
        rateList.add(4);
        rateList.add(1);
        rateList.add(4);
        rateList.add(2);
        rateList.add(3);
        rateList.add(4);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ManiActivity2.this,R.layout.item,
                R.id.textView2,nameList);

        MyAdapter myAdapter=new MyAdapter(ManiActivity2.this,nameList,rateList);

        spinner.setAdapter(adapter);
        auto.setAdapter(adapter);

        listView.setAdapter(myAdapter);
        gridView.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("SPINNER",position+" "+nameList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



    }
}
