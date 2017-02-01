package com.example.josh_alison.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int protein, carbs, fat;

    private String macroType;

    private TextView textOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        final EditText current_weight =  (EditText) findViewById(R.id.weight_insert);
        final EditText goal_weight =  (EditText) findViewById(R.id.goal_weight);

        int currentWeight =  Integer.parseInt(String.valueOf(current_weight.getText()));
        int goalWeight =  Integer.parseInt(String.valueOf(goal_weight.getText()));

        if (currentWeight == goalWeight) {
            macroType = "Maintain";
        } else if (currentWeight > goalWeight) {
            macroType = "Lose";
        } else {
            macroType = "Gain";
        }

        int macroWeight =  Integer.parseInt(String.valueOf(current_weight.getText()));
        MacroCalculations macroCalculations = new MacroCalculations();
        macroCalculations.setMacros(macroWeight, goalWeight, macroType);
        textOut = (TextView) findViewById(R.id.macro_answer);
        textOut.setText("To " + macroType + ": \n" +
                        macroCalculations.getCarbs()  + "g Carbs \n" +
                        macroCalculations.getProtein() + "g Protein \n" +
                        macroCalculations.getFat() + "g Fat");


    }

    public void clearText(View view) {
        final EditText weight =  (EditText) findViewById(R.id.weight_insert);
        final EditText answer =  (EditText) findViewById(R.id.macro_answer);
        final EditText goal_weight =  (EditText) findViewById(R.id.goal_weight);
        weight.setText("");
        answer.setText("");
        goal_weight.setText("");
        macroType = "";
    }

}
