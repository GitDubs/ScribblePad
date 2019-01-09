package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class CustomView extends View {
    private static final String TAG = "CustomView";
    private InkData data;

    public CustomView(Context context, InkData data){
        super(context);
        this.data = data;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint paint;

        //Get every stroke
        ArrayList<Stroke> allStrokes = data.getAllStrokes();

        //Loop through and draw every stroke
        for(Stroke toDraw : allStrokes) {

            //Set up the paint object based on the color defined in the Stroke toDraw
            paint = new Paint();
            paint.setColor(toDraw.getColor());
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.MITER);
            paint.setStrokeWidth(data.getPathWidth());

            try {
                float[] points = toDraw.getPoints();
                canvas.drawLines(points, 0, toDraw.getSize(), paint);               //Draw point1-point2, point3 - point4, etc
                canvas.drawLines(points, 2, toDraw.getSize() - 2, paint);    //Draw point2-point3, point4 - point5, etc
            } catch (Exception e) {
                Log.println(Log.ERROR, TAG, "Empty List");
            }
        }
    }

}
