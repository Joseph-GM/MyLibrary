package org.joetech.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }

        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }

        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data
        allBooks.add(new Book(1, "1Q84", "Haruki Murakami", 1350,
                "https://images-na.ssl-images-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
                "A work of maddening brilliance", "Logn Descripton"));
        allBooks.add(new Book(2, "The Myth of Sisyphus", "Albert Camus", 250,
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/5169/9781516923182.jpg",
                "One of the most influential work of the century", "Logn Descripton"));
    }

    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }
}
