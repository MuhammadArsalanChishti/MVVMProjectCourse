package com.logical.mvvmprojectcourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD

public class MainActivity extends AppCompatActivity {

=======
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //MVVM OfficeBranch
>>>>>>> d74edb99da02df36384c8a9e3fd4efc51c22ba81
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
<<<<<<< HEAD
=======

    private void toastMsg(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
>>>>>>> d74edb99da02df36384c8a9e3fd4efc51c22ba81
}
