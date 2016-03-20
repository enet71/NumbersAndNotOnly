package almostgamecompany.field;

import almostgamecompany.square.Squarable;
import almostgamecompany.square.classic.ClassicAbstractSquare;

public interface Field {
    void removeSquare();
    void clear();
    void restart();
    void pause();

    void press(int row, int col);

    Squarable[][]  getArray();
}
