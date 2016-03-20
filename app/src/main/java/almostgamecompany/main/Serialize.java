package almostgamecompany.main;

import java.io.Serializable;

public class Serialize implements Serializable {
    static final long SerialVersionUID = 100000001;
    private int recordClassic;
    private int recordNonStop;

    Serialize() {
        recordClassic = StaticField.recordClassic;
        recordNonStop = StaticField.recordNonStop;
    }

    public void sendData() {
        StaticField.recordClassic = recordClassic;
        StaticField.recordNonStop = recordNonStop;
    }
}
