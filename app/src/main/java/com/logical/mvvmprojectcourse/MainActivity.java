package com.logical.mvvmprojectcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    //MVVM HomeBranch
    //https://www.youtube.com/watch?v=Aj-sZ2JWnj4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void toastMsg(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    private void toastMsg(String toast,int Length){
        Toast.makeText(this, toast, Length).show();
    }
}
