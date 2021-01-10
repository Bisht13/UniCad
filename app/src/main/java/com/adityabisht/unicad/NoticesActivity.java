package com.adityabisht.unicad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NoticesActivity extends AppCompatActivity {
    final String[] xx = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);



        Button addB = findViewById(R.id.pencil);
        ImageView addIV = findViewById(R.id.imageView10);
        Button back_but = findViewById(R.id.back_btn_notice_activity);

        back_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoticesActivity.this, MainActivity.class));
                finish();
            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoticesActivity.this, NoticeAddActivity.class));
            }
        });

        addIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NoticesActivity.this, NoticeAddActivity.class));
            }
        });


        final Context actContext = this;

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("notices");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String n = snapshot.child("current_notice").getValue(String.class);

                final int textViewCount = Integer.parseInt(n);

                final ScrollView scroller = (ScrollView) findViewById(R.id.scrollView1); // Find Scrollview
                scroller.removeAllViews();// Kill Scrollview's child from last time this ran (and I hope its children?)
                final LinearLayout scrollvert = new LinearLayout(actContext); // Make a new linear layout
                scrollvert.setOrientation(LinearLayout.VERTICAL);// Make it a vertical layout
                scroller.addView(scrollvert); // add this layout to Scrollview (scroller)
                final TextView[] tv =new TextView[textViewCount+1]; // Going to add some text views

                for (int i = 0; i<=textViewCount; i++) {     //use this line to remove exception of indexoutofbound
                    tv[i] = new TextView(actContext);
                    String x = snapshot.child(String.valueOf(i)).getValue(String.class);
                    tv[i].setText(x + "\n");
                    tv[i].setTextColor(Color.parseColor("#ffffff"));
                    scrollvert.addView(tv[i]);
                }

                /*DatabaseReference ref = FirebaseDatabase.getInstance().getReference("notices");
                ref.addValueEventListener(new ValueEventListener(){
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(int i = 0; i<=textViewCount; i++) {
                            String x = snapshot.child(String.valueOf(i)).getValue(String.class);
                            tv[i].setText(x + "\n");
                            tv[i].setTextColor(Color.parseColor("#ffffff"));
                            scrollvert.addView(tv[i]);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });*/

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Log.d("abcd", "onDataChange1: "+ );
        /*final int textViewCount = 3;

        final ScrollView scroller = (ScrollView) findViewById(R.id.scrollView1); // Find Scrollview
        scroller.removeAllViews();// Kill Scrollview's child from last time this ran (and I hope its children?)
        final LinearLayout scrollvert = new LinearLayout(this); // Make a new linear layout
        scrollvert.setOrientation(LinearLayout.VERTICAL);// Make it a vertical layout
        scroller.addView(scrollvert); // add this layout to Scrollview (scroller)
        final TextView[] tv =new TextView[textViewCount+1]; // Going to add some text views

        for (int i = 0; i<=textViewCount; i++) {     //use this line to remove exception of indexoutofbound
            tv[i] = new TextView(this);
            //tv[i].setText(textLog);
            //scrollvert.addView(tv[i]);  //make this change. Adding to linear layout which is only one child of scrollview.
        }



            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(int i = 0; i<=textViewCount; i++) {
                        String x = snapshot.child(String.valueOf(i)).getValue(String.class);
                        tv[i].setText(x + "\n");
                        tv[i].setTextColor(Color.parseColor("#ffffff"));
                        scrollvert.addView(tv[i]);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });*/
    }
}