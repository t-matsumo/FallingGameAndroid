package com.example.tatsuki.tetris.tetriminos;

/**
 * LTetrimino
 */
class LTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] L_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 1},
      {1, 0, 0}
    },
    {
      {0, 1, 0},
      {0, 1, 0},
      {0, 1, 1}
    },
    {
      {0, 0, 0},
      {0, 0, 1},
      {1, 1, 1}
    },
    {
      {1, 1, 0},
      {0, 1, 0},
      {0, 1, 0}
    }
  };

  LTetrimino() {
    super(L_SHAPES);
  }
}