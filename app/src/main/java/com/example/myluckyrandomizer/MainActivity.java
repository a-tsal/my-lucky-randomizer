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
                else resultFinal = Randomizer.randomize(minimum, maximum, elements, switchState);


                txt.setText("The drawn numbers are: \n\n" + resultFinal);
            }
        });
    }
}
