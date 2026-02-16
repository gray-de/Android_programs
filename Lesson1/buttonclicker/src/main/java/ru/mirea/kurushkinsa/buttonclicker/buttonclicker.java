package ru.mirea.kurushkinsa.buttonclicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class buttonclicker extends AppCompatActivity {

    private TextView tvOut;
    private Button btnWhoAmI;
    private Button btnItIsNotMe;

    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buttonclicker);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnWhoAmI = findViewById(R.id.btnWhoAmI);
        btnItIsNotMe = findViewById(R.id.btnItIsNotMe);
        checkBox = findViewById(R.id.checkBox);

        View.OnClickListener oclbtnWhoAmI = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOut.setText("Мой номер по списку № 2");
            }
        };

        btnWhoAmI.setOnClickListener(oclbtnWhoAmI);

    }
    public void onMyButtonClick(View view)
    {

        tvOut.setText("Это не я сделал");
        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
        }
        else {
            checkBox.setChecked(true);
        }

    }
}
