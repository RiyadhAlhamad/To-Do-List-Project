package com.riyadhdev.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.riyadhdev.todolist.Authentication.NewUser;

public class Register extends AppCompatActivity {


    // EditText
    public EditText edName, edPassword, edEmail;

    // Buttons
    public Button btSignup;

    // ImageButton
    ImageButton btBack;

    // newUser Class
    public NewUser newUser;

    // MakeToast
    MakeToast myToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // EditText
        edName = findViewById(R.id.edTxNameReg);
        edPassword = findViewById(R.id.edTxPassReg);
        edEmail = findViewById(R.id.edTxEmailReg);

        // Buttons
        btSignup = findViewById(R.id.btSignupReg);

        //ImageButton
        btBack = findViewById(R.id.imBtBack);


        // Methods
        // If user click back button
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFinish();
            }
        });

        // New User
        // Create new User and Check if success or not
        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    newUser = new NewUser(getApplicationContext());
                    newUser.signUpNewUser(edEmail.getText().toString() , edPassword.getText().toString());
                    // Her let's chek if success or not


            }
        });


    }


    public void myFinish(){
        finish();
    }
    public void myIntent(){
       Intent myIntent = new Intent(this,Task.class);
       startActivity(myIntent);

    }


}