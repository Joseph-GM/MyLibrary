package org.joetech.mylibrary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BookRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "1Q84", "Haruki Murakami", 1350,
                "https://images-na.ssl-images-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
                "A work of maddening brilliance", "Logn Descripton"));
        books.add(new Book(2, "The Myth of Sisyphus", "Albert Camus", 250,
                "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9781/5169/9781516923182.jpg",
                "One of the most influential work of the century", "Logn Descripton"));
        adapter.setBooks(books);
    }
}