package almostgamecompany.main;

import java.io.FileNotFoundException;

import java.io.IOException;

import android.content.Context;


import java.io.*;

import almostgamecompany.form.MyApplication;

public class Save {
    public static void save(Context context) {
        FileOutputStream fos;
        try {
            fos = context.openFileOutput("data.dat", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Serialize serialize = new Serialize();
            oos.writeObject(serialize);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(Context context) {
        FileInputStream fis = null;

        try {
            fis = context.openFileInput("data.dat");
        } catch (FileNotFoundException e) {
            save(MyApplication.getAppContext());
            try {
                fis = context.openFileInput("data.dat");
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Serialize serialize = (Serialize) oin.readObject();
            serialize.sendData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
