package com.example.mlesson2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button go;
    private ImageView imgCar;
    private TextInputEditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        setImageDate();
        initListener();

    }

    private void initListener() {
        go.setOnClickListener(v -> {
            if (password.getText().toString().length() > 6 && username.getText().toString().length() > 0) {
                Intent intent = new Intent(this, HW_Activity.class);
                intent.putExtra("key2", password.getText().toString());
                intent.putExtra("key1", username.getText().toString());
                startActivity(intent);
            } else if (password.getText().toString().length() < 6) {
                password.setError("Пароль должен быть больше 6 символов !");
            } else if (username.getText().toString().length() <= 0) {
                username.setError("Заполните пустое пространство !");
            }
        });
    }

    private void findViewById() {
        imgCar = findViewById(R.id.image_car);
        go = findViewById(R.id.GO);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
    }

    private void setImageDate() {
        String URI = "https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg";
        Glide.with(MainActivity.this).load(URI).into(imgCar);
    }


}