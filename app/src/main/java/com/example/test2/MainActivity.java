package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plusOuMoinsBtn = findViewById(R.id.plusOuMoinsBtn);
        Button morpionBtn = findViewById(R.id.morpionBtn);

        plusOuMoinsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itPlusOuMoins = new Intent(MainActivity.this, PlusOuMoins.class);
                startActivity(itPlusOuMoins);
            }
        });

        morpionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itMorpion = new Intent(MainActivity.this, Morpion.class);
                startActivity(itMorpion);
            }
        });
    }
}