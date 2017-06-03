package com.example.tatsuki.tetris.tetriminos;

/**
 * TTetrimino
 */
class TTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] T_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 1},
      {0, 1, 0}
    },
    {
      {0, 1, 0},
      {0, 1, 1},
      {0, 1, 0}
    },
    {
      {0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    },
    {
      {0, 1, 0},
      {1, 1, 0},
      {0, 1, 0}
    }
  };

  TTetrimino() {
    super(T_SHAPES);
  }
}