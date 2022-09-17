package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int red;
    private int green = 0;
    private int blue = 0;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;
    TextView rgb;
    TextView showColor;
    TextView redNumber;
    TextView greenNumber;
    TextView blueNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBar = (SeekBar) findViewById(R.id.RedBar);
        greenBar = (SeekBar) findViewById(R.id.GreenBar);
        blueBar = (SeekBar) findViewById(R.id.BlueBar);
        rgb = (TextView) findViewById(R.id.Rgb);
        showColor = (TextView) findViewById(R.id.ShowColor);
        redNumber = (TextView) findViewById(R.id.RedNumber);
        greenNumber = (TextView) findViewById(R.id.GreenNumber);
        blueNumber = (TextView) findViewById(R.id.BlueNumber);

        //NightMode ellenőrzése szövegszín miatt
        int nightMode = getApplicationContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightMode) {
            case  Configuration.UI_MODE_NIGHT_YES:
                rgb.setTextColor(Color.rgb(255,255,255));
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                rgb.setTextColor(Color.rgb(0,0,0));
                break;
        }

        //Sliderek
        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                showColor.setBackgroundColor(Color.rgb(red, green, blue));
                redNumber.setText(String.valueOf(red));
                rgb.setText("("+red+","+green+","+blue+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                showColor.setBackgroundColor(Color.rgb(red, green, blue));
                greenNumber.setText(String.valueOf(green));
                rgb.setText("("+red+","+green+","+blue+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                showColor.setBackgroundColor(Color.rgb(red, green, blue));
                blueNumber.setText(String.valueOf(blue));
                rgb.setText("("+red+","+green+","+blue+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}