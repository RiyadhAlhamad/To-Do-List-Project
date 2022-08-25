package com.riyadhdev.todolist;

import android.content.Context;
import android.widget.Toast;

public class MakeToast {

    public Context context;
    public String message;


    public MakeToast(Context context, String textMess){

        this.context = context;
        this.message = textMess;
    }

    public void showMessage(){
        Toast.makeText(getContext(),getMessage(),Toast.LENGTH_LONG).show();
    }


    public Context getContext() {
        return context;
    }

    public String getMessage() {
        return message;
    }

}
