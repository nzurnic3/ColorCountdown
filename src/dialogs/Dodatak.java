package dialogs;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Dodatak extends JFrame{
    private JPanel dodatak;

    public Dodatak (){
        this.setContentPane(dodatak);
    }

    public void resetBackground(){
        dodatak.setBackground(Color.WHITE);
    }

    public void loopBg(Color color, long speed) {

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                dodatak.setBackground(color);
            }
        };

        TimerTask resetTask = new TimerTask() {
            @Override
            public void run() {
                resetBackground();
            }
        };

        timer.scheduleAtFixedRate(timerTask, 0, speed*1000);
        timer.scheduleAtFixedRate(resetTask, speed * 1000, speed * 1000);
    }
}
