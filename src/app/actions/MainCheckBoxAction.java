package app.actions;

import app.checkbox.TristateCheckbox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainCheckBoxAction extends AbstractAction {
    private final TristateCheckbox tristateCheckbox;
    private final List<TristateCheckbox> group;

    public MainCheckBoxAction(TristateCheckbox tristateCheckbox, List<TristateCheckbox> group) {
        this.tristateCheckbox = tristateCheckbox;
        this.group = group;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TristateCheckbox checkbox = (TristateCheckbox) e.getSource();
        checkbox.changeState();
        for (TristateCheckbox t : group) {
            t.setStateForce(tristateCheckbox.getState());
        }
    }
}
