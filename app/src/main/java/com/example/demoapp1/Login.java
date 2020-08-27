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

public class Login extends AppCompatActivity {
    private Spinner spinner;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        Button check = findViewById(R.id.check);
        spinner = findViewById(R.id.countryspinner);
        mAuth = FirebaseAuth.getInstance();
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CountryData.countryNames));
        final EditText phone = findViewById(R.id.phonearea);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];
                String number = phone.getText().toString().trim();
                String phonenumber = '+'+code+number;
                verify(phonenumber);

            }
        });
    }

    private void verify(String phonenumber) {
        Intent intent = new Intent(Login.this,OTP.class);
        intent.putExtra("phonenumber",phonenumber);
        startActivity(intent);
    }
}
