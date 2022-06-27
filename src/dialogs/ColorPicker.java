package dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPicker extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JColorChooser tcc;
    private  Color color;

    public ColorPicker() {
        this.setContentPane(contentPane);
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
        setColor();
        dispose();
    }

    private void onCancel() {
        getColor();
        dispose();
    }

//    public static void main(String[] args) {
//        dialogs.ColorPicker dialog = new dialogs.ColorPicker();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(){
        this.color = tcc.getColor();
    }
}
