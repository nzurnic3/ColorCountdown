package dialogs;

import javax.swing.*;
import java.awt.event.*;

public class Pocetna extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private static Zadatak zadatak;

    public Pocetna() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {

        dispose();
    }

    private void onCancel() {
        dispose();
        System.exit(0);
    }

//    public static void main(String[] args) {
//        dialogs.Pocetna dialog = new dialogs.Pocetna();
//        dialog.pack();
//        dialog.setSize(400,200);
//        dialog.setVisible(true);
//
//        System.exit(0);
//    }
}
