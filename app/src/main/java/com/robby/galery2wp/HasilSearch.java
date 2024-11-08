package com.robby.galery2wp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HasilSearch extends AppCompatActivity {

    private ImageView menuIcon, userIcon, characterImage, imageIcon, homeIcon, personIcon;
    private TextView titleText, biographyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_search);

        // Menghubungkan elemen-elemen UI dengan ID mereka
        menuIcon = findViewById(R.id.menu_icon);
        userIcon = findViewById(R.id.user_icon);
        characterImage = findViewById(R.id.carakter);
        imageIcon = findViewById(R.id.image_icon);
        homeIcon = findViewById(R.id.home_icon);
        personIcon = findViewById(R.id.person_icon);
        titleText = findViewById(R.id.title_text);
        biographyText = findViewById(R.id.biography_text);

        // Set listener untuk menu icon
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "Menu icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set listener untuk user icon
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "User icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set listener untuk character image
        characterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "Character image clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set listener untuk icon di bagian bawah (Bottom Navigation)
        imageIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "Image icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "Home icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        personIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HasilSearch.this, "Person icon clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set text untuk elemen TextView
        titleText.setText("Ir. Soekarno");
        biographyText.setText("Ir. Soekarno atau biasa dipanggil dengan sebutan Bung Karno adalah seorang negarawan, orator, dan Presiden Indonesia pertama yang menjabat sejak tahun 1945 hingga tahun 1967...");
    }
}
