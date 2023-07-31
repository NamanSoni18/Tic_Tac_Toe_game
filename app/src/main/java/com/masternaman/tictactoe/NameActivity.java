package com.masternaman.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    // Creating Variables
    EditText editText1, editText2;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        getSupportActionBar().hide();

        // Widgets Declarations
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        btn1 = findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent
                Intent iNext = new Intent(NameActivity.this, MainActivity.class);

                // Intent Passing Functionalities
                iNext.putExtra("Player1", editText1.getText().toString());
                iNext.putExtra("Player2", editText2.getText().toString());

                // Activity Starting
                startActivity(iNext);
            }
        });
    }
}