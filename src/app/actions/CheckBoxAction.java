package app.actions;

import app.checkbox.TristateCheckbox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class CheckBoxAction extends AbstractAction {
    private final TristateCheckbox tristateCheckbox;
    private final List<TristateCheckbox> group;

    public CheckBoxAction(TristateCheckbox tristateCheckbox, List<TristateCheckbox> group) {
        this.tristateCheckbox = tristateCheckbox;
        this.group = group;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean allChecked = false;
        boolean partiallyCheck;

        TristateCheckbox box = (TristateCheckbox) e.getSource();
        box.changeState();
        for (TristateCheckbox t : group) {
            if (t.getState() == 0) {
                allChecked = false;
                break;
            } else {
                allChecked = true;
            }
        }

        boolean noOneHaveStateOne = true;
        for (TristateCheckbox t : group) {
            if (t.getState() == 1) {
                noOneHaveStateOne = false;
                break;
            }
        }
        partiallyCheck = !noOneHaveStateOne;

        if (allChecked) {
            tristateCheckbox.setStateForce(1);
        } else if (partiallyCheck) {
            tristateCheckbox.setStateForce(2);
        } else {
            tristateCheckbox.setStateForce(0);
        }
    }
}
