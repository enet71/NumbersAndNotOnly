package almostgamecompany.point;


import almostgamecompany.form.FormGame;
import almostgamecompany.form.MyApplication;
import almostgamecompany.main.Save;
import almostgamecompany.main.StaticField;

public class ClassicPoints{
    private static int points = 0;
    private static int x = 1;
    private static int maxPoints = 0;

    public static void add(int points) {
        ClassicPoints.points = (ClassicPoints.points + points * x);
        setMaxPoints();
        if (ClassicPoints.points < 0) {
            StaticField.field.restart();
            StaticField.start = true;
            FormGame.openMenu();
        }
    }

    public static int get() {
        return ClassicPoints.points;
    }

    public static void setX(int x) {
        ClassicPoints.x = x;
    }

    public static int getX() {
        return x;
    }

    public static int getMaxPoints() {
        return maxPoints;
    }

    public static void restart() {
        x = 1;
        points = 0;
        maxPoints = 0;
    }

    private static void setMaxPoints() {
        if (points > maxPoints) {
            maxPoints = points;
        }
        if (maxPoints > StaticField.recordClassic) {
            StaticField.recordClassic = maxPoints;
            Save.save(MyApplication.getAppContext());
        }
    }
}
