package com.example.phamarcy_app;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPharmacyId;
    private RadioGroup radioGroupGender;
    private Button buttonSignupPatient;
    private Button buttonSignupPharmacist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI elements
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPharmacyId = findViewById(R.id.editTextPharmacyId);
        //pGender = findViewById(R.id.pGender);
        radioGroupGender = findViewById(R.id.radioGroupGender);

      //  RadioButton pGender = findViewById(R.id.pGender);

        buttonSignupPatient = findViewById(R.id.buttonSignupPatient);
        buttonSignupPharmacist = findViewById(R.id.buttonSignupPharmacist);

        // Set click listener for the patient signup button
        buttonSignupPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup("Patient");
            }
        });

        // Set click listener for the pharmacist signup button
        buttonSignupPharmacist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup("Pharmacist");
            }
        });
    }

    private void signup(String userType) {
        // Perform signup logic here
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String pharmacyId = editTextPharmacyId.getText().toString().trim();

        // Get selected gender
        String gender = "";
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedGenderId == R.id.radioButtonMale) {
            gender = "Male";
        } else if (selectedGenderId == R.id.radioButtonFemale) {
            gender = "Female";
        }

        // Validate input
        if (username.isEmpty() || password.isEmpty() || pharmacyId.isEmpty() || gender.isEmpty()) {
            Toast.makeText(Signup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // If input is valid, you might perform signup operation here
            // For simplicity, let's just display a toast message
            Toast.makeText(Signup.this, "Signup successful as " + userType, Toast.LENGTH_SHORT).show();
            // Here you can start a new activity based on the userType, e.g., PatientSignupActivity or PharmacistSignupActivity
            // For demonstration purposes, let's just show the user type and details in a toast
            String userDetails = "Username: " + username + "\nPassword: " + password + "\nPharmacy ID: " + pharmacyId + "\nGender: " + gender;
            Toast.makeText(Signup.this, userDetails, Toast.LENGTH_LONG).show();
        }
    }
}