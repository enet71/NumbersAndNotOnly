package almostgamecompany.field.classic;

import almostgamecompany.field.Field;
import almostgamecompany.square.Squarable;
import almostgamecompany.square.classic.ClassicAbstractSquare;

public interface Classic extends Field {

    void createNormalSquare();

    void createMinusSquare();

    void createSlowSquare();

    void createLoseSquare();

    void createXSquare();

    void createComboSquare();

}
