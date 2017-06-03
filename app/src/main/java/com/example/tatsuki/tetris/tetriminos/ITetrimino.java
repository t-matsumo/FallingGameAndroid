package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * ITetrimino
 */
class ITetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.RED;
    /**
     * テトリミノの形
     */
    private static final Block[][][] I_SHAPES = {
            {
                    {null, null, null, null},
                    {new Block(ITetrimino.COLOR_INT), new Block(ITetrimino.COLOR_INT), new Block(ITetrimino.COLOR_INT), new Block(ITetrimino.COLOR_INT)},
                    {null, null, null, null},
                    {null, null, null, null}
            },
            {
                    {null, null, new Block(ITetrimino.COLOR_INT), null},
                    {null, null, new Block(ITetrimino.COLOR_INT), null},
                    {null, null, new Block(ITetrimino.COLOR_INT), null},
                    {null, null, new Block(ITetrimino.COLOR_INT), null}
            }
    };

    ITetrimino() {
        super(I_SHAPES);
    }
}