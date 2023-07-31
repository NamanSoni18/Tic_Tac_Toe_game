package com.masternaman.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    int flag = 0;
    int count = 0;
    String player1, player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar();

        Intent player = getIntent();

        player1 = player.getStringExtra("Player1");
        player2 = player.getStringExtra("Player2");

        init();

    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void Check(View view) {

        Button btncurrent = (Button) view;
        count++;

        if (btncurrent.getText().toString().equals("")) {

            if (flag == 0) {
                btncurrent.setText("X");
                flag = 1;
            } else {
                btncurrent.setText("O");
                flag = 0;
            }

            if (count > 4) {

                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                // Conditions
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    //1
                    winner(b1);
                    reset();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    //2
                    winner(b4);
                    reset();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    //3
                    winner(b7);
                    reset();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    //4
                    winner(b1);
                    reset();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    //5
                    winner(b2);
                    reset();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    //6
                    winner(b3);
                    reset();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    //7
                    winner(b1);
                    reset();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    //8
                    winner(b3);
                    reset();
                } else if (!b1.equals("") && !b2.equals("") && !b3.equals("") &&
                        !b4.equals("") && !b5.equals("") && !b6.equals("") &&
                        !b7.equals("") && !b8.equals("") && !b9.equals("")) {
                    // Or you can write this condition-9 as count == 9
                    //9
                    Toast.makeText(this, "Game is Drawn", Toast.LENGTH_SHORT).show();
                    reset();
                }

            }

        }


    }

    public void reset() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        count = 0;
    }

    public void winner(String btn) {
        if(btn.equals("X")){
            Toast.makeText(this, "Winner is: " + player1, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Winner is: " + player2, Toast.LENGTH_SHORT).show();
        }
    }
}