package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class UIController implements View.OnTouchListener, View.OnClickListener {
    private static final String TAG = "UIController";
    private InkData data;
    View view;

    /*
    ------------------------------------------------------------------------------------------------
    default constructor
    ------------------------------------------------------------------------------------------------
     */
    public UIController(InkData data, View view){
        this.data = data;
        this.view = view;
    }

    /*
    ------------------------------------------------------------------------------------------------
    onTouch: tracks finger drags on the canvas, maps the points into the data structure, and
    calls for a redraw
    ------------------------------------------------------------------------------------------------
     */
    public boolean onTouch(View v, MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            data.newStroke(event.getX(), event.getY());
        }else if(event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_UP){
            data.editCurrentStroke(event.getX(), event.getY());
        }

        //Invalidating the view schedules a redraw
        view.invalidate();
        return true;
    }


    /*
    ------------------------------------------------------------------------------------------------
    onClick: define actions for the undo button, and the settings button
    ------------------------------------------------------------------------------------------------
     */
    public void onClick(View v){
        if(v.getId() == R.id.undo) {
            data.removeLastStroke();
            view.invalidate();
        }else if(v.getId() == R.id.settings){
            Intent intent = new Intent(view.getContext(), SettingsActivity.class);
            intent.putExtra("InkData", data);
            Log.println(Log.INFO, TAG, "Settings");
            view.getContext().startActivity(intent);
        }
    }
}
