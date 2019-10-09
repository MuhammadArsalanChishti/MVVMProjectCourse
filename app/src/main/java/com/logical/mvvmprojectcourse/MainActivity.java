package com.logical.mvvmprojectcourse;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.logical.mvvmprojectcourse.databinding.ActivityMainBinding;
import com.logical.mvvmprojectcourse.model.Book;
import com.logical.mvvmprojectcourse.model.Category;
import com.logical.mvvmprojectcourse.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=Aj-sZ2JWnj4

    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers activityClickHandlers;
    private Category selectedCategory;
    private ArrayList<Category>categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityClickHandlers = new MainActivityClickHandlers();

        activityMainBinding.setClickHandlers(activityClickHandlers);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {


                categoriesList = (ArrayList<Category>) categories;
                for(Category c : categories){
                    Log.i("MainActivity",""+c.getCategoryName());
                }

                showOnSpinner();
            }
        });

        mainActivityViewModel.getBooksOfSelectedCaegory(3).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                for(Book b : books){
                    Log.i("MainActivity",""+b.getBookName());
                }
            }
        });
    }

    public class MainActivityClickHandlers{

        public void onFabClicked(View view){
            toastMsg("Fab button clicked",Toast.LENGTH_SHORT);
        }

        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {

            selectedCategory = (Category) parent.getItemAtPosition(pos);

            String message = " id is " + selectedCategory.getId() + "\n name is " + selectedCategory.getCategoryName() + "\n email is " + selectedCategory.getCategoryDescription();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), message, Toast.LENGTH_LONG).show();


        }
    }

    private void showOnSpinner(){

        ArrayAdapter<Category> categoryArrayAdapter=new ArrayAdapter<Category>(this,R.layout.spinner_item,categoriesList);
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);



    }

    private void toastMsg(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    private void toastMsg(String toast,int Length){
        Toast.makeText(this, toast, Length).show();
    }
}
