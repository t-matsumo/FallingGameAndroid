package com.example.tatsuki.tetris.field;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.tatsuki.tetris.block.Block;
import com.example.tatsuki.tetris.position.Position;
import com.example.tatsuki.tetris.tetriminos.AbstractTetrimino;

/**
 * Field
 */
public class Field {
    /**
     * フィールドの縦のサイズ
     * 可視範囲 + 出現位置の3 マス
     */
    private static final int FIELD_HIGHT = 20 + 3;
    /**
     * フィールドの横のサイズ
     */
    private static final int FIELD_WIDTH = 10;
    /**
     * フィールド
     */
    private Block[][] field = new Block[FIELD_HIGHT][FIELD_WIDTH];

    /**
     * ゲームオーバーの判定
     */
    public Boolean isGameOver(AbstractTetrimino tetrimino) {
        return !tetrimino.canMove(field, 0, 1) && tetrimino.getPosition().getY() == 0;
    }

    public void fixTetrimino(AbstractTetrimino tetrimino) {
        Block[][] shape = tetrimino.getShape();
        Position position = tetrimino.getPosition();

        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] != null) {
                    field[position.getY() + y][position.getX() + x] = shape[y][x];
                }
            }
        }
    }

    public void printOut(AbstractTetrimino tetrimino, Canvas canvas) {
        Block[][] shape = tetrimino.getShape();
        Position position = tetrimino.getPosition();

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        int blockWidth = canvas.getWidth() / 10;
        int blockHight = canvas.getHeight() / 23;

        for (int y = 3; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                if (y >= position.getY()
                        && y < position.getY() + shape.length
                        && x >= position.getX()
                        && x < position.getX() + shape[0].length
                        && shape[y - position.getY()][x - position.getX()] != null) {
                    paint.setColor(shape[y - position.getY()][x - position.getX()].getColorInt());
                    canvas.drawRect(new Rect(x * blockWidth + 1, y * blockHight + 1,
                            x * blockWidth + blockWidth - 1, y * blockHight + blockHight - 1), paint);
                } else {
                    if (field[y][x] != null) {
                        paint.setColor(field[y][x].getColorInt());
                        canvas.drawRect(new Rect(x * blockWidth + 1, y * blockHight + 1,
                                x * blockWidth + blockWidth - 1, y * blockHight + blockHight - 1), paint);
                    } else {
                        paint.setColor(Color.BLACK);
                        canvas.drawRect(new Rect(x * blockWidth + 1, y * blockHight + 1,
                                x * blockWidth + blockWidth - 1, y * blockHight + blockHight - 1), paint);
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

    private Boolean canBanish(Block[] row) {
        for (Block element : row) {
            if (element == null) {
                return false;
            }
        }

        return true;
    }

    public Block[][] getField() {
        return field;
    }
}