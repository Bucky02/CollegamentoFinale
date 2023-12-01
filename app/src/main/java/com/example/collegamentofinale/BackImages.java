package com.example.collegamentofinale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class BackImages extends View {
    private Bitmap basket, jordan;
    int x=0, y=0;
    public BackImages(Context c, Bitmap basket, Bitmap jordan){
        super(c);
        this.basket = basket;
        this.jordan = jordan;
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint p = new Paint();
        canvas.drawBitmap(jordan, x, y , p);
        canvas.drawBitmap(basket, x, y , p);
    }

}
