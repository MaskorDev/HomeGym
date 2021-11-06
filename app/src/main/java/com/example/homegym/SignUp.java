package com.example.homegym;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

Button signUp;
EditText login, mail, password, repassword;
TextView back;
DBHelper DB;

String email_str, login_str, password_str, repassword_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back = findViewById(R.id.back);
        signUp = findViewById(R.id.SignUp);
        login = findViewById(R.id.Login);
        mail = findViewById(R.id.Mail);
        password = findViewById(R.id.Pass);
        repassword = findViewById(R.id.RePass);
        DB = new DBHelper(this);

        back.setOnClickListener(v -> {
            Intent signIn = new Intent(SignUp.this, SignIn.class);
            startActivity(signIn);
            finish();
        });

        signUp.setOnClickListener(v -> {
            email_str = mail.getText().toString();
            login_str = login.getText().toString();
            password_str = password.getText().toString();
            repassword_str = repassword.getText().toString();

            if(CheckAllStandarts() == true && isEmailValid(email_str)){
                Boolean insert = DB.insertData(login_str, password_str, email_str);
                if (insert == true) {
                    Toast.makeText(getApplicationContext(), "Регистрация выполнена", Toast.LENGTH_SHORT).show();
                    Intent signIn = new Intent(SignUp.this, SignIn.class);
                    startActivity(signIn);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Не удалось зарегистрировать", Toast.LENGTH_SHORT).show();
                }
            }
            });
        };


    public Boolean CheckAllStandarts(){
        if (login.length() == 0 && mail.length() == 0 && password.length() == 0 && repassword.length() == 0) {
            ShowDialog("Заполните все поля");
            return false;
        }

        else if (login.length() == 0 || mail.length() == 0 || password.length() == 0 || repassword.length() == 0) {
            ShowDialog("Заполните оставшиеся поля");
            return false;
        }

        else if(!(password_str.equals(repassword_str))) {
            ShowDialog("Неверно заполнены пароли");
            return false;
        }

        else if(DB.checkLogin(login_str) == true) {
            ShowDialog("Такой пользователь уже существует");
            return false;
        }
        else
            return true;
    }

    public boolean isEmailValid(String email) { String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
            +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|" +"([a-zA-Z]+[\\w-]+\\.)" +
            "+[a-zA-Z]{2,4})$";
    CharSequence inputStr = email;
    Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputStr); if(matcher.matches()) return true; else ShowDialog("Проверьте логин");
    return false;
    }

    public void ShowDialog(String messege) {
        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
        builder.setTitle("Ошибка")
                .setMessage(messege)
                .setPositiveButton("Ok", (dialog, which) -> {
                    dialog.cancel();
                });
       AlertDialog alertDialog = builder.create();
       alertDialog.show();
    }
}