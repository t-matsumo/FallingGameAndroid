package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * ZTetrimino
 */
public class ZTetrimino extends AbstractTetrimino {
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

  public ZTetrimino() {
    super(Z_SHAPES);
  }
}