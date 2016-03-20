package almostgamecompany.point;

import almostgamecompany.main.StaticField;

public class NonStopPoints{
    private static int points = 0;

    public static void add(int points) {
        NonStopPoints.points += points;
        if(NonStopPoints.points > StaticField.recordNonStop){
            StaticField.recordNonStop = NonStopPoints.points;
        }
    }

    public static void restart() {
        points = 0;
    }

}
