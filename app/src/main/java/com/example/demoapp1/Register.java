package com.example.demoapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CountryData.countryNames));
        final EditText phoneEntry = findViewById(R.id.phone);
        Button register = findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
                String number = phoneEntry.getText().toString().trim();
                if (number.length() != 10){
                    phoneEntry.setError("Valid Number Required!!");
                    phoneEntry.requestFocus();
                    return;
                }
                else{
                    String phonenumber = '+'+code+number;
                    Intent intent = new Intent(Register.this,OTP.class);
                    intent.putExtra("phonenumber",phonenumber);
                    startActivity(intent);
                }

            }
        });
    }

}
