package com.example.proyectomoviles;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText loginEmail, loginPassword; // Corregidos los nombres de las variables
    Button loginButton;
    TextView goToRegister;
    FirebaseAuth auth; // Cambiada la declaración de Firebase a FirebaseAuth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicialización de vistas
        loginEmail = findViewById(R.id.logmail);
        loginPassword = findViewById(R.id.logpassword);
        loginButton = findViewById(R.id.loginbtn);
        goToRegister = findViewById(R.id.gotoregister);

        // Inicialización de FirebaseAuth
        auth = FirebaseAuth.getInstance();

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad de registro
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intenta iniciar sesión al hacer clic en el botón de inicio de sesión
                loginUser();
            }
        });
    }

    private void loginUser() {
        String userEmail = loginEmail.getText().toString();
        String userPassword = loginPassword.getText().toString();

        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "El campo de correo electrónico está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        // Iniciar sesión con Firebase Authentication
        auth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Inicio de sesión exitoso, muestra un mensaje
                    Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    // Fallo en el inicio de sesión, muestra un mensaje
                    Toast.makeText(Login.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
