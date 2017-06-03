package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * OTetrimino
 */
public class OTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
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

  public OTetrimino() {
    super(O_SHAPES);
  }
}