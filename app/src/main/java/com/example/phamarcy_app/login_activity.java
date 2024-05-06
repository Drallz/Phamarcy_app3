package com.example.phamarcy_app;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    // HashMap to store usernames and passwords
    private HashMap<String, String> credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);

        // Initialize credentials HashMap and add sample user
        credentials = new HashMap<>();
        credentials.put("example_user", "password123");

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get username and password input
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Validate input
                if (TextUtils.isEmpty(username)) {
                    // Username field is empty
                    usernameEditText.setError("Username is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    // Password field is empty
                    passwordEditText.setError("Password is required");
                    return;
                }

                // Perform login
                if (isValidCredentials(username, password)) {
                    // Successful login
                    showToast("Login successful!");
                } else {
                    // Invalid credentials
                    showToast("Invalid username or password");
                }
            }
        });
    }

    // Method to validate entered username and password
    private boolean isValidCredentials(String username, String password) {
        // Check if username exists in HashMap and if password matches
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    // Helper method to show toast message
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}