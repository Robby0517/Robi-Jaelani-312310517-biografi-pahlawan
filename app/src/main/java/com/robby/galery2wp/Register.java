package com.robby.galery2wp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Pastikan nama file XML sesuai

        // Menghubungkan komponen XML ke Java dengan ID yang sesuai
        etUsername = findViewById(R.id.username);
        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password2);
        btnRegister = findViewById(R.id.akunButton);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

                // Periksa apakah akun sudah ada
                if (sharedPreferences.contains(username)) {
                    Toast.makeText(Register.this, "Username sudah digunakan", Toast.LENGTH_SHORT).show();
                } else {
                    // Simpan data akun baru
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(username + "_username", username);
                    editor.putString(username + "_email", email);
                    editor.putString(username + "_password", password);
                    editor.apply();

                    Toast.makeText(Register.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();

                    // Berpindah ke halaman login atau MainActivity
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
