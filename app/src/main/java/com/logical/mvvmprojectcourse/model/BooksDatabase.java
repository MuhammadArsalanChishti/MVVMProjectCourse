package com.logical.mvvmprojectcourse.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Category.class, Book.class}, version = 1, exportSchema = true)
public abstract class BooksDatabase extends RoomDatabase {

    public abstract CategoryDAO categoryDAO();

    public abstract BookDAO bookDAO();


    private static BooksDatabase instance;

    public static synchronized BooksDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), BooksDatabase.class,
                    "book_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitilDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };


    private static class InitilDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private CategoryDAO categoryDAO;
        private BookDAO bookDAO;


        public InitilDataAsyncTask(BooksDatabase booksDatabase) {

            categoryDAO = booksDatabase.categoryDAO();
            bookDAO = booksDatabase.bookDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private void addTempData() {
        Category category1 = new Category();
        category1.setCategoryName("Text Book");
        category1.setCategoryDescription("Text Book Description");

        Category category2 = new Category();
        category2.setCategoryName("Novels Book");
        category2.setCategoryDescription("Novels Description");

        Category category3 = new Category();
        category3.setCategoryName("Other Book");
        category3.setCategoryDescription("Other Description");


        categoryDAO().insertCategory(category1);
        categoryDAO().insertCategory(category2);
        categoryDAO().insertCategory(category3);

        Book book1 = new Book();
        book1.setBookName("High School Java");
        book1.setUnitPrice("$150");
        book1.setCategoryId(1);

        Book book2 = new Book();
        book2.setBookName("Mathematics for beginners");
        book2.setUnitPrice("$200");
        book2.setCategoryId(1);

        Book book3 = new Book();
        book3.setBookName("Object Oriented Android App");
        book3.setUnitPrice("$150");
        book3.setCategoryId(1);

        Book book4 = new Book();
        book4.setBookName("Astrology for beginners");
        book4.setUnitPrice("$190");
        book4.setCategoryId(1);

        Book book5 = new Book();
        book5.setBookName("High School Magic Tricks");
        book5.setUnitPrice("$100");
        book5.setCategoryId(1);

        Book book6 = new Book();
        book6.setBookName("Chemistry forsecondary School Students");
        book6.setUnitPrice("$250");
        book6.setCategoryId(1);

        Book book7 = new Book();
        book7.setBookName("A game of Cats");
        book7.setUnitPrice("19.99");
        book7.setCategoryId(2);

        Book book8 = new Book();
        book8.setBookName("The Hound of the New York");
        book8.setUnitPrice("16.99");
        book8.setCategoryId(2);

        Book book9 = new Book();
        book9.setBookName("Advanture of Joe Finn");
        book9.setUnitPrice("$13");
        book9.setCategoryId(2);

        Book book10 = new Book();
        book10.setBookName("Arc of witches");
        book10.setUnitPrice("$19.99");
        book10.setCategoryId(2);

        Book book11 = new Book();
        book11.setBookName("Can I run");
        book11.setUnitPrice("$16.99");
        book11.setCategoryId(2);

        Book book12 = new Book();
        book12.setBookName("Story of Jokers");
        book12.setUnitPrice("$13");
        book12.setCategoryId(2);


        Book book13 = new Book();
        book13.setBookName("Notes of a alien life cycle researcher");
        book13.setUnitPrice("$1250");
        book13.setCategoryId(3);

        Book book14 = new Book();
        book14.setBookName("Top 9 myths about UFOs");
        book14.setUnitPrice("$789");
        book14.setCategoryId(3);

        Book book15 = new Book();
        book15.setBookName("How to become a millionaire in 24 hours");
        book15.setUnitPrice("$1250");
        book15.setCategoryId(3);

        Book book16 = new Book();
        book16.setBookName("1 Hour work month");
        book16.setUnitPrice("$199");
        book16.setCategoryId(3);

        bookDAO().insertBook(book1);
        bookDAO().insertBook(book2);
        bookDAO().insertBook(book3);
        bookDAO().insertBook(book4);
        bookDAO().insertBook(book5);
        bookDAO().insertBook(book6);
        bookDAO().insertBook(book7);
        bookDAO().insertBook(book8);
        bookDAO().insertBook(book9);
        bookDAO().insertBook(book10);
        bookDAO().insertBook(book12);
        bookDAO().insertBook(book13);
        bookDAO().insertBook(book14);
        bookDAO().insertBook(book15);
        bookDAO().insertBook(book16);
    }
}
