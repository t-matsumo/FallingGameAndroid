package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * ITetrimino
 */
public class ITetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] I_SHAPES = {
    {
      {0, 0, 0, 0},
      {1, 1, 1, 1},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
    },
    {
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 1, 0}
    }
  };

  public ITetrimino() {
    super(I_SHAPES);
  }
}