package com.logical.mvvmprojectcourse.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.logical.mvvmprojectcourse.model.Book;
import com.logical.mvvmprojectcourse.model.Category;
import com.logical.mvvmprojectcourse.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfSelectedCaegory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfSelectedCaegory(int categoryId) {
        booksOfSelectedCaegory = eBookShopRepository.getBooks(categoryId);
        return booksOfSelectedCaegory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }
}
