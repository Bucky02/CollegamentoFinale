package com.example.collegamentofinale;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl;
    BackImages backImages;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl = findViewById(R.id.fl);

        Drawable basket = getApplicationContext().getResources().getDrawable(R.drawable.basket);
        Drawable jordan = getApplicationContext().getResources().getDrawable(R.drawable.jordan);

        Bitmap bBasket = ((BitmapDrawable)basket).getBitmap();
        Bitmap bJordan = ((BitmapDrawable)jordan).getBitmap();

        backImages = new BackImages(getApplicationContext(), bBasket, bJordan);

        fl.addView(backImages);

    }

    public void gioca(View v){
        Intent i = new Intent();
        i.setClass(this, Gioco.class);
        startActivityForResult(i, 453);
    }
}
