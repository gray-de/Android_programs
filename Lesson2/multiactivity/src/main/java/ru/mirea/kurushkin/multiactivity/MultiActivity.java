package ru.mirea.kurushkin.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MultiActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        editText = findViewById(R.id.editText);
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void sendText(View view) {

        String text = editText.getText().toString();

        Intent intent = new Intent(MultiActivity.this, SecondActivity.class);
        intent.putExtra("key", text);

        startActivity(intent);
    }
}