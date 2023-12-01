package com.example.collegamentofinale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class BackImages extends View {
    private Bitmap basket, jordan;
    int x=100, y=350, WIDTH, zero = 0, SPEED = 10;
    public BackImages(Context c, Bitmap jordan, Bitmap basket, int w){
        super(c);
        this.jordan = jordan;
        this.basket = basket;
        this.WIDTH = w;
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint p = new Paint();
        canvas.drawBitmap(jordan, x, y , p);
        canvas.drawBitmap(basket, zero, zero , p);
        canvas.drawBitmap(jordan, x+WIDTH, y , p);
        x = x-SPEED;
        if (x < -WIDTH) x = 0;
    }

}
