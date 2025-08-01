package com.example.lab3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public static void main(String[] args) {

        //User
        User John1 = new User();
        User John2 = new User();

        //John1
        John1.userName = "BigJohn";
        John1.gender = "Male";
        John1.age = 30;
        John1.email = "xX_BigJohn69_Xx";
        John1.password = "J0hn";

        John1.checkEmail();
        John1.checkPassword();

        //John2
        John2.userName = "LilJohn";
        John2.gender = "Male";
        John2.age = 25;
        John2.email = "xX_LilJohn420_Xx";
        John2.password = "J000hn";

        John2.checkEmail();
        John2.checkPassword();

        //Note
        TextNote note1 = new TextNote();
        TextNote note2 = new TextNote();

        //note1
        note1.title = "diary4";
        note1.textContent = "none";
        note1.dateCreated = "25/07/2013";

        note1.display();

        //note2
        note2.title = "To do Checklists";
        note2.textContent = "checklists";
        note2.dateCreated = "06/09/2015";

        note2.display();
    }
}