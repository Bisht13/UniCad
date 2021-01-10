package com.adityabisht.unicad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button back_button = findViewById(R.id.back_button);
        Button login = findViewById(R.id.login);
        final EditText enroll = findViewById(R.id.enroll);
        final EditText pass = findViewById(R.id.pass);
        TextView help = findViewById(R.id.textView2);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            }
        });

        SpannableString ss = new SpannableString("Not a member? Register");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 14, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        TextView textView = (TextView) findViewById(R.id.registerL);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String enrollS = enroll.getText().toString();
                final String passS = pass.getText().toString();

                if(!enrollS.matches("") && !passS.matches("")){
                    // DB stuff
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                    Query checkUser = reference.orderByChild("enrol").equalTo(enrollS);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.exists()){

                                enroll.setError(null);
                                //enroll.setErrorEnabled(false);


                                String passwordFromDB = snapshot.child(enrollS).child("pass").getValue(String.class);

                                if(passwordFromDB.equals(passS)){
                                    String nameFromDB = snapshot.child(enrollS).child("name").getValue(String.class);
                                    String enrollFromDB = snapshot.child(enrollS).child("enrol").getValue(String.class);
                                    String branchFromDB = snapshot.child(enrollS).child("branch").getValue(String.class);
                                    String batchFromDB = snapshot.child(enrollS).child("batch").getValue(String.class);
                                    Boolean repFromDB = snapshot.child(enrollS).child("rep").getValue(Boolean.class);

                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                                    startActivity(intent);
                                }
                                else{
                                    pass.setError("Wrong Password!");
                                    pass.requestFocus();
                                }
                            }
                            else{
                                enroll.setError("Username doesn't exist!");
                                enroll.requestFocus();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }else {
                    Toast.makeText(LoginActivity.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, HelpActivity.class));
            }
        });
    }
}