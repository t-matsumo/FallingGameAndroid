package com.example.tatsuki.tetris.tetriminos;

import android.support.annotation.NonNull;

import com.example.tatsuki.tetris.block.Block;
import com.example.tatsuki.tetris.position.Position;

/**
 * AbstractTetrimino
 */
public abstract class AbstractTetrimino {
    /**
     * テトリミノの形の配列
     */
    private final Block[][][] SHAPES;
    /**
     * 現在使用中のテトリミノの形のインデックス
     */
    private int usingShapeIndex = 0;
    /**
     * 位置
     */
    private final Position POSITION = new Position(3, 0);

    /** コンストラクタ */
    public AbstractTetrimino(Block[][][] shapes) throws RuntimeException {
        if (shapes == null) {
            throw new RuntimeException("shapes is null");
        }

        this.SHAPES = shapes;
    }

    /** 指定された方向に移動できるかどうかを返す */
    @NonNull
    public Boolean canMove(Block[][] field, int deltaX, int deltaY) throws RuntimeException {
        if (field == null) {
            throw new RuntimeException("field is null");
        }

        // 次の位置
        final Position nextPosition = new Position(this.POSITION.getX() + deltaX, this.POSITION.getY() + deltaY);
        // 現在の形
        Block[][] shape = this.SHAPES[this.usingShapeIndex];

        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                // 壁判定
                if (shape[y][x] != null
                        && (nextPosition.getY() + y >= field.length
                        || nextPosition.getX() + x < 0
                        || nextPosition.getX() + x >= field[y].length)) {
                    return false;
                }

                // 壁以外
                if (shape[y][x] != null
                        && field[nextPosition.getY() + y][nextPosition.getX() + x] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public void move(int deltaX, int deltaY) {
        POSITION.setX(POSITION.getX() + deltaX);
        POSITION.setY(POSITION.getY() + deltaY);
    }

    @NonNull
    public Boolean canTurn(Block[][] field, int direction) {
        Block[][] nextShape = SHAPES[(SHAPES.length + usingShapeIndex + direction) % SHAPES.length];
        for (int y = 0; y < nextShape.length; y++) {
            for (int x = 0; x < nextShape[y].length; x++) {
                // 壁判定
                if (nextShape[y][x] != null
                        && (POSITION.getY() + y >= field.length
                        || POSITION.getX() + x < 0
                        || POSITION.getX() + x >= field[y].length)) {
                    return false;
                }

                // 壁以外
                if (nextShape[y][x] != null
                        && field[POSITION.getY() + y][POSITION.getX() + x] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 回転する
     *
     * @param direction 1順回転 -1逆回転
     */
    public void turn(int direction) {
        usingShapeIndex = (SHAPES.length + usingShapeIndex + direction) % SHAPES.length;
    }

    public Position getPosition() {
        return this.POSITION;
    }

    public Block[][] getShape() {
        return this.SHAPES[usingShapeIndex];
    }
}