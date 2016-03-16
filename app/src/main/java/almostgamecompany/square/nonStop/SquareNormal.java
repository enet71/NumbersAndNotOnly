package almostgamecompany.square.nonStop;

import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.other.Points;
import almostgamecompany.other.Position;
import almostgamecompany.other.Sound;
import almostgamecompany.square.Squarable;

public class SquareNormal implements Squarable {
    int point;

    public SquareNormal(int point){
        this.point = point;
    }
    @Override
    public void press() {
        Sound.playSound(R.raw.normal);
        Points.addPoints(getPoint());
    }

    @Override
    public void remove() {

    }

    @Override
    public int getIcon() {
        return R.drawable.squarenormal;
    }

    @Override
    public int getPoint() {
        return point;
    }

}
