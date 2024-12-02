package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();

    public SimpleGUI(final Controller ctrl) {
        final JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        basePanel.add(panel, BorderLayout.SOUTH);
        final JButton printString = new JButton("PRINT STRING");
        final JButton printHistory = new JButton("PRINT HISTORY STRING");
        panel.add(printString, BorderLayout.CENTER);
        panel.add(printHistory, BorderLayout.EAST);
        final JTextArea text = new JTextArea();
        basePanel.add(text, BorderLayout.CENTER); 
        frame.setContentPane(basePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        printString.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ctrl.setNextString(text.getText());
                ctrl.printCurrentString();
            }
        });
        printHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                text.setText(ctrl.historyOfPrintedString().toString());            } 
        });
    }

    public void start() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI(new SimpleController()).start();
    }
}
