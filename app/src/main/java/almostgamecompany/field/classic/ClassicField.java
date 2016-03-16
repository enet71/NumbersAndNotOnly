package almostgamecompany.field.classic;

import android.os.Handler;

import java.util.Date;
import java.util.TimerTask;

import almostgamecompany.field.AbstractField;
import almostgamecompany.form.MyApplication;
import almostgamecompany.main.StaticField;
import almostgamecompany.other.MyTimer;
import almostgamecompany.other.Points;
import almostgamecompany.other.Position;
import almostgamecompany.square.Squarable;
import almostgamecompany.square.classic.ClassicAbstractSquare;
import almostgamecompany.square.classic.SquareCombo;
import almostgamecompany.square.classic.SquareLose;
import almostgamecompany.square.classic.SquareLow;
import almostgamecompany.square.classic.SquareNormal;
import almostgamecompany.square.classic.SquareX;

public class ClassicField extends AbstractField implements Classic{
    private MyTimer timerSecondary;
    private MyTimer timerRemove;
    private MyTimer timerMain;
    private Position position;
    private Date datePause;

    public ClassicField(int size) {
        super(size);
        timerMain = new MyTimer(StaticField.StartSpeed);
        timerMain.schedules(mainTask());
        timerSecondary = new MyTimer(200);
        timerSecondary.schedules(secondaryTask());
        timerRemove = new MyTimer(100);
        timerRemove.schedules(removeTask());
    }

    @Override
    public void addSquare() {

    }

    @Override
    public void restart() {
        Points.restart();
        clear();
        StaticField.setSpeed(StaticField.StartSpeed);
        timerMain.setDelay(StaticField.StartSpeed);
    }

    @Override
    public void pause() {
        if (!StaticField.pause) {
            datePause = new Date();
            timerMain.cancel();
            timerSecondary.cancel();
            timerRemove.cancel();
            StaticField.pause = true;

            for (Squarable[] anArraySquare : arraySquare) {
                for (Squarable anAnArraySquare : anArraySquare) {
                    if (anAnArraySquare != null) {
                        ((ClassicAbstractSquare)anAnArraySquare).pause();
                    }
                }
            }

        } else {
            long timerMainDelay = timerMain.getDelay();
            long timerEditDelay = timerSecondary.getDelay();
            long timerRemoveDelay = timerRemove.getDelay();

            timerMain = new MyTimer(timerMainDelay);
            timerMain.schedules(mainTask());
            timerSecondary = new MyTimer(timerEditDelay);
            timerSecondary.schedules(secondaryTask());
            timerRemove = new MyTimer(timerRemoveDelay);
            timerRemove.schedules(removeTask());
            StaticField.pause = false;

            for (Squarable[] anArraySquare : arraySquare) {
                for (Squarable anAnArraySquare : anArraySquare) {
                    if (anAnArraySquare != null && datePause != null) {
                        ((ClassicAbstractSquare)anAnArraySquare).unPause(datePause);
                    }
                }
            }
        }
    }

    @Override
    public void createNormalSquare() {

        position = getRandomPosition();
        arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(position,(int) timerMain.getDelay(), 1, 99);
    }

    @Override
    public void createMinusSquare() {
        if ((int) (Math.random() * 2) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(position,(int) (Math.random() * 1000 + 600), -99, -1);
        }
        if ((int) (Math.random() * 3) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(position, (int) (Math.random() * 1000 + 600), -99, -1);
        }
        if ((int) (Math.random() * 4) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareNormal(position, (int) (Math.random() * 1000 + 600), -99, -1);
        }
    }

    @Override
    public void createSlowSquare() {
        if ((int) (Math.random() * 200) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareLow(position, 1000);
        }
    }

    @Override
    public void createLoseSquare() {
        if ((int) (Math.random() * 40) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareLose(position, 3000);
        }
    }

    @Override
    public void createXSquare() {
        if ((int) (Math.random() * 50) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareX(position, 1000);
        }
    }

    @Override
    public void createComboSquare() {
        if ((int) (Math.random() * 150) == 0) {
            position = getRandomPosition();
            arraySquare[position.getRow()][position.getColumn()] = new SquareCombo(position, 1000);
        }
    }

    private void createComboField() {
        pause();
        clear();
        for (int i = 0; i < 10; i++) {
            createNormalSquare();
        }
        for (int i = 0; i < 3; i++) {
            createMinusSquare();
        }

        Handler handler = new Handler(MyApplication.getAppContext().getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int minus = 0;
                for (int i = 0; i < arraySquare.length; i++) {
                    for (int j = 0; j < arraySquare[i].length; j++) {
                        if (arraySquare[i][j] != null) {
                            minus = minus + arraySquare[i][j].getPoint();
                        }
                    }
                }
                Points.addPoints(minus * (-1));
                clear();
                pause();
                StaticField.combo = false;
            }
        }, 2500);
    }

    public void timerMainEditTime(int time) {
        timerMain.setDelay(timerMain.getDelay() - time);
        StaticField.setSpeed(Integer.parseInt(String.valueOf(timerMain.getDelay())));
        long timerMainDelay = timerMain.getDelay();
        timerMain.cancel();
        timerMain = new MyTimer(timerMainDelay);
        timerMain.schedules(mainTask());
    }

    public void timerMainEditTime(int time, long delay) {
        if (!StaticField.combo) {
            timerMain.setDelay(timerMain.getDelay() - time);
            StaticField.setSpeed(Integer.parseInt(String.valueOf(timerMain.getDelay())));
            long timerMainDelay = timerMain.getDelay();
            timerMain.cancel();
            timerMain = new MyTimer(timerMainDelay);
            if (delay > 0) {
                timerMain.schedules(mainTask(), delay);
            } else {
                timerMain.schedules(mainTask(), 0);
            }
        }
    }

    private TimerTask mainTask() {
        return new TimerTask() {
            @Override
            public void run() {
                createNormalSquare();
                createMinusSquare();
            }
        };
    }

    private TimerTask removeTask() {
        return new TimerTask() {
            @Override
            public void run() {
                removeSquare();
            }
        };
    }

    private TimerTask secondaryTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (StaticField.combo) {
                    createComboField();
                } else if (5 > 10) {

                } else {

                    createLoseSquare();
                    createSlowSquare();
                    createXSquare();
                    createComboSquare();
                }
            }
        };
    }

    /**
     * Проходит по всему полю. Если квадрат не пустой то проверяет его время.
     * Если время меньше 0 то удаляет его из поля.
     */
    public void removeSquare() {
        for (int i = 0; i < arraySquare.length; i++) {
            for (int j = 0; j < arraySquare[i].length; j++) {
                if (arraySquare[i][j] != null) {
                    if (((ClassicAbstractSquare)arraySquare[i][j]).getTime() <= 0) {
                        arraySquare[i][j].remove();
                        arraySquare[i][j] = null;
                    }
                }

            }
        }
    }
}
