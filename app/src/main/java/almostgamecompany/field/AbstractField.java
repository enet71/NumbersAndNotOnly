package almostgamecompany.field;

import almostgamecompany.other.Position;
import almostgamecompany.square.Squarable;
import almostgamecompany.square.classic.ClassicAbstractSquare;

public abstract class AbstractField implements Field {
    public Squarable[][] arraySquare;
    private int size;

    public AbstractField(int size) {
        this.size = size;
        arraySquare = new Squarable[size][size];
    }


    /**
     * Выбирает случайно строку и столбец.
     * Если место с такой позицией занято, выбирает новое значение.
     *
     * @return Позиция, на которой создается куб.
     */
    public Position getRandomPosition() {
        int row;
        int col;
        do {
            row = (int) (Math.random() * size);
            col = (int) (Math.random() * size);
        } while (arraySquare[row][col] != null);
        return new Position(row, col);
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

    public Squarable[][]  getArray(){
        return arraySquare;
    }

}
