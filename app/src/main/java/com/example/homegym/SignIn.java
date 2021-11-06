package com.example.homegym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
TextView signUp, skip;
EditText Login, password;
Button signIn;
DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signUp = findViewById(R.id.SignUp);
        signIn = findViewById(R.id.SignIn);
        skip = findViewById(R.id.skip);
        Login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        DB = new DBHelper(this);


        signUp.setOnClickListener(v -> {
            Intent signUp = new Intent(SignIn.this, SignUp.class);
            startActivity(signUp);
            finish();
        });

        signIn.setOnClickListener(v -> {
            if (check_result() == true) {
                Toast.makeText(getApplicationContext(), "Успешный вход", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn.this, Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public Boolean check_result(){
        String login = Login.getText().toString();
        String pwd = password.getText().toString();

        if (Login.length() == 0 || password.length() == 0) {
            ShowDialog("Нужно заполнить все поля");
            return false;
        }
        else {
            try {
                if (DB.checkUserPassword(login, pwd) == true) {
                    return true;
                }
                else {
                    ShowDialog("Неверный логин или пароль");
                    return false;
                }
            }
            catch (Exception e) {
                ShowDialog("Проблемы с базой данных");
                return false;
            }
        }
    }

    public void ShowDialog(String messege){
        AlertDialog.Builder builder = new AlertDialog.Builder(SignIn.this);
        builder.setTitle("Ошибка")
                .setMessage(messege)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}