package com.example.tatsuki.tetris.tetriminos;

import com.example.tatsuki.tetris.position.Position;

/**
 * AbstractTetrimino
 */
public abstract class AbstractTetrimino {
  /** テトリミノの形の配列 */
  private final int[][][] SHAPES;
  /** 現在使用中のテトリミノの形のインデックス */
  private int usingShapeIndex = 0;
  /** 位置 */
  private Position position = new Position(3, 0);

  public AbstractTetrimino(int[][][] shapes) {
    this.SHAPES = shapes;
  }

  public Boolean canMove(int[][] field, int deltaX, int deltaY) {
    // 次の位置
    final Position nextPosition = new Position(position.getX() + deltaX, position.getY() + deltaY);
    // 現在の形
    int[][] shape = this.SHAPES[usingShapeIndex];

    for (int y = 0; y < shape.length; y++) {
      for (int x = 0; x < shape[y].length; x++) {
        // 壁判定
        if (shape[y][x] == 1
            && (nextPosition.getY() + y >= field.length
            || nextPosition.getX() + x < 0
            || nextPosition.getX() + x >= field[y].length)) {
              return false;
        }

        // 壁以外
        if (shape[y][x] == 1
            && field[nextPosition.getY() + y][nextPosition.getX() + x] == 1) {
          return false;
        }
      }
    }

    return true;
  }

  public void move(int deltaX, int deltaY) {
    position.setX(position.getX() + deltaX);
    position.setY(position.getY() + deltaY);
  }

  public Boolean canTurn(int[][] field, int direction) {
    int [][] nextShape = SHAPES[(SHAPES.length + usingShapeIndex + direction) % SHAPES.length];
    for (int y = 0; y < nextShape.length; y++) {
      for (int x = 0; x < nextShape[y].length; x++) {
        // 壁判定
        if (nextShape[y][x] == 1
            && (position.getY() + y >= field.length
            || position.getX() + x < 0
            || position.getX() + x >= field[y].length)) {
              return false;
        }

        // 壁以外
        if (nextShape[y][x] == 1
            && field[position.getY() + y][position.getX() + x] == 1) {
          return false;
        }
      }
    }

    return true;
  }

  /** 回転する
   * @param direction 1順回転 -1逆回転
   */
  public void turn(int direction) {
    usingShapeIndex = (SHAPES.length + usingShapeIndex + direction) % SHAPES.length;
  }
  
  public Position getPosition() {
    return this.position;
  }

  public int[][] getShape() {
    return this.SHAPES[usingShapeIndex];
  }
}