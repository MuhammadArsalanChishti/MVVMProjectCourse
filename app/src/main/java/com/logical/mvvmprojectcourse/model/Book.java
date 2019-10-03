package com.logical.mvvmprojectcourse.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.logical.mvvmprojectcourse.BR;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "books_table",foreignKeys =
@ForeignKey(entity = Category.class,parentColumns = "category_id",childColumns = "book_id",onDelete = CASCADE))
public class Book extends BaseObservable {

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "book_id")
    private int bookId;

    @ColumnInfo (name = "category_id")
    private int categoryId;

    @ColumnInfo (name = "book_name")
    private String bookName;

    @ColumnInfo (name = "unit_price")
    private String unitPrice;

    @Ignore
    public Book() {
    }

    public Book(int bookId, int categoryId, String bookName, String unitPrice) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.unitPrice = unitPrice;
    }

    //SETTERS

    public void setBookId(int bookId) {
        this.bookId = bookId;
        notifyPropertyChanged(BR.bookId);
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        notifyPropertyChanged(BR.bookName);
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
        notifyPropertyChanged(BR.unitPrice);
    }

    //GETTERS

    @Bindable
    public int getBookId() {
        return bookId;
    }

    @Bindable
    public int getCategoryId() {
        return categoryId;
    }

    @Bindable
    public String getBookName() {
        return bookName;
    }

    @Bindable
    public String getUnitPrice() {
        return unitPrice;
    }
}
