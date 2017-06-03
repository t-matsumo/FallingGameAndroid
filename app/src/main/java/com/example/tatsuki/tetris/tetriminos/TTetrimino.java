package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * TTetrimino
 */
class TTetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.CYAN;
    /**
     * テトリミノの形
     */
    private static final Block[][][] T_SHAPES = {
            {
                    {null, null, null},
                    {new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT)},
                    {null, new Block(TTetrimino.COLOR_INT), null}
            },
            {
                    {null, new Block(TTetrimino.COLOR_INT), null},
                    {null, new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT)},
                    {null, new Block(TTetrimino.COLOR_INT), null}
            },
            {
                    {null, null, null},
                    {null, new Block(TTetrimino.COLOR_INT), null},
                    {new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT)}
            },
            {
                    {null, new Block(TTetrimino.COLOR_INT), null},
                    {new Block(TTetrimino.COLOR_INT), new Block(TTetrimino.COLOR_INT), null},
                    {null, new Block(TTetrimino.COLOR_INT), null}
            }
    };

    TTetrimino() {
        super(T_SHAPES);
    }
}