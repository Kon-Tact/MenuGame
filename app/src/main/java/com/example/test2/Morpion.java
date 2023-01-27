package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Morpion extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.morpion);

        Button backBtn2 = findViewById(R.id.backBtn2);

        backBtn2.setOnClickListener(v -> {
            Intent itRetourMenu = new Intent(Morpion.this, MainActivity.class);
            startActivity(itRetourMenu);
        });

    }
}
