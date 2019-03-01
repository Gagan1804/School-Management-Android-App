package com.gstar.schoolmanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    Button back,login;
    private EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        back = findViewById(R.id.back_to_main);
        login = findViewById(R.id.login_to_admin);
        username= findViewById(R.id.username_ed1);
        password= findViewById(R.id.password_ed2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AdminLogin.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                    String usr = username.getText().toString();
                    String psw = password.getText().toString();

                    String pass = "gagan";
                    String user = "gagandeep@gmail.com";
                    if(psw.equals(pass) && usr.equals(user))
                    {
                        Intent intent = new Intent(AdminLogin.this, AdminActivity.class);
                        intent.putExtra("Username :",usr);
                        startActivity(intent);
                        finish();
                    }
                    else
                        {
                            Toast.makeText(AdminLogin.this,"Username or Password is incorrect",Toast.LENGTH_LONG).show();
                            username.setText("");
                            password.setText("");
                        }
                }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AdminLogin.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
