package com.example.mlesson2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class HW_Activity extends AppCompatActivity {
    private ImageView IVPhoto;
    private Button back;
    private TextView editPhoto;
    private EditText name, surname, email, numberOfNumber, password;
    private static final int GALLERY = 761;
    private static final int CAMERA = 807;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw);

        back = findViewById(R.id.back);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        numberOfNumber = findViewById(R.id.number_of_phone);
        password = findViewById(R.id.password);
        IVPhoto = findViewById(R.id.photo_of_user);
        editPhoto = findViewById(R.id.textView);

        back.setOnClickListener(v -> {
            finish();
        });

        IVPhoto.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_PICK);
            startActivityForResult(intent, GALLERY);
        });

        editPhoto.setOnClickListener(v -> {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA);

        });
        name.setText(getIntent().getStringExtra("key1"));

        password.setText(getIntent().getStringExtra("key2"));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY && resultCode == RESULT_OK && data != null) {
            Glide.with(this).load(data.getData().toString()).circleCrop().into(IVPhoto);
        }
        if (requestCode == CAMERA && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Glide.with(this).load(imageBitmap).circleCrop().into(IVPhoto);

        }
    }

}