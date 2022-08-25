package com.riyadhdev.todolist.Authentication;


import android.content.Context;
import android.content.Intent;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.riyadhdev.todolist.MakeToast;



public class NewUser extends AppCompatActivity {

    // FirebaseAuth
    FirebaseAuth mAuth;
    // Context
    Context context;
    // class Toast
    MakeToast myToast;
    // Var

    public NewUser(Context context){
        this.context = context;
    }

    public void signUpNewUser(String email, String password){
        myToast = new MakeToast(context, "signUp methods");
        myToast.showMessage();

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(context, "success new user",Toast.LENGTH_LONG).show();
                String user = mAuth.getCurrentUser().getEmail();
            }else
                Toast.makeText(context, "not success create new user",Toast.LENGTH_LONG).show();
        });

    }

}
