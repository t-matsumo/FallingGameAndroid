package com.example.tatsuki.tetris;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;

import com.example.tatsuki.tetris.field.Field;
import com.example.tatsuki.tetris.tetriminos.AbstractTetrimino;
import com.example.tatsuki.tetris.tetriminos.TetriminoGenerator;

/**
 * Created by tatsuki on 2017/06/01.
 */
public class MainView extends SurfaceView implements SurfaceHolder.Callback, Runnable, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    /**
     * ジェスチャを検知
     */
    private GestureDetector gestureDetector;
    /**
     * viewのホルダー
     */
    private SurfaceHolder holder;
    /**
     * SurFaceView用のスレッド
     */
    private Thread thread;
    /**
     * ゲーム中であるあどうか
     */
    private static Boolean isGaming = true;
    /**
     * フィールド
     */
    private static Field field = new Field();
    /**
     * テトリミノ
     */
    private static AbstractTetrimino tetrimino = TetriminoGenerator.generateTetrimino();

    /**
     * コンストラクタ
     */
    public MainView(Context context) {
        super(context);

        this.holder = this.getHolder();
        this.holder.addCallback(this);

        this.gestureDetector = new GestureDetector(context, this);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        this.thread = null;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void move(int deltaX, int deltaY) {
        if (tetrimino.canMove(field.getField(), deltaX, deltaY)) {
            tetrimino.move(deltaX, deltaY);
        }
    }

    public void turn(int direction) {
        if (tetrimino.canTurn(field.getField(), direction)) {
            tetrimino.turn(direction);
        }
    }

    @Override
    public void run() {
        while (this.thread != null && !(field.isGameOver(tetrimino))) {
            long nextTime = System.currentTimeMillis() + 500;

            onTick();

            try {
                long sleepTime = nextTime - System.currentTimeMillis();
                if (sleepTime >= 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isGaming = false;
    }

    private void onTick() {
        field.banish();
        this.printOut();

        if (tetrimino.canMove(field.getField(), 0, 1)) {
            tetrimino.move(0, 1);
        } else {
            field.fixTetrimino(tetrimino);
            tetrimino = TetriminoGenerator.generateTetrimino();
        }
    }

    private void printOut() {
        Canvas canvas = holder.lockCanvas();
        if (canvas == null) {
            return;
        }

        canvas.drawColor(Color.WHITE);
        field.printOut(tetrimino, canvas);

        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        int width = this.getWidth();

        int deltaX;
        if (e.getX() < width / 2) {
            deltaX = -1;
        } else {
            deltaX = 1;
        }

        move(deltaX, 0);
        this.printOut();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        int width = this.getWidth();

        int deltaX;
        if (e.getX() < width / 2) {
            deltaX = -1;
        } else {
            deltaX = 1;
        }

        move(deltaX, 0);
        this.printOut();
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(velocityY) > Math.abs(velocityX)) {
            // 下向きにフリックされたら落とす
            while (this.tetrimino.canMove(this.field.getField(), 0, 1)) {
                this.tetrimino.move(0, 1);
            }
        } else {
            // 横向きにフリックされたら回転
            int direction;
            if (velocityX < 0) {
                direction = -1;
            } else {
                direction = 1;
            }

            turn(direction);
        }

        this.printOut();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
}
