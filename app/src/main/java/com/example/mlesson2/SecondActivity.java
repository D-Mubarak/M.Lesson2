package com.example.mlesson2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText editText;
    private Button back, next;
    private ImageView camera, android, contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findView();
        initListener();
    }

    private void initListener() {
        back.setOnClickListener(v -> {
            finish();

        });
        next.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);

        });
    }

    private void findView() {
        editText = findViewById(R.id.edit_text);
        back = findViewById(R.id.back);
        camera = findViewById(R.id.camera);
        android = findViewById(R.id.android);
        contacts = findViewById(R.id.person);
        next = findViewById(R.id.next);
    }
}