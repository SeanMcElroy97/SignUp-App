package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Sean McElroy C16437464
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SignUp(View v){

        //Get email as Text
        EditText emailTextView = findViewById(R.id.emailEditText);
        String email=emailTextView.getText().toString();



        //Get password + confirm password
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        String password = passwordEditText.getText().toString();

        EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        String confirmPassword = confirmPasswordEditText.getText().toString();


        //Get value duration
        EditText DurationEdit = findViewById(R.id.DurationEditText);
        String stringduration = DurationEdit.getText().toString();


        //Variables that call the validation methods
        boolean validEmail = ValidateEmail(email);
        boolean validPassword = ValidatePasswords(password, confirmPassword);
        boolean validDuration = ValidateYears(stringduration);



        //If everything is ok send to second Activity
        if(validEmail==true && validPassword==true && validDuration==true) {
            //Everything good
            Intent intento = new Intent(this, SignUpSuccess.class);
            //pass values
            intento.putExtra("email", email);
            intento.putExtra("yearsDuration", stringduration);
            //Start Activity
            startActivity(intento);
        }
    }

    public boolean ValidateEmail(String email){
        if(email.contains("@") && !email.startsWith("@") && !email.endsWith("@") && !email.contains(" ") ){
            return true;
        }else {
            Toast.makeText(this, "Incorrect Email", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public boolean ValidatePasswords(String password1, String password2) {
        if(password1.length()>=6 && password1.equals(password2) ) {
            return true;
        }else {
            if(password1.length()<6) {
                Toast.makeText(this, "Password not long enough", Toast.LENGTH_LONG).show();
            }
            if(!password1.equals(password2)){
                Toast.makeText(this, "Password must match", Toast.LENGTH_LONG).show();
            }
            return false;
        }

    }

    public boolean ValidateYears(String numofYearsStr){
        if( numofYearsStr.isEmpty()){
            return false;
        }
        if(Integer.parseInt(numofYearsStr)<=0){
            Toast.makeText(this, "Invalid number of year", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

}
