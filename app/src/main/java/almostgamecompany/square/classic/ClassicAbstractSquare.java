package almostgamecompany.square.classic;


import android.os.Handler;

import java.util.Date;

import almostgamecompany.form.MyApplication;
import almostgamecompany.main.StaticField;
import almostgamecompany.other.Position;
import almostgamecompany.square.Squarable;

public abstract class ClassicAbstractSquare implements Squarable {
    private int time;
    private int point;

    protected Date date;
    private Handler handler;

    public ClassicAbstractSquare(Position pos, int time) {
        this.time = time;
        point = (int) (Math.random() * 200) - 100;
        defaultOptions();
    }

    public ClassicAbstractSquare(Position pos, int time, int minPoint, int maxPoint) {
        this.time = time;
        point = (int) (Math.random() * (maxPoint - minPoint + 1)) + minPoint;
        defaultOptions();
    }

    private void defaultOptions() {
        date = new Date();
        startCountTime();
    }

    private void startCountTime() {
        handler = new Handler(MyApplication.getAppContext().getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = 0;
            }
        }, time);
    }

    public void pause() {
        handler.removeCallbacksAndMessages(null);
    }

    public void unPause(Date currTime) {
        long delay = StaticField.speed - (currTime.getTime() - date.getTime());
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time = 0;
            }
        }, delay);
    }

    public int getTime() {
        return time;
    }

    public int getIcon() {
        return 0;
    }

    public int getPoint() {
        return point;
    }

    public abstract void press();

    public abstract void remove();

}
