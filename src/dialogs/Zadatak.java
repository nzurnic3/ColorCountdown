package dialogs;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.TimerTask;
import java.util.Timer;

public class Zadatak extends JFrame{

    private Color color;
    private JButton colorButton;
    private JButton startCountdownButton;
    private JButton stopButton;
    private JRadioButton onTimeRB;
    private JRadioButton countdownRB;
    private JTextField onTimeTF;
    private JTextField countdownTF;
    private JComboBox<String> speedCB;
    private JLabel colorLBL;
    private JPanel main;
    private int speed;
    private long delay;
    private static Dodatak dodatak;

    public Zadatak() {
        this.setContentPane(main);
    }
    public Color getColor() {
        return color;
    }

    public static void main(String[] args) {

        Pocetna pocetna = new Pocetna();
        pocetna.setSize(600, 300);
        pocetna.setVisible(true);

        Zadatak zadatak = new Zadatak();
        zadatak.setSize(600, 300);
        zadatak.startCountdownButton.setEnabled(false);
        zadatak.stopButton.setEnabled(false);
        zadatak.setVisible(true);

        Timer timer = new java.util.Timer();

        zadatak.colorButton.addActionListener(e -> {

            ColorPicker colorPicker = new ColorPicker();
            colorPicker.setSize(800, 400);
            colorPicker.setVisible(true);

            zadatak.color = colorPicker.getColor();

            if (zadatak.color != null) {
                zadatak.colorLBL.setForeground(zadatak.color);
                zadatak.startCountdownButton.setEnabled(true);
            }

        });

        zadatak.startCountdownButton.addActionListener(e -> {

            zadatak.toggleAllButtonsExceptStop();

            if (zadatak.onTimeRB.isSelected()) {
                LocalTime now = LocalTime.now();
                LocalTime setTime = LocalTime.parse(zadatak.onTimeTF.getText());
                zadatak.delay = Duration.between(now, setTime).toMillis();

            } else if (zadatak.countdownRB.isSelected()) {
                zadatak.delay = Long.parseLong(zadatak.countdownTF.getText()) * 1000;
            }

            Object speed = zadatak.speedCB.getSelectedItem();
            if(speed != null) zadatak.speed = Integer.parseInt((String) speed);


            TimerTask initTask = new TimerTask() {
                @Override
                public void run() {
                    dodatak = new Dodatak();
                    dodatak.setSize(800, 400);
                    dodatak.getContentPane().setBackground(zadatak.getColor());
                    dodatak.setVisible(true);
                    dodatak.loopBg(zadatak.getColor(), zadatak.speed);
                }
            };

            timer.schedule(initTask, zadatak.delay);
        });

        zadatak.stopButton.addActionListener(e -> {

            zadatak.toggleAllButtonsExceptStop();
            dodatak.dispose();

        });

        }

        public void toggleAllButtonsExceptStop() {
            this.colorButton.setEnabled(!this.colorButton.isEnabled());
            this.countdownRB.setEnabled(!this.countdownRB.isEnabled());
            this.countdownTF.setEnabled(!this.countdownTF.isEnabled());
            this.startCountdownButton.setEnabled(!this.startCountdownButton.isEnabled());
            this.speedCB.setEnabled(!this.speedCB.isEnabled());
            this.onTimeRB.setEnabled(!this.onTimeRB.isEnabled());
            this.onTimeTF.setEnabled(!this.onTimeTF.isEnabled());
            this.colorLBL.setEnabled(!this.colorLBL.isEnabled());
            this.stopButton.setEnabled(!this.stopButton.isEnabled());

        }
}