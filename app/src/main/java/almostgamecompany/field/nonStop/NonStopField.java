package almostgamecompany.field.nonStop;

import almostgamecompany.field.AbstractField;
import almostgamecompany.other.Position;
import almostgamecompany.square.nonStop.SquareNormal;

public class NonStopField extends AbstractField implements NonStop {

    private Position position;

    public NonStopField(int size) {
        super(size);
        createNormalSquare();
        createNormalSquare();
    }

    @Override
    public void createNormalSquare() {
        position = getRandomPosition();
        arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(99);
    }

    @Override
    public void addSquare() {

    }

    @Override
    public void removeSquare() {

    }

    @Override
    public void restart() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void press(int row, int col) {
        super.press(row, col);
        createNormalSquare();
    }
}
