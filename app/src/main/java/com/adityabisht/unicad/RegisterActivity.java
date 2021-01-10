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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner branch;
    private Spinner batch;
    private static final String[] branches = {"Mechanical", "P&I"};
    private static String[] batches;

    FirebaseDatabase rootNode;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText name = findViewById(R.id.editTextTextPersonName);
        final EditText enrol = findViewById(R.id.editTextTextPersonName2);
        final EditText pass = findViewById(R.id.editTextTextPersonName4);
        final EditText repass = findViewById(R.id.editTextTextPersonName5);

        enrol.setTransformationMethod(new NumericKeyBoardTransformationMethod());

        Button back_button = findViewById(R.id.back_button);
        Button register = findViewById(R.id.register);

        branch = findViewById(R.id.branch);
        batch = findViewById(R.id.batch);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(RegisterActivity.this,
                R.layout.spinner_item,branches);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(adapter);
        branch.setOnItemSelectedListener(this);

        batch.setEnabled(false);
        batch.setClickable(false);

        back_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, WelcomeActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameS = name.getText().toString();
                String enrolS = enrol.getText().toString();
                String passS = pass.getText().toString();
                String repassS = repass.getText().toString();
                String branchS = branch.getSelectedItem().toString();
                String batchS = batch.getSelectedItem().toString();

                if(!nameS.matches("") && !enrolS.matches("") && !passS.matches("") && !repassS.matches("")){
                    if(passS.matches(repassS)){
                        if(passS.length() >= 6){
                            //DB stuff

                            rootNode = FirebaseDatabase.getInstance();
                            myRef = rootNode.getReference("users");
                            UserHelperClass helperClass = new UserHelperClass(nameS, enrolS, passS, branchS, batchS, false);
                            myRef.child(enrolS).setValue(helperClass);
                            startActivity(new Intent(RegisterActivity.this, WelcomeActivity.class));


                            Toast.makeText(RegisterActivity.this, "Done!", Toast.LENGTH_SHORT).show();


                        }else{
                            Toast.makeText(RegisterActivity.this, "Password should be greater than 6 characters", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password mismatch", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Please complete the form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                batch.setEnabled(true);
                batch.setClickable(true);
                batches = new String[]{"Q1", "Q2", "Q3", "Q4", "Q5", "Q6"};
                ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(RegisterActivity.this,
                        R.layout.spinner_item,batches);

                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                batch.setAdapter(adapter1);
                break;
            case 1:
                batch.setEnabled(true);
                batch.setClickable(true);
                batches = new String[]{"Q7", "Q8"};
                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(RegisterActivity.this,
                        R.layout.spinner_item,batches);

                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                batch.setAdapter(adapter2);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Auto-generated method stub
    }
}