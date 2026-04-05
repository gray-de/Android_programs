package ru.mirea.kurushkin.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    private EditText editTextBook;
    private EditText editTextQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_share);

        TextView textDevBook = findViewById(R.id.textViewDev);
        TextView textDevQuote = findViewById(R.id.textView2);

        editTextBook = findViewById(R.id.editBook);
        editTextQuote = findViewById(R.id.editQuote);

        // Получаем данные от первой Activity
        String book = getIntent().getStringExtra(FavoriteBook.BOOK_KEY);
        String quote = getIntent().getStringExtra(FavoriteBook.QUOTE_KEY);

        textDevBook.setText("Любимая книга разработчика: " + book);
        textDevQuote.setText("Цитата: " + quote);

        findViewById(R.id.buttonSend).setOnClickListener(v -> {
            String userBook = editTextBook.getText().toString();
            String userQuote = editTextQuote.getText().toString();

            String result = "Название Вашей любимой книги: " + userBook +
                    "\nЦитата: " + userQuote;

            Intent data = new Intent();
            data.putExtra(FavoriteBook.RESULT_KEY, result);

            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }
}