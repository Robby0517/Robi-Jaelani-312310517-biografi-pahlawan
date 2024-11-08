package com.robby.galery2wp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout backgroundPutih, backgroundPutih1, backgroundPutih2, backgroundPutih3, backgroundPutih4, backgroundPutih5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ensure this is the correct layout file

        // Initialize each LinearLayout
        backgroundPutih = findViewById(R.id.backgrounputih);
        backgroundPutih1 = findViewById(R.id.backgrounputih1);
        backgroundPutih2 = findViewById(R.id.backgrounputih2);
        backgroundPutih3 = findViewById(R.id.backgrounputih3);
        backgroundPutih4 = findViewById(R.id.backgrounputih4);
        backgroundPutih5 = findViewById(R.id.backgrounputih5);

        // Set click listeners for each biography item
        setItemClickListener(backgroundPutih, "Ir.Soekarno");
        setItemClickListener(backgroundPutih1, "Mohammad Hatta");
        setItemClickListener(backgroundPutih2, "R.A Kartini");
        setItemClickListener(backgroundPutih3, "Pangeran Diponegoro");
        setItemClickListener(backgroundPutih4, "Tuanku Imam Bonjol");
        setItemClickListener(backgroundPutih5, "Raden Dewi Sartika");
    }

    private void setItemClickListener(LinearLayout layout, final String heroName) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start HasilSearchActivity and pass the hero name
                Intent intent = new Intent(MainActivity.this, HasilSearch.class);
                intent.putExtra("HERO_NAME", heroName);
                startActivity(intent);
            }
        });
    }
}
