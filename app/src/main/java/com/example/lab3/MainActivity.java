package com.example.lab3;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button displayNoteButton;
    Button aboutMeButton;
    ImageView MainLogo;
    ProgressBar FrontPageBar1;
    Button NoteEditStart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        MainLogo = findViewById(R.id.imageView);
        MainLogo.setImageResource(R.drawable.creature);

        aboutMeButton = findViewById(R.id.AboutMe);
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        NoteEditStart = findViewById(R.id.NoteStart);
        NoteEditStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent addNote = new Intent (MainActivity.this,AddNoteActivity.class);
                startActivity(addNote);
            }
        });

        FrontPageBar1 = findViewById(R.id.progressBarMainPage);
        FrontPageBar1.setVisibility(View.GONE);
        displayNoteButton = findViewById(R.id.displayNoteBtn);
        displayNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FrontPageBar1.setVisibility(View.VISIBLE);
                new Thread(() -> {
                    //delay 2 sec
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //load data from database
                    // -
                    //back to main thread
                    runOnUiThread(() -> {
                    //remove progressbar
                        FrontPageBar1.setVisibility(View.GONE);
                    //go to DisplayNoteAct
                        Intent displayNoteAct = new Intent(getApplicationContext(),DisplayNoteActivity.class);
                        startActivity(displayNoteAct);
                    });
                }).start();

            }
        });

    }
}