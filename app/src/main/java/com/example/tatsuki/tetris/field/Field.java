package com.example.tatsuki.tetris.field;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.tatsuki.tetris.position.Position;
import com.example.tatsuki.tetris.tetriminos.AbstractTetrimino;

/**
 * Field
 */
public class Field {
  /** フィールドの縦のサイズ
   * 可視範囲 + 出現位置の3 マス
   */
  private static final int FIELD_HIGHT = 20 + 3;
  /** フィールドの横のサイズ */
  private static final int FIELD_WIDTH = 10;
  /** フィールド */
  private int[][] field = new int[FIELD_HIGHT][FIELD_WIDTH];

  /** ゲームオーバーの判定 */
  public Boolean isGameOver(AbstractTetrimino tetrimino) {
    return !tetrimino.canMove(field, 0, 1)  && tetrimino.getPosition().getY() == 0;
  }

  public void fixTetrimino(AbstractTetrimino tetrimino) {
    int[][] shape = tetrimino.getShape();
    Position position = tetrimino.getPosition();

    for (int y = 0; y < shape.length; y++) {
      for (int x = 0; x < shape[y].length; x++) {
        if (shape[y][x] == 1) {
          field[position.getY() + y][position.getX() + x] = shape[y][x];
        }
      }
    }
  }

  public void printOut(AbstractTetrimino tetrimino, Canvas canvas) {
    int[][] shape = tetrimino.getShape();
    Position position = tetrimino.getPosition();

    Paint paint = new Paint();
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(Color.BLACK);
    int blockWidth = canvas.getWidth() / 10;
    int blockHight = canvas.getHeight() / 23;

    for (int y = 3; y < field.length; y++) {
      for (int x = 0; x < field[y].length; x++) {
        if (y >= position.getY()
                && y < position.getY() + shape.length
                && x >= position.getX()
                && x < position.getX() + shape[0].length
                && shape[y - position.getY()][x - position.getX()] == 1) {
//                canvas.drawRect(new Rect(x - position.getX() * blockSize, y - position.getY() * blockSize,
//                                         x - position.getX() * blockSize + blockSize, y - position.getY() * blockSize + blockSize), paint);
        } else {
          if (field[y][x] == 0) {
            canvas.drawRect(new Rect(x * blockWidth, y * blockHight,
                                     x * blockWidth + blockWidth, y * blockHight + blockHight), paint);
          }
        }
      }
    }
  }

  public void banish() {
    for (int y = 3; y < field.length; y++) {
      if (canBanish(field[y])) {
        for (int moveY = y; moveY >= 3; moveY--) {
          field[moveY] = field[moveY - 1];
        }
      }
    }
  }

  private Boolean canBanish(int[] row) {
    for (int element : row) {
      if (element == 0) {
        return false;
      }
    }

    return true;
  }

  public int[][] getField() {
    return field;
  }
}