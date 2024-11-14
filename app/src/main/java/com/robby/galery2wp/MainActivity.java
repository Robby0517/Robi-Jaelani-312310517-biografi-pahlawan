package com.robby.galery2wp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout backgroundPutih, backgroundPutih1, backgroundPutih2, backgroundPutih3, backgroundPutih4, backgroundPutih5;
    private ImageView menuIcon, userIcon;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen tampilan
        backgroundPutih = findViewById(R.id.backgrounputih);
        backgroundPutih1 = findViewById(R.id.backgrounputih1);
        backgroundPutih2 = findViewById(R.id.backgrounputih2);
        backgroundPutih3 = findViewById(R.id.backgrounputih3);
        backgroundPutih4 = findViewById(R.id.backgrounputih4);
        backgroundPutih5 = findViewById(R.id.backgrounputih5);

        // Set listener untuk setiap item biografi
        setItemClickListener(backgroundPutih, "Ir.Soekarno");
        setItemClickListener(backgroundPutih1, "Mohammad Hatta");
        setItemClickListener(backgroundPutih2, "R.A Kartini");
        setItemClickListener(backgroundPutih3, "Pangeran Diponegoro");
        setItemClickListener(backgroundPutih4, "Tuanku Imam Bonjol");
        setItemClickListener(backgroundPutih5, "Raden Dewi Sartika");

        // Inisialisasi komponen toolbar
        menuIcon = findViewById(R.id.menu_icon);
        userIcon = findViewById(R.id.user_icon);
        searchBar = findViewById(R.id.search_bar);

        // Menambahkan OnClickListener untuk menuIcon (ikon garis tiga)
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Menampilkan opsi menu menggunakan AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilih Opsi")
                        .setItems(new String[]{"Profil", "Pengaturan", "Tentang Aplikasi", "Login", "Register", "Keluar"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0: // Profil
                                        Intent profileIntent = new Intent(MainActivity.this, Profil.class);
                                        startActivity(profileIntent);
                                        break;
                                    case 1: // Pengaturan
                                        Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                                        startActivity(settingsIntent);
                                        break;
                                    case 2: // Tentang Aplikasi
                                        Toast.makeText(MainActivity.this, "Ini adalah aplikasi biografi pahlawan nasional.", Toast.LENGTH_SHORT).show();
                                        break;
                                    case 3: // Login
                                        Intent loginIntent = new Intent(MainActivity.this, Login.class);
                                        startActivity(loginIntent);
                                        break;
                                    case 4: // Register
                                        Intent registerIntent = new Intent(MainActivity.this, Register.class);
                                        startActivity(registerIntent);
                                        break;
                                    case 5: // Keluar
                                        finish();
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });

        // Menambahkan TextWatcher untuk searchBar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // Tidak ada yang perlu dilakukan di sini
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String query = charSequence.toString().trim().toLowerCase();
                if (!query.isEmpty()) {
                    // Menampilkan hasil pencarian berdasarkan nama yang cocok
                    filterResults(query);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Tidak ada yang perlu dilakukan di sini
            }
        });
    }

    private void setItemClickListener(LinearLayout layout, final String heroName) {
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHeroActivity(heroName);
            }
        });
    }

    private void filterResults(String query) {
        // Melakukan pencocokan dengan nama pahlawan menggunakan substring
        if (query.contains("soekarno")) {
            openHeroActivity("Ir.Soekarno");
        } else if (query.contains("hatta")) {
            openHeroActivity("Mohammad Hatta");
        } else if (query.contains("kartini")) {
            openHeroActivity("R.A Kartini");
        } else if (query.contains("diponegoro")) {
            openHeroActivity("Pangeran Diponegoro");
        } else if (query.contains("imam") || query.contains("bonjol")) {
            openHeroActivity("Tuanku Imam Bonjol");
        } else if (query.contains("dewi") || query.contains("sartika")) {
            openHeroActivity("Raden Dewi Sartika");
        } else {
            // Tampilkan pesan jika tidak ditemukan hasil pencarian
            Toast.makeText(MainActivity.this, "Masukkan nama dengan benar", Toast.LENGTH_SHORT).show();
        }
    }

    private void openHeroActivity(String heroName) {
        Intent intent = null;

        // Mengarahkan ke halaman sesuai dengan nama pahlawan
        switch (heroName) {
            case "Ir.Soekarno":
                intent = new Intent(MainActivity.this, HasilSearch.class);
                break;
            case "Mohammad Hatta":
                intent = new Intent(MainActivity.this, MohammadHatta.class);
                break;
            case "R.A Kartini":
                intent = new Intent(MainActivity.this, R_A_Kartini.class);
                break;
            case "Pangeran Diponegoro":
                intent = new Intent(MainActivity.this, Pangeran_diponogoro.class);
                break;
            case "Tuanku Imam Bonjol":
                intent = new Intent(MainActivity.this, Tuanku_Imam_Bonjol.class);
                break;
            case "Raden Dewi Sartika":
                intent = new Intent(MainActivity.this, Raden_dewi_sartika.class);
                break;
        }

        if (intent != null) {
            intent.putExtra("HERO_NAME", heroName);
            startActivity(intent);
        }
    }
}
