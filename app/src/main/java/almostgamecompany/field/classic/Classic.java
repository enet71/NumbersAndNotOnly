package almostgamecompany.field.classic;

import almostgamecompany.field.Field;
import almostgamecompany.square.Square;

public interface Classic extends Field {

    void press(int row, int col);

    void createNormalSquare();

    void createMinusSquare();

    void createSlowSquare();

    void createLoseSquare();

    void createXSquare();

    void createComboSquare();

    Square[][] getArray();
}
