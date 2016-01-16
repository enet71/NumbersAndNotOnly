package almostgamecompany.square;

import almostgamecompany.form.FormGame;
import almostgamecompany.main.StaticField;
import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;

public class SquareLose extends Square {

    public SquareLose(Position pos, int time) {
        super(pos, time);
    }

    @Override
    public void press() {
        Sound.playSound(R.raw.lose);
        StaticField.field.restart();
        StaticField.start = true;
        FormGame.openMenu();
    }

    @Override
    public void remove() {

    }

    @Override
    public void icon() {
        icon = R.drawable.squarelose;
    }
}
