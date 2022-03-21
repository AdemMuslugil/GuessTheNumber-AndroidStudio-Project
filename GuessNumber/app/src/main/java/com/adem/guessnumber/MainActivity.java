package com.adem.guessnumber;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Random random=new Random();
    Button guess;
    EditText number;
    TextView resultText;
    ImageView imageView;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess= findViewById(R.id.button);   //to determine button
        number=findViewById(R.id.textNumber);   //to determine number textview
        resultText=findViewById(R.id.resultText);   //to determine result textview
        imageView=findViewById(R.id.imageView); //to determine imageView
        x=random.nextInt(1000);    //assigning a random number to x (max 1000)
        System.out.println(x);

    }


    public void guess(View view){

        try {

            //we get prediction from textNumber
            int guess = Integer.parseInt(number.getText().toString());


            if (guess < x) {    //If the estimate is less than x
                imageView.setImageResource(R.drawable.up);
                imageView.setVisibility(view.VISIBLE);
                resultText.setText("UP");
                number.setText("");

            } else if (guess > x) {     //If the estimate is greater than x
                imageView.setImageResource(R.drawable.down);
                imageView.setVisibility(view.VISIBLE);
                resultText.setText("DOWN");
                number.setText("");

            } else if (guess == x) {    //If the guess is correct
                imageView.setImageResource(R.drawable.prize);
                imageView.setVisibility(view.VISIBLE);
                resultText.setText("WİN");

            }
        }catch (Exception exception){   //if there is a wrong entry
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Incorrect Entry");
            builder.show();
        }
        }

    }


