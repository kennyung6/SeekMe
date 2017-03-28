package com.inducesmile.seekme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by kenny on 3/28/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Declares the SeekBar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekMe);
        // Declares the Seek Progress TextView
        final TextView seekText = (TextView) findViewById(R.id.seekTxt);

        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    if (progress >= 40 && progress <= 45) {

                        String progressString = String.valueOf(progress);
                        seekText.setText(progressString); // the TextView Reference

                        // Make the text glued to the scroller
                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        seekText.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);

                    } else {
                        seekText.setText("");
                    }
                }

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
