package edu.pitt.cs.cs1635.bra30.scribblepad;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.io.Serializable;

public class Stroke implements Serializable{
    private static final String TAG = "Stroke";
    private int DEFAULT_ARRAY_SIZE = 150;
    private int color;
    private int size;
    private int numPoints;
    private float[] coordinates;        //coordinates[i] = x
                                        //coordinates[i + 1] = y

    /*
    ------------------------------------------------------------------------------------------------
    default constructor
    ------------------------------------------------------------------------------------------------
     */
    public Stroke(int color){
        this.color = color;
        size = 0;
        numPoints = 0;
        coordinates = new float[DEFAULT_ARRAY_SIZE];
    }

    /*
    ------------------------------------------------------------------------------------------------
    getColor: returns this stroke's color in an int
    ------------------------------------------------------------------------------------------------
     */
    public int getColor(){
        return color;
    }

    /*
    ------------------------------------------------------------------------------------------------
    getPoints: returns the points array that represents the points in the stroke
    ------------------------------------------------------------------------------------------------
     */
    public float[] getPoints(){
        float[] toReturn = new float[size];
        java.lang.System.arraycopy(coordinates,0, toReturn, 0, size);
        return toReturn;
    }

    /*
    ------------------------------------------------------------------------------------------------
    getSize: returns the number of points the array represents
    ------------------------------------------------------------------------------------------------
     */
    public int getSize(){
        return size;
    }

    /*
    ------------------------------------------------------------------------------------------------
    addPoint: adds the (x, y) point to the array
    ------------------------------------------------------------------------------------------------
     */
    public void addPoint(float x, float y){

        //Resize array if necessary
        if(size >= coordinates.length){
            float[] tempArray = new float[coordinates.length * 2];
            java.lang.System.arraycopy(coordinates,0, tempArray, 0, coordinates.length);
            coordinates = tempArray;
        }

        //Add coordinates
        coordinates[size] = x;
        coordinates[size + 1] = y;
        size += 2;
        numPoints++;
    }

    /*
    ------------------------------------------------------------------------------------------------
    toString: prints out every x,y point in the array
    ------------------------------------------------------------------------------------------------
     */
    public String toString(){
        for (int i = 0; i < size - 1; i+=2) {
            Log.println(Log.INFO, TAG, "coordinates: " + coordinates[i] + "\ncoordinates: " + coordinates[i + 1]);
        }
        return "";
    }
}
