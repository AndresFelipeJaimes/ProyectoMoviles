package com.example.proyectomoviles;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity {
    TextInputLayout registeremail,registernae,registerpassword;
    TextView gotosignin;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actibity_registration);
        registeremail=findViewById(R.id.registeremail);
        registername=findViewById(R.id.registername);
        registerpasswrod=findViewById(R.id.registerpassword);
        gotosignin=findViewById(R.id.gotosignin);
    }
}
