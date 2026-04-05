package ru.mirea.kurushkin.simplefragmentapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class SimpleFragmentApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple_fragment_app);

        // Настройка отступов для системных панелей (если есть элемент с id main)
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment first = new FirstFragment();
        Fragment second = new SecondFragment();

        // Проверяем, есть ли кнопки (в портретной ориентации они есть, в ландшафтной - нет)
        View btnFirst = findViewById(R.id.btnFirst);
        View btnSecond = findViewById(R.id.btnSecond);

        if (btnFirst != null && btnSecond != null) {
            btnFirst.setOnClickListener(v ->
                    fm.beginTransaction().replace(R.id.fragmentContainerView, first).commit()
            );
            btnSecond.setOnClickListener(v ->
                    fm.beginTransaction().replace(R.id.fragmentContainerView, second).commit()
            );

            // Добавляем первый фрагмент только при первом создании (не при повороте)
            if (savedInstanceState == null) {
                fm.beginTransaction().add(R.id.fragmentContainerView, first).commit();
            }
        }
    }
}