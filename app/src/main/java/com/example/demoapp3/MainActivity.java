package com.example.demoapp3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.demoapp3.Activity.ABC;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    TextView tv;
    CheckBox checkBox;
    RadioGroup radioGroup;
    SeekBar seekBar;
    ProgressBar progress,progress2,progress3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_main);

         btn=findViewById(R.id.btn);
         tv=findViewById(R.id.textView);
        checkBox=findViewById(R.id.checkBox);
        radioGroup=findViewById(R.id.radioGroup);
        progress=findViewById(R.id.progress);
        progress2=findViewById(R.id.progress2);
        progress3=findViewById(R.id.progress3);
        seekBar=findViewById(R.id.seekBar);

         btn.setText("LOGIN");

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 tv.setText("Hello Everyone");
                // tv.setBackgroundColor(Color.CYAN);
                 tv.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));

                 Intent intent=new Intent(MainActivity.this,ManiActivity2.class);
                 startActivity(intent);
             }
         });


         checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 Log.e("MainActivity",isChecked+"");
             }
         });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.radioButton1)
                {
                    Log.e("RADIO","MALE");

                }
                else if(checkedId==R.id.radioButton2)
                {
                    Log.e("RADIO","FEMALE");

                }
            }
        });

//Views

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
                progress2.setProgress(80);

                progress3.setIndeterminate(false);
                progress3.setProgress(40);
            }
        },3000);




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("SEEK",""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("SEEK","START");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("SEEK","STOP");

            }
        });

    }




}
