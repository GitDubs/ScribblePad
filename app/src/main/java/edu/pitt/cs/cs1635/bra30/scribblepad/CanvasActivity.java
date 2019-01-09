package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CanvasActivity extends Activity /*AppCompatActivity*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        InkData data;

        //If data exists coming from the settings activity we use that as our InkData
        if((data = (InkData)getIntent().getSerializableExtra("InkData")) == null) {
            data = new InkData();
            Log.println(Log.INFO, "CanvasActivity", "no data found");
        }

        //Initialize Customview and UIController
        CustomView view = new CustomView(this, data);
        UIController controller = new UIController(data, view);

        //Set up the Buttons
        Button btn = findViewById(R.id.undo);
        btn.setOnClickListener(controller);
        btn = findViewById(R.id.settings);
        btn.setOnClickListener(controller);

        //Set up the Line width label
        TextView textView = findViewById(R.id.lineWidth);
        textView.setText("Line Width: " + data.getPathWidth());

        //Set up the current color box
        View currentColor = findViewById(R.id.currentColor);
        currentColor.setBackgroundColor(data.getCurColor());

        //Set up the drawing layout (CustomView)
        view.setOnTouchListener(controller);
        ViewGroup linearLayout = findViewById(R.id.verticalLinear);
        view.setLayoutParams(linearLayout.getLayoutParams());
        linearLayout.addView(view);

    }
}
