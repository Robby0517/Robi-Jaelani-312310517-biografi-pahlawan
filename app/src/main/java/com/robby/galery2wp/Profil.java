package com.robby.galery2wp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Profil extends AppCompatActivity {
    private TextView usernameLabel;
    private EditText editUsername, editEmail, editPassword;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        // Menghubungkan komponen XML ke Java dengan ID yang sesuai
        usernameLabel = findViewById(R.id.AKUN); // Sesuaikan ID dengan XML
        editUsername = findViewById(R.id.username); // Sesuaikan ID dengan XML
        editEmail = findViewById(R.id.email); // Sesuaikan ID dengan XML
        editPassword = findViewById(R.id.password2); // Sesuaikan ID dengan XML
        btnLogout = findViewById(R.id.akunButton); // Sesuaikan ID dengan XML

        // Mendapatkan data dari SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");

        // Menampilkan data pada komponen yang sesuai
        usernameLabel.setText("Akun Anda");
        editUsername.setText(username);
        editEmail.setText(email);
        editPassword.setText(password);

        // Fungsi tombol Logout
        btnLogout.setOnClickListener(v -> {
            // Menghapus data di SharedPreferences untuk logout
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            // Berpindah kembali ke halaman Login
            Intent intent = new Intent(Profil.this, Login.class);
            startActivity(intent);
            finish();
        });
    }
}
