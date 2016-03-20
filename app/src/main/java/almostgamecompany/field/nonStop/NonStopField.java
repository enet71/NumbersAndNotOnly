package almostgamecompany.field.nonStop;

import android.os.Handler;

import almostgamecompany.field.AbstractField;
import almostgamecompany.form.FormGame;
import almostgamecompany.other.Position;
import almostgamecompany.square.nonStop.SquareNormal;

public class NonStopField extends AbstractField implements NonStop {

    private Position position;
    private int value = 1;

    public NonStopField(int size) {
        super(size);
        createNormalSquare();
        createNormalSquare();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FormGame.openMenu();
            }
        },10000);
    }

    @Override
    public void createNormalSquare() {
        position = getRandomPosition();
        arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(value);
    }

    @Override
    public int getTimeMillis() {
        return 0;
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
        value++;
        createNormalSquare();
    }
}
