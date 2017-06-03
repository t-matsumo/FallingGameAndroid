package com.example.tatsuki.tetris.position;

/**
 * Position
 */
public class Position {
  /** 横の位置 */
  private int x;
  /** 縦の位置 */
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}