package com.example.tatsuki.tetris.tetriminos;

/**
 * JTetrimino
 */
class JTetrimino extends AbstractTetrimino {
    /**
     * テトリミノの形
     */
    private static final int[][][] J_SHAPES = {
            {
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 0, 1}
            },
            {
                    {0, 1, 1},
                    {0, 1, 0},
                    {0, 1, 0}
            },
            {
                    {0, 0, 0},
                    {1, 0, 0},
                    {1, 1, 1}
            },
            {
                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 0}
            }
    };

    JTetrimino() {
        super(J_SHAPES);
    }
}