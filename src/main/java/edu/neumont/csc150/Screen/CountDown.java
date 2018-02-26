package edu.neumont.csc150.Screen;

import java.util.Timer;
import java.util.TimerTask;

public class CountDown {
    Timer timer = new Timer();
    TimerTask runout = new TimerTask() {
        @Override
        public void run() {
                cancel();
        }
    };
}
