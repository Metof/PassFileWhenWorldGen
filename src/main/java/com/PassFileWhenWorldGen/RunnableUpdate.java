package com.PassFileWhenWorldGen;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunnableUpdate{
    public static void MyRun() {
        try {
            ConfigReader cr = new ConfigReader();
            new LoadFiles(cr.getCustomFiles());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
