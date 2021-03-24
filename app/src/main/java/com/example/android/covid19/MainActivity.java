package com.example.android.covid19;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Calculates the score of the quiz by fetching
     *score from several other methods
     * Exits the method if there are validation errors on UI*/

    public void calculateScore(View view) {

        /*Initialize value for score*/

        int score = 0;

        /*Exit method if no radio button is selected for question 1*/

        if (setQ1Response() == -1) {
            return;
        }

        /*Exit method if errors with check box for question 2*/

        if (setQ2Response() == -1) {
            return;
        }

        /*Exit method if no radio button is selected for question 3*/

        if (setQ3Response() == -1) {
            return;
        }

        /*Fetch the answer entered for question 4*/

        EditText editText = findViewById(R.id.question_4_Answer);
        String q4Answer = editText.getText().toString();

        /*Validate question 4 for no entry in the text field*/

        if (q4Answer.equalsIgnoreCase("")) {
            validateUI("question 4", false);
            return;
        }

        /*Check if the answer is correct. Increment score if correct*/

        else if (q4Answer.equalsIgnoreCase("pandemic")) {
            score = score + 1;
        }

        /*Exit method if errors with check box for question 5*/

        if (setQ5Response() == -1) {
            return;
        }

        /*Calculate the score and show the toast*/

        score = score + setQ1Response() + setQ2Response() + setQ3Response() + setQ5Response();
        Toast toast = Toast.makeText(this, "Your score is : " + score + "/5", Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Fetches the selected Radio button for question 1
     * Increment the score by 1, if the question is answered correctly
     **/

    public int setQ1Response() {
        int scoreQ1 = 0;
        RadioGroup radioGroup = findViewById(R.id.question_1_Radio);
        int buttonId = radioGroup.getCheckedRadioButtonId();

        /*Check if no answer selected for this question. Call the validate method to return error*/

        if (buttonId == -1) {
            validateUI("question 1", false);
            return buttonId;
        }
        RadioButton radioButton = radioGroup.findViewById(buttonId);
        String selectedOption = (String) radioButton.getText();
        if (selectedOption.equals("Corona Virus Disease")) {
            scoreQ1 = scoreQ1 + 1;
        }
        return scoreQ1;
    }

    /*
     * Checks the checked state for the check box
     * Keeps count of number of check boxes checked
     * Increment score by 1 if user selected option 1,4 in question 2
     * Validate if more than 2 options are checked
     */

    public int setQ2Response() {
        int scoreQ2 = 0;
        int checkedCount = 0;

        /*
         *Check the state of the each of the check box
         * Increment the count of checked boxes by 1 if a box is checked
         */

        CheckBox checkBox = findViewById(R.id.question_2_Op1);
        boolean isOp1Selected = checkBox.isChecked();
        if (isOp1Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox1 = findViewById(R.id.question_2_Op2);
        boolean isOp2Selected = checkBox1.isChecked();
        if (isOp2Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox2 = findViewById(R.id.question_2_Op3);
        boolean isOp3Selected = checkBox2.isChecked();
        if (isOp3Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox3 = findViewById(R.id.question_2_Op4);
        boolean isOp4Selected = checkBox3.isChecked();
        if (isOp4Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox4 = findViewById(R.id.question_2_Op5);
        boolean isOp5Selected = checkBox4.isChecked();
        if (isOp5Selected) {
            checkedCount = checkedCount + 1;
        }

        /*Check if count is greater than 2 and validate*/

        if (checkedCount != 2) {
            validateUI("Question 2", true);
            return -1;
        }

        /*if the correct answer is chosen, increment score by 1*/

        if (isOp1Selected && isOp4Selected) {
            scoreQ2 = scoreQ2 + 1;
        }
        return scoreQ2;
    }

    /**
     * Fetches the selected Radio button for question 3
     * Increment the score by 1, if the question is answered correctly
     **/

    public int setQ3Response() {
        int scoreQ3 = 0;
        RadioGroup radioGroup = findViewById(R.id.question_3_Radio);
        int buttonId = radioGroup.getCheckedRadioButtonId();

        /*Check if no answer selected for this question. Call the validate method to return error*/

        if (buttonId == -1) {
            validateUI("question 3", false);
            return buttonId;
        }
        RadioButton radioButton = findViewById(buttonId);
        String selectedOption = (String) radioButton.getText();
        if (selectedOption.equals("No")) {
            scoreQ3 = scoreQ3 + 1;
        }

        return scoreQ3;
    }

    /*
     * Checks the checked state for the check box
     * Increment score by 1 if user selected option 1,3,4 in question 5
     */

    public int setQ5Response() {
        int scoreQ4 = 0;
        int checkedCount = 0;

        /*
         *Check the state of the each of the check box
         * Increment the count of checked boxes by 1 if a box is checked
         */

        CheckBox checkBox = findViewById(R.id.question_5_Op1);
        boolean isOp1Selected = checkBox.isChecked();
        if (isOp1Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox1 = findViewById(R.id.question_5_Op2);
        boolean isOp2Selected = checkBox1.isChecked();
        if (isOp2Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox2 = findViewById(R.id.question_5_Op3);
        boolean isOp3Selected = checkBox2.isChecked();
        if (isOp3Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox3 = findViewById(R.id.question_5_Op4);
        boolean isOp4Selected = checkBox3.isChecked();
        if (isOp4Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox4 = findViewById(R.id.question_5_Op5);
        boolean isOp5Selected = checkBox4.isChecked();
        if (isOp5Selected) {
            checkedCount = checkedCount + 1;
        }
        CheckBox checkBox5 = findViewById(R.id.question_5_Op6);
        boolean isOp6Selected = checkBox5.isChecked();
        if (isOp6Selected) {
            checkedCount = checkedCount + 1;
        }

        /*Check if count is greater than 2 and validate*/

        if (checkedCount != 3) {
            validateUI("Question 5", true);
            return -1;
        }

        if (isOp1Selected && isOp3Selected && isOp4Selected) {
            scoreQ4 = scoreQ4 + 1;
        }

        return scoreQ4;
    }

    /*Validates the UI. Accepts an input parameter of type String and a boolean
     *String parameter is question and boolean is for displaying error for check boxes
     *The appropriate question number is passed to determine where to show the validation
     * Set the appropriate message
     */
    public void validateUI(String question, boolean checkBox) {
        if (!checkBox) {
            Toast toast = Toast.makeText(this, "Please provide an answer to " + question, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Please check number of responses for " + question, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
