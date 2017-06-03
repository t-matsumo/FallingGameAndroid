package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * OTetrimino
 */
class OTetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.YELLOW;
    /**
     * テトリミノの形
     */
    private static final Block[][][] O_SHAPES = {
            {
                    {null, null, null},
                    {null, new Block(OTetrimino.COLOR_INT), new Block(OTetrimino.COLOR_INT)},
                    {null, new Block(OTetrimino.COLOR_INT), new Block(OTetrimino.COLOR_INT)}
            },
            {
                    {null, null, null},
                    {null, new Block(OTetrimino.COLOR_INT), new Block(OTetrimino.COLOR_INT)},
                    {null, new Block(OTetrimino.COLOR_INT), new Block(OTetrimino.COLOR_INT)}
            }
    };

    OTetrimino() {
        super(O_SHAPES);
    }
}