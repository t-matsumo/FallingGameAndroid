package com.example.tatsuki.tetris.tetriminos;

import android.graphics.Color;

import com.example.tatsuki.tetris.block.Block;

/**
 * ZTetrimino
 */
class ZTetrimino extends AbstractTetrimino {
    /** テトリミノの色 */
    private static final int COLOR_INT = Color.GREEN;
    /**
     * テトリミノの形
     */
    private static final Block[][][] Z_SHAPES = {
            {
                    {null, null, null},
                    {new Block(ZTetrimino.COLOR_INT), new Block(ZTetrimino.COLOR_INT), null},
                    {null, new Block(ZTetrimino.COLOR_INT), new Block(ZTetrimino.COLOR_INT)}
            },
            {
                    {null, null, new Block(ZTetrimino.COLOR_INT)},
                    {null, new Block(ZTetrimino.COLOR_INT), new Block(ZTetrimino.COLOR_INT)},
                    {null, new Block(ZTetrimino.COLOR_INT), null}
            }
    };

    ZTetrimino() {
        super(Z_SHAPES);
    }
}