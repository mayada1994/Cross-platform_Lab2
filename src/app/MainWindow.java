package app;

import app.actions.CheckBoxAction;
import app.actions.MainCheckBoxAction;
import app.checkbox.TristateCheckbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame {

    public MainWindow() {
        final JFrame mainFrame = new JFrame("TristateCheckbox");
        mainFrame.setSize(500, 400);
        mainFrame.setLayout(new GridLayout(4, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(0, 1));

        TristateCheckbox tristateCheckbox = new TristateCheckbox("Main CheckBox");

        final TristateCheckbox box1 = new TristateCheckbox("CheckBox 1");
        final TristateCheckbox box2 = new TristateCheckbox("CheckBox 2");
        final TristateCheckbox box3 = new TristateCheckbox("CheckBox 3");
        final TristateCheckbox box4 = new TristateCheckbox("CheckBox 4");
        List<TristateCheckbox> group = new ArrayList<>();
        group.add(box1);
        group.add(box2);
        group.add(box3);
        group.add(box4);

        tristateCheckbox.addActionListener(new MainCheckBoxAction(tristateCheckbox, group));
        for (TristateCheckbox c : group) {
            c.addActionListener(new CheckBoxAction(tristateCheckbox, group));
        }

        controlPanel.add(tristateCheckbox);
        for (TristateCheckbox t : group) {
            controlPanel.add(t);
        }
        mainFrame.add(controlPanel);

        mainFrame.setVisible(true);
    }

}