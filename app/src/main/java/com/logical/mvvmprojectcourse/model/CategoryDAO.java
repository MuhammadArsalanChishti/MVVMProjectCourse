package com.logical.mvvmprojectcourse.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    void insertCategory(Category category);

    @Update
    void updateCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Query("SELECT * FROM categories_table WHERE category_id=:categoryId")
    LiveData<List<Category>> getAllCategory(int categoryId);

    @Query("SELECT * FROM categories_table")
    LiveData<List<Category>> getAllCategory();
}
