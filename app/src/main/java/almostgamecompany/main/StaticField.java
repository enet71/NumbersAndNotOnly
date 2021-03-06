package almostgamecompany.main;


import almostgamecompany.field.Field;
import almostgamecompany.field.classic.ClassicField;
import almostgamecompany.field.nonStop.NonStopField;
import almostgamecompany.form.Menu;
import almostgamecompany.numbersandnotonly.R;

public class StaticField {
    public static boolean pause = false;
    public static boolean combo = false;
    public static boolean start = true;
    public static int speed = 1500;
    public static final int StartSpeed = 1500;
    public static int recordClassic = 0;
    public static int recordNonStop = 0;
    public static int sizeField = 5;
    //public static ClassicField field = new ClassicField(sizeField);
    public static Field field;
    public static Menu menu;
    public static boolean enableSound = true;
    public static int soundImg = R.drawable.sound;

    public static int getSpeedInfo() {
        return 100 - (speed * 100) / StartSpeed;
    }

    public static void setSpeed(int speed) {
        if (speed < 0) {
            StaticField.speed = 0;
        } else if(speed > StaticField.StartSpeed){
            StaticField.speed = StaticField.StartSpeed;
        }else {
            StaticField.speed = speed;
        }
    }
}
