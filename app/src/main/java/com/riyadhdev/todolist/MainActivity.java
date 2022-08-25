package com.riyadhdev.todolist;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //FirebaseAuth
    public FirebaseAuth myAuth;

    // EditText
    public EditText EmailLog , PasswordLog;
    //Button
    public Button SignIn;
    //TextView
    public TextView CreateAccount;
    // Intent
    public Intent myIntent;
    // Toast
    public MakeToast myToast;

    @Override
    public void onStart() {
        super.onStart();

       FirebaseUser currentUser = myAuth.getCurrentUser();
       CheckUserIsSignIn(currentUser); // here we check user is sign in or not from firebase
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FirebaseAuth initializing
        myAuth = FirebaseAuth.getInstance();
        // Edit text
        EmailLog = findViewById(R.id.edTxEmailLogin);
        PasswordLog = findViewById(R.id.edTxPassLogin);
        // Button
        SignIn = findViewById(R.id.btLogin);
        // If user click Login after fill all edit text email and password
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EmailLog.getText().toString().isEmpty() ){
                    myToast = new MakeToast(getApplicationContext(), "Write Your Email please");
                    myToast.showMessage();
                }else if(PasswordLog.getText().toString().isEmpty()){
                    myToast = new MakeToast(getApplicationContext(), "Write Your Password Please");
                    myToast.showMessage();
                }else{
                    myAuth.signInWithEmailAndPassword(EmailLog.getText().toString(),PasswordLog.getText().toString()).addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            ChangeActivityToTask();
                        }else if(task.getException().getMessage().equals("The email address is badly formatted.")){
                            myToast = new MakeToast(getApplicationContext(), "The email address is badly formatted.");
                            myToast.showMessage();
                        }else if(task.getException().getMessage().equals("There is no user record corresponding to this identifier. The user may have been deleted."))
                        {
                            myToast = new MakeToast(getApplicationContext(), "There is no user record corresponding to this identifier.");
                            myToast.showMessage();
                        }else if(task.getException().getMessage().equals("The password is invalid or the user does not have a password.")){
                            myToast = new MakeToast(getApplicationContext(), "The password is invalid or the user does not have a password.");
                            myToast.showMessage();
                        }
                            });

                }
            }
        });

        // TextView
        CreateAccount = findViewById(R.id.txViewCreatLogin);
        // If user click Create account
        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivityToRegister();
            }
        });

    }

    /* After user sign in first time this method can automatic
    Sign in and change activity to Task activity (this method not complete)
    */
    private void CheckUserIsSignIn (FirebaseUser user){
        if ( user != null) {
           /* myToast = new MakeToast(getApplicationContext(), user.getEmail() + " User is SignIn");
            myToast.showMessage();
            ChangeActivityToTask();
            */
        }else {
            myToast = new MakeToast(getApplicationContext(), "Is not Signin");
            myToast.showMessage();
        }
    }

    public void ChangeActivityToTask (){
        myIntent = new Intent(this,Task.class);
        startActivity(myIntent);
    }

    public void ChangeActivityToRegister (){
        myIntent = new Intent(this,Register.class);
        startActivity(myIntent);
    }


}