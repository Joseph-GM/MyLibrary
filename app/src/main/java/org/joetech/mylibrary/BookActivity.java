package org.joetech.mylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWantToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDescription = "A young woman named Aomame follows a taxi driver's enigmatic suggestion and begins to notice" +
//                "\n"+
//                "As Aomane's and Tengos' narratives coverge over the cource of the single year, we learn of the profound"+
//                "\n" +
//                "A love story, a mystery, a fantasy, a movel of self-discovery, a dystopia to rival George Orwell's";
//
//        Book book = new Book(1, "1Q84", "Haruki Murakami", 1350,
//                "https://images-na.ssl-images-amazon.com/images/I/41FdmYnaNuL._SX322_BO1,204,203,200_.jpg",
//                "A work of maddening brilliance", longDescription);

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);
                }
            }
        }
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImgageUrl())
                .into(bookImage);
    }

    private void initViews() {
        txtAuthor = findViewById(R.id.txtAuthor2);
        txtBookName = findViewById(R.id.txtBookName2);
        txtPages = findViewById(R.id.txtPage);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavoriteList);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToReadList);

        bookImage = findViewById(R.id.imgBook2);

    }
}