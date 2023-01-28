package com.example.test2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;
    private ChibiCharacter chibi1;

    public GameSurface(Context context) {
        super(context);

        this.setFocusable(true);

        //Set callback
        this.getHolder().addCallback(this);
    }

    //Make game surface focusable so it can handle events.


    public void update() {
        this.chibi1.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        this.chibi1.draw(canvas);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Bitmap chibiBitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.chibi1);
        this.chibi1 = new ChibiCharacter(this, chibiBitmap1, 100, 50);

        this.gameThread = new GameThread(this, holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        boolean retry= true;

        while(retry) {
            try {
                this.gameThread.setRunning(false);

                //Parent thread must wait until the end of GameThread.
                this.gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retry = true;
        }
    }
}


