package com.example.tatsuki.tetris.tetriminos;

/**
 * STetrimino
 */
class STetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] S_SHAPES = {
    {
      {0, 0, 0},
      {0, 1, 1},
      {1, 1, 0}
    },
    {
      {1, 0, 0},
      {1, 1, 0},
      {0, 1, 0}
    }
  };

  STetrimino() {
    super(S_SHAPES);
  }
}