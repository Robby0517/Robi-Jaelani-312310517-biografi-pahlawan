package com.robby.galery2wp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi komponen dari XML
        etUsername = findViewById(R.id.username); // Sesuai dengan ID di XML
        etPassword = findViewById(R.id.password); // Sesuai dengan ID di XML
        btnLogin = findViewById(R.id.btnlogin);   // Sesuai dengan ID di XML
        btnRegister = findViewById(R.id.btnsignup); // Sesuai dengan ID di XML untuk Register

        // Logika saat tombol Login diklik
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Memuat data akun dari SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String savedUsername = sharedPreferences.getString(username + "_username", null);
                String savedPassword = sharedPreferences.getString(username + "_password", null);

                // Validasi username dan password
                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    // Lanjutkan ke MainActivity
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Logika saat tombol Register diklik
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman register
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }
}
