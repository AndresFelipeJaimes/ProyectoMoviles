package com.example.proyectomoviles;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    EditText reginame, regiemail, regipass;
    Button registerbtn;
    TextView gotosign;
    TextInputLayout registeremail, registernae, registerpassword;
    FirebaseAuth auth;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration); // Corregido el nombre del layout

        reginame = findViewById(R.id.regname);
        regiemail = findViewById(R.id.regemail);
        regipass = findViewById(R.id.regpass);
        registerbtn = findViewById(R.id.signupbtn);
        gotosign = findViewById(R.id.gotosignin);

        auth = FirebaseAuth.getInstance(); // Corregido el método getInstance()
        database = FirebaseDatabase.getInstance();

        gotosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
    }

    private void createUser() {
        String username = reginame.getText().toString();
        String useremail = regiemail.getText().toString();
        String userpassword = regipass.getText().toString(); // Corregido el nombre de la variable

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Nombre está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(useremail)) {
            Toast.makeText(this, "Email está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userpassword)) {
            Toast.makeText(this, "Contraseña está vacía", Toast.LENGTH_SHORT).show();
            return;
        }
    auth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
     @Override
     public void onComplete(@NonNull Task<AuthResult> task) {
         if(task.isSuccessful()){
            Usermodel usermodel = new Usermodel(username,useremail,userpassword);
            String id = task.getResult().getUser().getUid();
            database.getReference().child("Users").child(id).setValue(usermodel);
         Toast.makeText(Registration.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
         startActivity(new Intent(Registration.this, Login.class));
         finish();

         }else{
             Toast.makeText(Registration.this,"Fallo",Toast.LENGTH_SHORT).show();
         }
         }
                // Aquí puedes continuar con la lógica para registrar al usuario en Firebase
        }
}
