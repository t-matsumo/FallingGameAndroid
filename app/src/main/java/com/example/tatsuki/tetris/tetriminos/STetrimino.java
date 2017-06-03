package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * STetrimino
 */
public class STetrimino extends AbstractTetrimino {
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

  public STetrimino() {
    super(S_SHAPES);
  }
}