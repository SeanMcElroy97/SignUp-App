package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpSuccess extends AppCompatActivity {
    //Sean McElroy C16437464
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_success);

        Intent intento =getIntent();
        //Calculate fee

        //Get intent data
        String email =intento.getStringExtra("email");
        String stringduration = intento.getStringExtra("yearsDuration");

        //Calculate fee
        int durationInt = Integer.parseInt(stringduration);
        float userFee;
        if(durationInt>5){
            userFee= (float)(durationInt*100*.8);
        }else{
            userFee= (float)(durationInt*100);
        }



        //Set values for textView
        TextView emailTextView = findViewById(R.id.emailtextView);
        emailTextView.setText(email);

        TextView memberFeeTextView = findViewById(R.id.memberFeeTextView);
        memberFeeTextView.setText(String.valueOf(userFee));

        Toast.makeText(this, "Sign in Success", Toast.LENGTH_LONG).show();
    }
}
