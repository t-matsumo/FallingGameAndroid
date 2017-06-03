package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * JTetrimino
 */
class JTetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.BLUE;
    /**
     * テトリミノの形
     */
    private static final Block[][][] J_SHAPES = {
            {
                    {null, null, null},
                    {new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT)},
                    {null, null, new Block(JTetrimino.COLOR_INT)}
            },
            {
                    {null, new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT)},
                    {null, new Block(JTetrimino.COLOR_INT), null},
                    {null, new Block(JTetrimino.COLOR_INT), null}
            },
            {
                    {null, null, null},
                    {new Block(JTetrimino.COLOR_INT), null, null},
                    {new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT)}
            },
            {
                    {null, new Block(JTetrimino.COLOR_INT), null},
                    {null, new Block(JTetrimino.COLOR_INT), null},
                    {new Block(JTetrimino.COLOR_INT), new Block(JTetrimino.COLOR_INT), null}
            }
    };

    JTetrimino() {
        super(J_SHAPES);
    }
}