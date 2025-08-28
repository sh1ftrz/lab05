package com.example.lab3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button submitButton;
    Button back2;
    EditText title,textContent;
    TextView display;

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
        display = findViewById(R.id.textView);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Data from USER
                String stringOfTitle = title.getText().toString();
                String stringOfContent = textContent.getText().toString();
                Date currentDate = new Date();

                //Create data in TextNote class
                TextNote note = new TextNote();
                note.title = stringOfTitle;
                note.setTextContent(stringOfContent);
                note.dateCreated = currentDate;


                display.setText(note.display());
            }
        });

        back2 = findViewById(R.id.Back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentBack = new Intent (AddNoteActivity.this,MainActivity.class);
                startActivity(intentBack);
            }
        });

    }
}