package com.example.collegamentofinale;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl;
    BackImages backImages;
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            fl.invalidate();
            backImages.invalidate();
            handler.postDelayed(this, 10);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int hpx = point.y;
        int wpx = point.x;

        fl = findViewById(R.id.fl);

        Drawable basket = getApplicationContext().getResources().getDrawable(R.drawable.basket);
        Drawable jordan = getApplicationContext().getResources().getDrawable(R.drawable.jordan);


        Bitmap bBasket = ((BitmapDrawable)basket).getBitmap();
        Bitmap bJordan = ((BitmapDrawable)jordan).getBitmap();

        Bitmap rbBasket = Bitmap.createScaledBitmap(bBasket, wpx, hpx, false);
        Bitmap rbJordan = Bitmap.createScaledBitmap(bJordan, wpx/2, hpx/2, false);

        backImages = new BackImages(getApplicationContext(), rbJordan, rbBasket, wpx);

        fl.addView(backImages);
        handler.postDelayed(r, 10);


    }

    public void gioca(View v){
        Intent i = new Intent();
        i.setClass(this, Gioco.class);
        startActivityForResult(i, 453);
    }
}
