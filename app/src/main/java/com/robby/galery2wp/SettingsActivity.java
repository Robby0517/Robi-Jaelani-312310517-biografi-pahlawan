package com.robby.galery2wp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotifications;
    private Spinner languageSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize UI components
        switchNotifications = findViewById(R.id.switch_notifications);
        languageSpinner = findViewById(R.id.language_spinner);
        saveButton = findViewById(R.id.save_button);

        // Load previously saved settings
        loadSettings();

        // Save settings when the button is clicked
        saveButton.setOnClickListener(v -> {
            saveSettings();
            Toast.makeText(SettingsActivity.this, "Settings saved", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadSettings() {
        // Simulate loading settings (replace with SharedPreferences or database)
        switchNotifications.setChecked(true); // Example: notifications enabled
        languageSpinner.setSelection(1); // Example: second language selected
    }

    private void saveSettings() {
        // Simulate saving settings (replace with SharedPreferences or database)
        boolean notificationsEnabled = switchNotifications.isChecked();
        String selectedLanguage = languageSpinner.getSelectedItem().toString();

        // Debugging
        System.out.println("Notifications: " + notificationsEnabled);
        System.out.println("Language: " + selectedLanguage);
    }
}
