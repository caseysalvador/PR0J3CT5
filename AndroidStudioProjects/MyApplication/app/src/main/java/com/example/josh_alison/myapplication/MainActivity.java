package com.example.josh_alison.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int protein, carbs, fat;

    private String macroType, activityChoice;

    private TextView textOut;

//    final RadioButton sedentiary = (RadioButton) findViewById(R.id.sedentiaryButton);
//    final RadioButton light = (RadioButton) findViewById(R.id.lightButton);
//    final RadioButton moderate = (RadioButton) findViewById(R.id.moderateButton);
//    final RadioButton heavy = (RadioButton) findViewById(R.id.heavyButton);
//    final RadioButton extremelyHeavy = (RadioButton) findViewById(R.id.extremelyHeavyButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        final EditText current_weight =  (EditText) findViewById(R.id.weight_insert);
        final EditText goal_weight =  (EditText) findViewById(R.id.goal_weight);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText height = (EditText) findViewById(R.id.height);

        int currentWeight =  Integer.parseInt(String.valueOf(current_weight.getText()));
        int goalWeight =  Integer.parseInt(String.valueOf(goal_weight.getText()));
        int ageForCalculation = Integer.parseInt(String.valueOf(age.getText()));
        int heightForCalculation = Integer.parseInt(String.valueOf(height.getText()));

        final RadioButton male = (RadioButton) findViewById(R.id.male);
        final RadioButton female = (RadioButton) findViewById(R.id.female);

        String gender;

        if (male.isChecked()) {
            gender = "male";
        } else {
            gender = "female";
        }



        if (currentWeight == goalWeight) {
            macroType = "Maintain";
        } else if (currentWeight > goalWeight) {
            macroType = "Lose";
        } else {
            macroType = "Gain";
        }

        int macroWeight =  Integer.parseInt(String.valueOf(current_weight.getText()));
        MacroCalculations macroCalculations = new MacroCalculations();
        macroCalculations.setMacros(macroWeight, goalWeight, macroType, activityChoice, ageForCalculation, heightForCalculation, gender);
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
        final RadioButton sedentiary = (RadioButton) findViewById(R.id.sedentiaryButton);
        final RadioButton light = (RadioButton) findViewById(R.id.lightButton);
        final RadioButton moderate = (RadioButton) findViewById(R.id.moderateButton);
        final RadioButton heavy = (RadioButton) findViewById(R.id.heavyButton);
        final RadioButton extremelyHeavy = (RadioButton) findViewById(R.id.extremelyHeavyButton);
        weight.setText("");
        answer.setText("");
        goal_weight.setText("");
        macroType = "";
        sedentiary.setClickable(true); sedentiary.setChecked(false);
        light.setClickable(true); light.setChecked(false);
        moderate.setClickable(true); moderate.setChecked(false);
        heavy.setClickable(true); heavy.setChecked(false);
        extremelyHeavy.setClickable(true); extremelyHeavy.setChecked(false);
    }

    public void activityChoice(View view) {
        final RadioButton sedentiary = (RadioButton) findViewById(R.id.sedentiaryButton);
        final RadioButton light = (RadioButton) findViewById(R.id.lightButton);
        final RadioButton moderate = (RadioButton) findViewById(R.id.moderateButton);
        final RadioButton heavy = (RadioButton) findViewById(R.id.heavyButton);
        final RadioButton extremelyHeavy = (RadioButton) findViewById(R.id.extremelyHeavyButton);


        if (sedentiary.isChecked()) {
            activityChoice = "sedentiary";
            light.setClickable(false);
            moderate.setClickable(false);
            heavy.setClickable(false);
            extremelyHeavy.setClickable(false);
        } else if (light.isChecked()) {
            activityChoice = "light";
            sedentiary.setClickable(false);
            moderate.setClickable(false);
            heavy.setClickable(false);
            extremelyHeavy.setClickable(false);
        } else if(moderate.isChecked()) {
            activityChoice = "moderate";
            light.setClickable(false);
            sedentiary.setClickable(false);
            heavy.setClickable(false);
            extremelyHeavy.setClickable(false);
        } else if (heavy.isChecked()) {
            activityChoice = "heavy";
            light.setClickable(false);
            moderate.setClickable(false);
            sedentiary.setClickable(false);
            extremelyHeavy.setClickable(false);
        } else {
            activityChoice = "extremely heavy";
            light.setClickable(false);
            moderate.setClickable(false);
            heavy.setClickable(false);
            sedentiary.setClickable(false);
        }
    }

    public void genderChoice(View view) {
        final RadioButton male = (RadioButton) findViewById(R.id.male);
        final RadioButton female = (RadioButton) findViewById(R.id.female);

        if (male.isChecked()) {
            female.setClickable(false);
        } else if (female.isChecked()) {
            male.setClickable(false);
        }
    }

}
