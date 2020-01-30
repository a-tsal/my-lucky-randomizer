package com.example.myluckyrandomizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    public static String randomize(int min, int max, int n, boolean replacement) {

        String res = "";

        if (min >= max)
            res = "Error: The minimum possible number cannot be greater or equal to the maximum passible number";

        else {
            int length = (max - min) + 1;
            int[] elements = new int[length];
            if (length < n && replacement == false)
                res = "Error: If the replacement is off, then the range of the possible numbers cannot be less than the numbers to be drawn";
            else {
                for (int i = 0; i < length; i++) elements[i] = min + i;
                List<Integer> drawnList = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int index;
                    Random rand = new Random();
                    index = rand.nextInt(length);
                    if (replacement == false)
                        while (drawnList.contains(elements[index])) index = rand.nextInt(length);
                    drawnList.add(elements[index]);
                    if (i == 0) res = res + drawnList.get(i);
                    else res = res + ", " + drawnList.get(i);
                }
            }
        }
        return res;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                String resultFinal = "";
                EditText entryMinimum = (EditText) findViewById(R.id.enter_minimum);

                Switch simpleSwitch = (Switch) findViewById(R.id.switch2);
                Boolean switchState = simpleSwitch.isChecked();
                int minimum = 0;
                try {
                      minimum = Integer.parseInt(entryMinimum.getEditableText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    resultFinal = e.toString();
                }

                int maximum = 0;

                EditText entryMaximum = (EditText) findViewById(R.id.enter_maximum);

                try{
                    maximum = Integer.parseInt(entryMaximum.getEditableText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    resultFinal =  e.toString();
                }

                int elements = 0;
                EditText entryElements = (EditText) findViewById(R.id.enter_the_number_of_elements);
                try {
                    elements = Integer.parseInt(entryElements.getEditableText().toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    resultFinal =  e.toString();
                }
                if (resultFinal != "") resultFinal = "Error: You must fill all the required fields with numeric descrete values";
                else resultFinal = randomize(minimum, maximum, elements, switchState);


                txt.setText("The drawn numbers are: \n\n" + resultFinal);
            }
        });
    }
}
