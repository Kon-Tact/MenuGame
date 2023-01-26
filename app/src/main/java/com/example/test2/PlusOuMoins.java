package com.example.test2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlusOuMoins extends AppCompatActivity {

    int nbrRando;
    // Comment


    public void randoNbr() {
        int nbrRando = 1 + (int)(Math.random() * ((20 - 1) + 1));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plusoumoins);

        Button guessBtn, changeNbrBtn, backBtn;
        EditText etguessNbr;

        // A demander
//        Intent intent = getIntent();
//        String textLinearLayout = intent.getStringExtra("titre_LinearLayout");
//        TextView textViewTitre = findViewByID(R.id.tvTitre);
//        textViewTitre.setText(titreLinearLayout);

        randoNbr();

        //Références avec le layout
        guessBtn = findViewById(R.id.guessBtn);
        changeNbrBtn = findViewById(R.id.changeNbrBtn);
        etguessNbr = findViewById(R.id.etguessNbr);
        backBtn = findViewById(R.id.backBtn);



        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int essai = Integer.parseInt(etguessNbr.getText().toString());
                if (essai == nbrRando){
                    Toast.makeText(PlusOuMoins.this, "Bravo c'est le bon chiffre !",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PlusOuMoins.this, "Raté, essaie encore !",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        changeNbrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randoNbr();
                Toast.makeText(PlusOuMoins.this, "Le chiffre a été actualisé",
                        Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itRetourMenu = new Intent(PlusOuMoins.this, MainActivity.class);
                startActivity(itRetourMenu);
            }
        });

    }
}
