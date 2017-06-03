package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * LTetrimino
 */
public class LTetrimino extends AbstractTetrimino {
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

  public LTetrimino() {
    super(L_SHAPES);
  }
}