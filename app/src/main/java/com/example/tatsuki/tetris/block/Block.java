package com.example.tatsuki.tetris.block;

import android.graphics.Color;

import com.example.tatsuki.tetris.position.Position;

/**
 * Created by tatsuki on 2017/06/04.
 */

public class Block {
    /** ブロックの色 */
    private int colorInt;

    public Block(int colorInt) {
        this.colorInt = colorInt;
    }

    public int getColorInt() {
        return colorInt;
    }

    public void setColorInt(int colorInt) {
        this.colorInt = colorInt;
    }
}
