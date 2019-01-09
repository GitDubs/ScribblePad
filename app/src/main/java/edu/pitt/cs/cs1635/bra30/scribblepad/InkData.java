package edu.pitt.cs.cs1635.bra30.scribblepad;

import java.io.Serializable;
import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.Paint;

public class InkData implements Serializable{
    private static final int MAX_WIDTH = 10;
    private static final int MIN_WIDTH = 3;
    private static final int DEFAULT_COLOR = Color.BLUE;
    private int pathWidth;
    private int color;
    private ArrayList strokeList;

    /*
    ------------------------------------------------------------------------------------------------
    default constructor
    ------------------------------------------------------------------------------------------------
     */
    public InkData() {
        strokeList = new ArrayList<Stroke>();
        pathWidth = 4;
        color = DEFAULT_COLOR;
    }

    /*
    ------------------------------------------------------------------------------------------------
    setColor: sets the color to the color specified by an integer
    ------------------------------------------------------------------------------------------------
     */
    public void setColor(int color){
        this.color = color;
    }

    /*
    ------------------------------------------------------------------------------------------------
    setPathWidth: takes a width w, and checks that it is a legal width, and sets the current width
    to w
    ------------------------------------------------------------------------------------------------
     */
    public boolean setPathWidth(int w) {
        if (w <= MAX_WIDTH && w >= MIN_WIDTH) {
            pathWidth = w;
            return true;
        }
        return false;
    }

    /*
    ------------------------------------------------------------------------------------------------
    getCurColor: returns the current color as an int
    ------------------------------------------------------------------------------------------------
     */
    public int getCurColor(){
        return color;
    }

    /*
    ------------------------------------------------------------------------------------------------
    getPathWidth: returns the current path width
    ------------------------------------------------------------------------------------------------
     */
    public int getPathWidth() {
        return pathWidth;
    }

    /*
    ------------------------------------------------------------------------------------------------
    newStroke: starts a new stroke by adding a new Stroke object to the ArrayList
    ------------------------------------------------------------------------------------------------
     */
    public void newStroke(float x, float y){
        Stroke newStroke = new Stroke(color);
        newStroke.addPoint(x, y);
        strokeList.add(newStroke);
    }

    /*
    ------------------------------------------------------------------------------------------------
    editCurrentStroke: allows a new point (x, y) to be added to the most recent stroke added to the
    ArrayList
    ------------------------------------------------------------------------------------------------
     */
    public void editCurrentStroke(float x, float y){
        Stroke temp = (Stroke)strokeList.get(strokeList.size() - 1);
        temp.addPoint(x, y);
    }

    /*
    ------------------------------------------------------------------------------------------------
    removeLastStroke: deletes the last stroke from the stroke stack
    Intended Use: to be used by the controller to "undo" the last stroke
    NOTE: I might have to redraw the canvas completely to get this to work
    ------------------------------------------------------------------------------------------------
     */
    public void removeLastStroke(){
        if(!strokeList.isEmpty())
            strokeList.remove(strokeList.size() - 1);
    }

    /*
    ------------------------------------------------------------------------------------------------
    clear: resets the ArrayList and removes all the strokes on the page
    ------------------------------------------------------------------------------------------------
     */
    public void clear(){
        strokeList = new ArrayList<Stroke>();
    }



    public ArrayList<Stroke> getAllStrokes(){return strokeList; }

}
