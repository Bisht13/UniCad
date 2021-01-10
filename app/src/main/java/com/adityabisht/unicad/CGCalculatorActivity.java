package com.adityabisht.unicad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CGCalculatorActivity extends AppCompatActivity {

    private static final String[] examtypes = {"CWS", "ETE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_g_calculator);

        Button back_button = findViewById(R.id.back_btn_CG_predictor);
        final Button cgpaB = findViewById(R.id.cgpa);
        final EditText avg_score = findViewById(R.id.avg_score);
        final EditText your_score = findViewById(R.id.score);
        final EditText max_score = findViewById(R.id.max_score);

        final Spinner examtype = findViewById(R.id.cws_ete_ratio);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CGCalculatorActivity.this,
                R.layout.spinner_item,examtypes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        examtype.setAdapter(adapter);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CGCalculatorActivity.this, MainActivity.class));
                finish();
            }
        });

        cgpaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = examtype.getSelectedItem().toString();
                double avgscore = Integer.parseInt(avg_score.getText().toString());
                double yourscore = Integer.parseInt(your_score.getText().toString());
                double maxscore = Integer.parseInt(max_score.getText().toString());


                double avgper = (avgscore/maxscore)*100;
                double yourper = (yourscore/maxscore)*100;

                int cgpa = 7;

                double diffper = yourper - avgper;
                if(diffper>20){
                    cgpa = 10;
                }else if(diffper>15){
                    cgpa = 9;
                }else if(diffper>10){
                    cgpa = 8;
                }else if (diffper<-10){
                    cgpa = 6;
                }else if(diffper<-15){
                    cgpa = 5;
                }else if(diffper<-20){
                    cgpa = 4;
                }else if(diffper<-25){
                    cgpa = 3;
                }else if(diffper<-30){
                    cgpa = 2;
                }else if(diffper<-35){
                    cgpa = 1;
                }else if(diffper<-40){
                    cgpa = 0;
                }
                cgpaB.setText(String.valueOf(cgpa));

            }
        });
    }
}