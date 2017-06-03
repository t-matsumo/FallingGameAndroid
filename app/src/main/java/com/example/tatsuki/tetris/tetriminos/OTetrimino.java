package com.example.tatsuki.tetris.tetriminos;

/**
 * OTetrimino
 */
class OTetrimino extends AbstractTetrimino {
    /**
     * テトリミノの形
     */
    private static final int[][][] O_SHAPES = {
            {
                    {0, 0, 0},
                    {0, 1, 1},
                    {0, 1, 1}
            },
            {
                    {0, 0, 0},
                    {0, 1, 1},
                    {0, 1, 1}
            }
    };

    OTetrimino() {
        super(O_SHAPES);
    }
}