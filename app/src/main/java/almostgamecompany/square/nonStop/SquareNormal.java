package almostgamecompany.square.nonStop;

import almostgamecompany.numbersandnotonly.R;
import almostgamecompany.point.ClassicPoints;
import almostgamecompany.other.Sound;
import almostgamecompany.point.NonStopPoints;
import almostgamecompany.square.Squarable;

public class SquareNormal implements Squarable {
    int point;

    public SquareNormal(int point){
        this.point = point;
    }
    @Override
    public void press() {
        Sound.playSound(R.raw.normal);
        NonStopPoints.add(getPoint());
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

    @Override
    public String toString() {
        return String.valueOf(getPoint());
    }
}
