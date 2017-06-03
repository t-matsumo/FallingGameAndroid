package com.example.tatsuki.tetris;

import android.app.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

/**
 * Tetris
 */
public class MainActivity extends Activity {

    /**
     * 画面表示時に実行
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
        );
        this.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(new MainView(this));
    }
}