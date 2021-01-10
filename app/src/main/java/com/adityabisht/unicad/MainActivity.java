package com.adityabisht.unicad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView noticeIV = findViewById(R.id.imageView9);
        Button noticeB = findViewById(R.id.button5);
        ImageView calendarIV = findViewById(R.id.imageView5);
        Button calendarB = findViewById(R.id.calendar);
        ImageView timetableIV = findViewById(R.id.imageView6);
        Button timetableB = findViewById(R.id.TimeTable);
        ImageView CGPIV = findViewById(R.id.imageView7);
        Button CGPB = findViewById(R.id.CG_Predicator);
        ImageView assignmentsIV = findViewById(R.id.imageView8);
        Button assignmentsB = findViewById(R.id.assignments);
        ImageView resourcesIV = findViewById(R.id.imageView4);
        Button resourcesB = findViewById(R.id.resources);

        noticeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoticesActivity.class));
            }
        });

        noticeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoticesActivity.class));
            }
        });

        calendarIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CalenderActivity.class));
            }
        });

        calendarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CalenderActivity.class));
            }
        });

        timetableIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimeTableActivity.class));
            }
        });

        timetableB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TimeTableActivity.class));
            }
        });

        CGPIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CGCalculatorActivity.class));
            }
        });

        CGPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CGCalculatorActivity.class));
            }
        });

        assignmentsIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssignmentsActivity.class));
            }
        });

        assignmentsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssignmentsActivity.class));
            }
        });

        resourcesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ResourcesActivity.class));
            }
        });

        resourcesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ResourcesActivity.class));
            }
        });
    }
}