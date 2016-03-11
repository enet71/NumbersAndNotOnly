package almostgamecompany.field.classic;

import android.util.Log;

import almostgamecompany.other.Position;
import almostgamecompany.square.Square;

public abstract class AbstractClassicField implements Classic {
    public Square[][] arraySquare;
    private int size;
    private int row;
    private int col;

    public AbstractClassicField(int size) {
        this.size = size;
        arraySquare = new Square[size][size];
    }


    /**
     * Выбирает случайно строку и столбец.
     * Если место с такой позицией занято, выбирает новое значение.
     *
     * @return Позиция, на которой создается куб.
     */
    public Position getRandomPosition() {
        do {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        } while (arraySquare[row][col] != null);
        return new Position(row, col);
    }

    /**
     * Проходит по всему полю. Если квадрат не пустой то проверяет его время.
     * Если время меньше 0 то удаляет его из поля.
     */
    public void removeSquare() {
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare[i].length; j++) {
                if (arraySquare[i][j] != null) {
                    if (arraySquare[i][j].getTime() <= 0) {
                        arraySquare[i][j].remove();
                        arraySquare[i][j] = null;
                    }
                }

            }
        }
    }

    public void press(int row, int col) {
        arraySquare[row][col].press();
        arraySquare[row][col] = null;
    }


    /**
     * Очистить поле
     */
    public void clear() {
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare[i].length; j++) {
                arraySquare[i][j] = null;
            }
        }
    }

}
