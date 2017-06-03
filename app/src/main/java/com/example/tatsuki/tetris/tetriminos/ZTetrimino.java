package com.example.tatsuki.tetris.tetriminos;

/**
 * ZTetrimino
 */
class ZTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] Z_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 0},
      {0, 1, 1}
    },
    {
      {0, 0, 1},
      {0, 1, 1},
      {0, 1, 0}
    }
  };

  ZTetrimino() {
    super(Z_SHAPES);
  }
}