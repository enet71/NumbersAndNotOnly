package almostgamecompany.square;


import almostgamecompany.main.StaticField;
import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;

public class SquareCombo extends Square{

    public SquareCombo(Position pos, int time) {
        super(pos, time);
    }


    public void press() {
        StaticField.combo = true;
        Sound.playSound(R.raw.combo);
    }

    public void remove() {

    }

    @Override
    public void icon() {
        icon = R.drawable.squarebonus;
    }
}
