package com.logical.mvvmprojectcourse.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class EBookShopRepository {

    private CategoryDAO categoryDAO;
    private BookDAO     bookDAO;

    private LiveData<List<Book>> books;
    private LiveData<List<Category>> categories;

    public EBookShopRepository(Application application){
        BooksDatabase booksDatabase = BooksDatabase.getInstance(application);
        categoryDAO                 = booksDatabase.categoryDAO();
        bookDAO                     = booksDatabase.bookDAO();
    }

    public LiveData<List<Book>> getBooks(int categoryId) {
        return bookDAO.getBooks(categoryId);
    }

    public LiveData<List<Category>> getCategories() {
        return categoryDAO.getAllCategory();
    }

    private  void insertCategory(Category category){
        new InsertCategoryAsyncTask(categoryDAO).execute(category);
    }

    private static class InsertCategoryAsyncTask extends AsyncTask<Category,Void,Void>{

        private CategoryDAO categoryDAO;

        public InsertCategoryAsyncTask(CategoryDAO categoryDAO) {
            this.categoryDAO = categoryDAO;
        }

        @Override
        protected Void doInBackground(Category... categories) {

            categoryDAO.insertCategory(categories[0]);
            return null;
        }
    }



    private  void insertBook(Book book){
        new InsertBookAsyncTask(bookDAO).execute(book);
    }

    private static class InsertBookAsyncTask extends AsyncTask<Book,Void,Void>{

        private BookDAO bookDAO;

        public InsertBookAsyncTask(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDAO.insertBook(books[0]);
            return null;
        }
    }
}
