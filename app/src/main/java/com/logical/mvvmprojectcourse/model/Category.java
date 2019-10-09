package com.logical.mvvmprojectcourse.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import com.logical.mvvmprojectcourse.BR;

@Entity(tableName = "categories_table")
public class Category extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "category_id")
    private int id;

    @ColumnInfo(name = "category_name")
    private String categoryName;

    @ColumnInfo(name = "category_description")
    private String categoryDescription;


    @Ignore
    public Category() {
    }

    public Category(int id, String categoryName, String categoryDescription) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(com.logical.mvvmprojectcourse.BR.id);
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(com.logical.mvvmprojectcourse.BR.categoryName);
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
        notifyPropertyChanged(com.logical.mvvmprojectcourse.BR.categoryDescription);
    }

    @Bindable
    public int getId() {
        return id;
    }

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    @Bindable
    public String getCategoryDescription() {
        return categoryDescription;
    }

    @Override
    public String toString() {
        return this.categoryName;
    }
}
