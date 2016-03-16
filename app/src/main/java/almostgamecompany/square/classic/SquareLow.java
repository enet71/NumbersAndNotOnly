package almostgamecompany.square.classic;


import almostgamecompany.field.classic.ClassicField;
import almostgamecompany.main.StaticField;
import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;

public class SquareLow extends ClassicAbstractSquare {
    public SquareLow(Position pos, int time) {
        super(pos, time);
    }

    public SquareLow(Position pos, int time, int minPoint, int maxPoint) {
        super(pos, time, minPoint, maxPoint);
    }

    @Override
    public void press() {
        Sound.playSound(R.raw.slow);
        ((ClassicField) StaticField.field).timerMainEditTime(-200);
        //StaticField.field.timerMainEditTime(-200);
    }

    @Override
    public void remove() {

    }

    @Override
    public int getIcon() {
        return R.drawable.squareslow;
    }
}
