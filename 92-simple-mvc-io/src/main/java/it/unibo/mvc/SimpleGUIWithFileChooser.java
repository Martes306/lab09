package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final File DESKTOP = new File(System.getProperty("user.home") + File.separator + "Desktop");
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 4;

    public SimpleGUIWithFileChooser(final Controller ctrl) {
        // base panel
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        // panel on set on north of base panel
        final JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new BorderLayout());
        // text field for show the choosen file
        final JTextField showFileChoosen = new JTextField("PRESS ON BUTTON AND SELECT THE FILE");
        showFileChoosen.setEditable(false);
        panelNorth.add(showFileChoosen, BorderLayout.CENTER);
        // button for oper file chooser
        final JButton fileChooserButton = new JButton("SELECT THE FILE");
        panelNorth.add(fileChooserButton, BorderLayout.LINE_END);
        panel.add(panelNorth, BorderLayout.NORTH);
        // text area for write the text
        final JTextArea fieldForText = new JTextArea();
        panel.add(fieldForText, BorderLayout.CENTER);
        // button for save the text in the file
        final JButton saveButton = new JButton("SAVE");
        panel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // save the text on file
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    ctrl.writeFile(fieldForText.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // open the file choose and show the choosen on text field
        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                int fileChooserValue = fileChooser.showOpenDialog(saveButton);
                fileChooser.setCurrentDirectory(DESKTOP);
                switch (fileChooserValue) {
                    case JFileChooser.APPROVE_OPTION:
                        ctrl.setFile(fileChooser.getSelectedFile());
                        showFileChoosen.setText(ctrl.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                    JOptionPane.showMessageDialog(fileChooser, "Un errore spaca tutto");
                        break;
                }

            }
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
}
