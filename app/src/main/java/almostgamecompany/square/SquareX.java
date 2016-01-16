package almostgamecompany.square;


import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Points;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;

public class SquareX extends Square {
    public SquareX(Position pos, int time) {
        super(pos, time);
    }

    @Override
    public void press() {
        Sound.playSound(R.raw.xsound);
        Points.setX(Points.getX() + 1);
    }

    @Override
    public void remove() {

    }

    @Override
    public void icon() {
        icon = R.drawable.squarex;
    }
}
