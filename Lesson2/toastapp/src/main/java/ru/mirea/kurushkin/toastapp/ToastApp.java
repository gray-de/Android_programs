package ru.mirea.kurushkin.toastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ToastApp extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_app);

        editText = findViewById(R.id.editText);
    }

    public void countSymbols(View view) {

        String text = editText.getText().toString();

        int count = text.length();

        Toast toast = Toast.makeText(
                getApplicationContext(),
                "kurushkinДЕНТ №2 ГРУППА БСБО-51-24 Количество символов - " + count,
                Toast.LENGTH_LONG
        );

        toast.show();
    }
}