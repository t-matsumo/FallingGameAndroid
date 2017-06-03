package com.example.tatsuki.tetris.tetriminos;

import java.util.Random;

/**
 * TetriminoGenerator
 */
public class TetriminoGenerator {
  /** tetriminosの種類の数 
   * 乱数の生成に使用
  */
  private static final int NUMBER_OF_TETRIMINOS = 7;
  /** 乱数ジェネレータ */
  private static final Random RANDOM = new Random();

  /** テトリミノをランダムに一つ生成して返す */
  public static AbstractTetrimino generateTetrimino() {
    AbstractTetrimino generatedTetrimino = null;
    switch (RANDOM.nextInt(NUMBER_OF_TETRIMINOS)) {
      case 0:
        generatedTetrimino = new ITetrimino();
        break;
      case 1:
        generatedTetrimino = new JTetrimino();
        break;
      case 2:
        generatedTetrimino = new LTetrimino();
        break;
      case 3:
        generatedTetrimino = new OTetrimino();
        break;
      case 4:
        generatedTetrimino = new STetrimino();
        break;
      case 5:
        generatedTetrimino = new TTetrimino();
        break;
      case 6:
        generatedTetrimino = new ZTetrimino();
        break;
      default :
        System.out.println("エラー：generateTetrimino");
        System.exit(1);
    }

    return generatedTetrimino;
  }
}