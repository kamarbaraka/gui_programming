package adapterclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTerminator
    extends WindowAdapter {

    private Component parent;

    public WindowTerminator(Component parent){
        this.parent = parent;
    }

    @Override
    public void windowClosing(WindowEvent event) {
        /*EventQueue.invokeLater(() -> {
            System.out.println("in thread");
            JOptionPane.showConfirmDialog(this.parent, "do you really want to exit?");
            System.exit(24);
        });*/
        System.out.println("in thread");
        if (JOptionPane.showConfirmDialog(this.parent, "do you really want to exit?") == 0)
            System.exit(24);
    }
}
