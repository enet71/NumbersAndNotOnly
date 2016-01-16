package almostgamecompany.square;


import almostgamecompany.main.StaticField;
import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;

public class SquareLow extends Square {
    public SquareLow(Position pos, int time) {
        super(pos, time);
    }

    public SquareLow(Position pos, int time, int minPoint, int maxPoint) {
        super(pos, time, minPoint, maxPoint);
    }

    @Override
    public void press() {
        Sound.playSound(R.raw.slow);
        StaticField.field.timerMainEditTime(-200);
    }

    @Override
    public void remove() {

    }

    @Override
    public void icon() {
        icon = R.drawable.squareslow;
    }
}
