package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class SettingsActivity extends Activity/*AppCompatActivity*/ {
    private InkData data;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Get the data passed from CanvasActivity from the Intent
        data = (InkData)getIntent().getSerializableExtra("InkData");

        //Set up the UIController based on the data passed by the Intent
        SettingUIController controller = new SettingUIController(data, getBaseContext());

        //Set up the buttons
        Button button = findViewById(R.id.back);
        button.setOnClickListener(controller);
        button = findViewById(R.id.clear);
        button.setOnClickListener(controller);

        //Set up the Radio Buttons
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(controller);

        //Set up the Seek Bar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(controller);

    }
}
