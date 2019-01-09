package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;


public class SettingUIController implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "UIController";
    private InkData data;
    private Context context;

    /*
    ------------------------------------------------------------------------------------------------
    default constructor
    ------------------------------------------------------------------------------------------------
     */
    public SettingUIController(InkData data, Context context){
        this.data = data;
        this.context = context;
    }


    /*
    ------------------------------------------------------------------------------------------------
    onClick: Defines action for back button, and clear button
    ------------------------------------------------------------------------------------------------
     */
    public void onClick(View v){
        if(v.getId() == R.id.back){
            Intent intent = new Intent(v.getContext(), CanvasActivity.class);
            intent.putExtra("InkData", data);
            v.getContext().startActivity(intent);
        }else if(v.getId() == R.id.clear){
            data.clear();
        }
    }

    /*
    ------------------------------------------------------------------------------------------------
    onCheckedChanged: updates the current color being drawn based on which RadioButton in the
    RadioGroup is checked
    ------------------------------------------------------------------------------------------------
     */
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if(checkedId == R.id.blue){
            data.setColor(Color.BLUE);
        }else if(checkedId == R.id.green)
            data.setColor(Color.GREEN);
        else if(checkedId == R.id.red)
            data.setColor(Color.RED);
        else if(checkedId == R.id.yellow)
            data.setColor(Color.YELLOW);
        else if(checkedId == R.id.black)
            data.setColor(Color.BLACK);
    }

    /*
    ------------------------------------------------------------------------------------------------
    onProgressChanged: sets the path width based on the progress of the seekbar
    ------------------------------------------------------------------------------------------------
     */
    public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser){
        data.setPathWidth(progress);
    }

    /*
    ------------------------------------------------------------------------------------------------
    onStopTrackingTouch: override, does nothing
    ------------------------------------------------------------------------------------------------
     */
    public void onStopTrackingTouch(SeekBar s){ return; }

    /*
    ------------------------------------------------------------------------------------------------
    onStartTrackingTouch: override, does nothing
    ------------------------------------------------------------------------------------------------
     */
    public void onStartTrackingTouch(SeekBar s){ return; }
}