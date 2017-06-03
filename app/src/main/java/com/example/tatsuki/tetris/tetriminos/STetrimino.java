package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * STetrimino
 */
class STetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.MAGENTA;
    /**
     * テトリミノの形
     */
    private static final Block[][][] S_SHAPES = {
            {
                    {null, null, null},
                    {null, new Block(STetrimino.COLOR_INT), new Block(STetrimino.COLOR_INT)},
                    {new Block(STetrimino.COLOR_INT), new Block(STetrimino.COLOR_INT), null}
            },
            {
                    {new Block(STetrimino.COLOR_INT), null, null},
                    {new Block(STetrimino.COLOR_INT), new Block(STetrimino.COLOR_INT), null},
                    {null, new Block(STetrimino.COLOR_INT), null}
            }
    };

    STetrimino() {
        super(S_SHAPES);
    }
}