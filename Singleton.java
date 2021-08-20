package com.example.myapplication;

import android.util.Log;

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }


    private int[] intArray;
    private int arraySize;

    public Singleton() {

        intArray = new int[1];
        arraySize =0;
    }


    /* this is a dynamic array for use of simple app had this been using larger ammounts of number
    I would switch to a list node modle or maybe even a dynamic search tree.
    */
    public void addintArray(int addedInt) {
        if (arraySize == 0)
        {
            intArray[arraySize] = addedInt;
            arraySize ++;
        }
        else
        {
            int[] bigArray = new int [arraySize +1];
            for(int i=0; i<arraySize; i++) bigArray[i] = intArray[i];

            bigArray[arraySize] = addedInt;
            intArray = bigArray;
            arraySize ++;
        }
    }

    public void clearintArry()
    {
        intArray = new int[1];
        arraySize =0;
    }

    public int[] getIntArray()
    {
        return intArray;
    }

}

