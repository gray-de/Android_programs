package ru.mirea.kurushkin.favoritebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


public class FavoriteBook extends AppCompatActivity {

    public static final String BOOK_KEY = "book";
    public static final String QUOTE_KEY = "quote";
    public static final String RESULT_KEY = "result";

    private TextView textViewResult;

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorite_book);

        textViewResult = findViewById(R.id.textViewResult);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String text = data.getStringExtra(RESULT_KEY);
                        textViewResult.setText(text);
                    }
                }
        );
    }

    public void openSecondScreen(View view) {
        Intent intent = new Intent(this, ShareActivity.class);

        intent.putExtra(BOOK_KEY, "Путь к успеху");
        intent.putExtra(QUOTE_KEY, "Самое важное — не падать духом, даже если обстоятельства против тебя. ");

        launcher.launch(intent);
    }
}