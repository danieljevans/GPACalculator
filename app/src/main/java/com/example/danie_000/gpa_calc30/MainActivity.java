package com.example.danie_000.gpa_calc30;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private Spinner gradeValue_1, gradeValue_2, gradeValue_3, gradeValue_4, gradeValue_5;
    private Spinner creditValue_1, creditValue_2,creditValue_3, creditValue_4, creditValue_5;
    private String gradeString_1, gradeString_2, gradeString_3, gradeString_4, gradeString_5;
    private String creditString_1, creditString_2, creditString_3, creditString_4, creditString_5;
    private double unweighted_gpa, gpa;

    DecimalFormat fmt = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView gpa_result = (TextView) findViewById(R.id.gpa_view);

        //declare spinners for grades
        gradeValue_1 = (Spinner) findViewById(R.id.grade_1);
        gradeValue_2 = (Spinner) findViewById(R.id.grade_2);
        gradeValue_3 = (Spinner) findViewById(R.id.grade_3);
        gradeValue_4 = (Spinner) findViewById(R.id.grade_4);
        gradeValue_5 = (Spinner) findViewById(R.id.grade_5);
        //adapter create grades
        ArrayAdapter<CharSequence> grade_adapter = ArrayAdapter.createFromResource(this,
                R.array.grade_arrays, android.R.layout.simple_spinner_item);
        //layout when list appears
        grade_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set adapters for grade spinner
        gradeValue_1.setAdapter(grade_adapter);
        gradeValue_2.setAdapter(grade_adapter);
        gradeValue_3.setAdapter(grade_adapter);
        gradeValue_4.setAdapter(grade_adapter);
        gradeValue_5.setAdapter(grade_adapter);


        //declare spinners for credits
        creditValue_1 = (Spinner) findViewById(R.id.credit_1);
        creditValue_2 = (Spinner) findViewById(R.id.credit_2);
        creditValue_3 = (Spinner) findViewById(R.id.credit_3);
        creditValue_4 = (Spinner) findViewById(R.id.credit_4);
        creditValue_5 = (Spinner) findViewById(R.id.credit_5);
        //adapter create credits
        ArrayAdapter<CharSequence> credit_adapter = ArrayAdapter.createFromResource(this,
                R.array.credit_arrays, android.R.layout.simple_spinner_item);
        //layout when list appears
        credit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set adapter for credit spinners
        creditValue_1.setAdapter(credit_adapter);
        creditValue_2.setAdapter(credit_adapter);
        creditValue_3.setAdapter(credit_adapter);
        creditValue_4.setAdapter(credit_adapter);
        creditValue_5.setAdapter(credit_adapter);




        Button go = (Button) findViewById(R.id.submit);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //math to calculate grade and store value into edit text view

                String[] grades = {gradeString_1, gradeString_2, gradeString_3, gradeString_4, gradeString_5};
                double[] grade_values = new double[grades.length];

                for(int i = 0; i < grades.length; i++){
                    if(grades[i].equals("A+")) {
                        grade_values[i] = 4.33;
                    }
                    if(grades[i].equals("A")) {
                        grade_values[i] = 4.0;
                    }
                    if(grades[i].equals("A-")) {
                        grade_values[i] = 3.67;
                    }
                    if(grades[i].equals("B+")) {
                        grade_values[i] = 3.33;
                    }
                    if(grades[i].equals("B")) {
                        grade_values[i] = 3.0;
                    }
                    if(grades[i].equals("B-")) {
                        grade_values[i] = 2.67;
                    }
                    if(grades[i].equals("C+")) {
                        grade_values[i] = 2.33;
                    }
                    if(grades[i].equals("C")) {
                        grade_values[i] = 2.0;
                    }
                    if(grades[i].equals("D")) {
                        grade_values[i] = 1.0;
                    }
                    if(grades[i].equals("E")) {
                        grade_values[i] = 0;
                    }
                }


                double[] credits = {Double.parseDouble(creditString_1), Double.parseDouble(creditString_2),
                        Double.parseDouble(creditString_3), Double.parseDouble(creditString_4), Double.parseDouble(creditString_5)};

                for(int i = 0; i<grades.length; i++){
                    unweighted_gpa += grade_values[i]*credits[i];
                }

                //declare variable to divide by
                double num_credits = 0;

                for(int i = 0; i < grades.length; i++){
                    if(credits[i] != 0){
                        num_credits += credits[i];
                    }
                }

                System.out.println(unweighted_gpa);
                System.out.println(num_credits);

                gpa = unweighted_gpa/num_credits;
                System.out.println(gpa);

                //String answer = "" + gpa;
                String answer = fmt.format(gpa);

                gpa_result.setText(answer);

                gpa = 0;
                unweighted_gpa = 0;
                num_credits = 0;



            }
        });


        gradeValue_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                gradeString_1 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        gradeValue_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                gradeString_2 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        gradeValue_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                gradeString_3 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        gradeValue_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                gradeString_4 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        gradeValue_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                gradeString_5 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });


        creditValue_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                creditString_1 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        creditValue_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                creditString_2 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        creditValue_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                creditString_3 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        creditValue_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                creditString_4 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
        creditValue_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.parseColor("#BF360C"));
                ((TextView) parent.getChildAt(0)).setTextSize(30);
                creditString_5 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });


    }



}
