package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * LTetrimino
 */
class LTetrimino extends AbstractTetrimino {
    /** テトリミノの色 (オレンジ：ffa500) */
    private static final int COLOR_INT = Color.rgb(255, 165, 0);
    /**
     * テトリミノの形
     */
    private static final Block[][][] L_SHAPES = {
            {
                    {null, null, null},
                    {new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT)},
                    {new Block(LTetrimino.COLOR_INT), null, null}
            },
            {
                    {null, new Block(LTetrimino.COLOR_INT), null},
                    {null, new Block(LTetrimino.COLOR_INT), null},
                    {null, new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT)}
            },
            {
                    {null, null, null},
                    {null, null, new Block(LTetrimino.COLOR_INT)},
                    {new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT)}
            },
            {
                    {new Block(LTetrimino.COLOR_INT), new Block(LTetrimino.COLOR_INT), null},
                    {null, new Block(LTetrimino.COLOR_INT), null},
                    {null, new Block(LTetrimino.COLOR_INT), null}
            }
    };

    LTetrimino() {
        super(L_SHAPES);
    }
}