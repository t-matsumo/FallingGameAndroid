package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * TTetrimino
 */
public class TTetrimino extends AbstractTetrimino {
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

  public TTetrimino() {
    super(T_SHAPES);
  }
}