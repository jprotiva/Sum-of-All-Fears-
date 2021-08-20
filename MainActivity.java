package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public Singleton intArray = new Singleton();

    public class mainThread implements Runnable
    {
        public void run() {
            try {
                Main();
            }
            catch(Exception e){
                Log.d("Main","LoginMain thread error: " + e);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(new MainActivity.mainThread());
        t.start();
    }

    public void Main()
    {
        makeLookGood();
        setListaners();

    }

    public void makeLookGood()
    {
        TextView text=(TextView)findViewById(R.id.textExplanation);
        text.setText("Given a list of numbers and a number K, return whether any two numbers from " +
                "the list add up to K. Example: given [10, 15, 3, 7] and K of 17, return true since " +
                "10 + 7 is 17.");
    }

    public void setListaners()
    {
        Button addTo= findViewById(R.id.addTo);
        Button clear= findViewById(R.id.clear);
        Button run= findViewById(R.id.run);

        addTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main","user pressed: addTo Button");
                addto();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main","user pressed: clear Button");
                intArray.clearintArry();
                clearArray();

            }
        });

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Main","user pressed: run Button");
                do_the_point_of_this_app();

            }
        });

    }

    public void addto()
    {

        try {
                TextView intToAdd = findViewById(R.id.intToAdd);
                String tempS = "" + intToAdd.getText();
                int i = Integer.parseInt(tempS);
                intArray.addintArray(i);
                setArrayView();
                intToAdd.setText("");
        }
        catch (Exception e) {
            Log.d("Main","try error e: " + e);
            ImageView SumImage =  findViewById(R.id.sum_image);
            SumImage.setImageResource(R.drawable.error);
        }
    }




    public void clearArray()
    {
        TextView showIntArray = findViewById(R.id.showIntArray);
        String clearString= "";
        showIntArray.setText(clearString);

        ImageView SumImage =  findViewById(R.id.sum_image);
        SumImage.setImageResource(R.drawable.sum_of_fears);


    }

    public void setArrayView()
    {
        TextView showIntArray = findViewById(R.id.showIntArray);
        int array[] = intArray.getIntArray();

        String newShowString = "[";
        for(int i=0; i< array.length; i++)
        {
            if(i +1 == array.length)
            {
                newShowString = newShowString + array[i];
            }
            else
            {
                newShowString = newShowString + array[i] + ", ";
            }
        }
        newShowString = newShowString + "]";

        showIntArray.setText(newShowString);
    }

    public void do_the_point_of_this_app()
    {
        try {
            boolean test = false;
            TextView kvalue = findViewById(R.id.kValue);
            String gonnaBeK = "" + kvalue.getText();
            int k = Integer.parseInt(gonnaBeK);
            int testArray[] = intArray.getIntArray();

            for (int i = 0; i < testArray.length; i++) {
                for (int j = 1; j < testArray.length - i; j++) {
                    if (testArray[i] + testArray[i + j] == k) {
                        test = true;
                    }
                }
            }

            ImageView SumImage = findViewById(R.id.sum_image);

            if (test) {
                SumImage.setImageResource(R.drawable.true1);
            } else {
                SumImage.setImageResource(R.drawable.false1);
            }


            Log.d("main", "do_the_point_of_this_app: " + test
            );
        }
        catch (Exception e) {
            Log.d("Main","try error e: " + e);
            ImageView SumImage =  findViewById(R.id.sum_image);
            SumImage.setImageResource(R.drawable.error);
        }

    }
}
