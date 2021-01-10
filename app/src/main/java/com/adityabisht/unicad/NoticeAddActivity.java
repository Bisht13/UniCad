package com.adityabisht.unicad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoticeAddActivity extends AppCompatActivity {

    /*FirebaseDatabase rootNode;
    DatabaseReference myRef;*/
    static int cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_add);

        Button back_button = findViewById(R.id.back_btn_notice_add);
        final EditText et = findViewById(R.id.add_notice_text);

        Button post_button = findViewById(R.id.tick_addnotice);
        ImageView tick_button = findViewById(R.id.imageView2);

        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String post = et.getText().toString();

                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("notices");

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String n = snapshot.child("current_notice").getValue(String.class);
                        cn =Integer.parseInt(n);

                        /*rootNode = FirebaseDatabase.getInstance();
                        myRef = rootNode.getReference("notices");*/
                        /*reference.child("current_notice").setValue(String.valueOf(ab +1));
                        reference.child(String.valueOf(ab+1)).setValue(post);
                        Toast.makeText(NoticeAddActivity.this, "Done!", Toast.LENGTH_SHORT).show();*/

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                reference.child("current_notice").setValue(String.valueOf(cn +1));
                reference.child(String.valueOf(cn+1)).setValue(post);
                Toast.makeText(NoticeAddActivity.this, "Done!", Toast.LENGTH_SHORT).show();
                finish();

                /*rootNode = FirebaseDatabase.getInstance();
                myRef = rootNode.getReference("notices");
                //myRef.child("current_notice").setValue(String.valueOf(m[0] +1));
                myRef.child(String.valueOf(2)).setValue(post);
                Toast.makeText(NoticeAddActivity.this, "Done!", Toast.LENGTH_SHORT).show();*/
                //finish();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }
}