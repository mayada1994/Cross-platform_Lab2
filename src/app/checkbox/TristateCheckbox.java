package app.checkbox;

import javax.swing.*;

public class TristateCheckbox extends JCheckBox {
    final protected Icon checked = new ImageIcon(ClassLoader.getSystemResource("images/checked.png"));
    final protected Icon indeterminate = new ImageIcon(ClassLoader.getSystemResource("images/indeterminate.png"));
    final protected Icon unchecked = new ImageIcon(ClassLoader.getSystemResource("images/unchecked.png"));
    private int state = 0;

    public int getState() {
        return state;
    }

    public void changeState() {
        if (state == 0) {
            state = 1;
            this.setIcon(checked);
        } else {
            state = 0;
            this.setIcon(unchecked);
        }
    }

    public void setStateForce(int state) {
        this.state = state;
        if (state == 2) {
            this.setIcon(indeterminate);
        } else if (state == 0){
            this.setIcon(unchecked);
        } else
            this.setIcon(checked);
    }

    public TristateCheckbox(String text) {
        super(text);
        this.setIcon(unchecked);
    }
}
