package com.example.proyectomoviles;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText loginemail,loginpassword;
    Button loginbtn;
    TextView gotoregister;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginemail=findViewById(R.id.logmail);
        loginpassword=findViewById();
        loginbtn=findViewById();
        gotoregister=findViewById();
        gotoregister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Login,this,Registration.class));
            }
        })
    }
}
