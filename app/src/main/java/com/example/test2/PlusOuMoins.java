package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlusOuMoins extends AppCompatActivity {

    int nbrRando;

    public void randoNbr() {
        nbrRando = 1 + (int)(Math.random() * ((5 - 1) + 1));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plusoumoins);

        Button guessBtn, changeNbrBtn, backBtn;
        EditText etguessNbr;
        randoNbr();

        //Références avec le layout
        guessBtn = findViewById(R.id.guessBtn);
        changeNbrBtn = findViewById(R.id.changeNbrBtn);
        etguessNbr = findViewById(R.id.etguessNbr);
        backBtn = findViewById(R.id.backBtn);

        guessBtn.setOnClickListener(v -> {

            int essai = Integer.parseInt(etguessNbr.getText().toString());
            if (essai == nbrRando){
                Toast.makeText(PlusOuMoins.this, "Bravo c'est le bon chiffre !",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PlusOuMoins.this, "Raté, essaie encore !",
                        Toast.LENGTH_SHORT).show();
            }

        });

        changeNbrBtn.setOnClickListener(v -> {
            randoNbr();
            Toast.makeText(PlusOuMoins.this, "Le chiffre a été actualisé",
                    Toast.LENGTH_SHORT).show();
        });

        backBtn.setOnClickListener(v -> {
            Intent itRetourMenu = new Intent(PlusOuMoins.this, MainActivity.class);
            startActivity(itRetourMenu);
        });

    }
}
