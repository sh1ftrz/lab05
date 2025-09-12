package com.example.lab3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import java.util.concurrent.Executors;

public class AddNoteActivity extends AppCompatActivity {

    Button submitButton;
    Button back2;
    EditText title,textContent,userTXT;
    TextView displayTime;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitButton = findViewById(R.id.SubmitButton);
        title = findViewById(R.id.editTextTitle);
        textContent = findViewById(R.id.editTextContent);
        userTXT = findViewById(R.id.editTextUser);
        displayTime = findViewById(R.id.TimeDisplayText);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Data from USER
                String stringOfTitle = title.getText().toString();
                String stringOfContent = textContent.getText().toString();
                String userName = userTXT.getText().toString();
                Date currentDate = new Date();


                //Create data in TextNote class
                TextNote note = new TextNote();
                note.title = stringOfTitle;
                note.setTextContent(stringOfContent);

                note.dateCreated = currentDate;

                TextUser user1 = new TextUser();
                note.setOwner(user1);

                displayTime.setText(note.display());

                NoteEntity entity = NoteMapper.toEntity(note);

                Context context = v.getContext();
                Executors.newSingleThreadExecutor().execute(() -> {
                    AppDatabase.getInstance(context).noteDao().insert(entity);
                });
            }
        });



        back2 = findViewById(R.id.BackHomeAddNote);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentBack = new Intent (AddNoteActivity.this,MainActivity.class);
                startActivity(intentBack);
            }
        });




    }
}