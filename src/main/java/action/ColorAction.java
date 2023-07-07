package action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * class to test the use of the action interface
 * @author kamar baraka
 * @since 07/07/2023
 */
class ColorActinTest{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new MyFrame("action test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * action listener class
 */
public class ColorAction
    extends AbstractAction {

    private final JPanel buttonPanel;

    /**
     * @param name the name of the action
     * @param icon the icon of the button to perform the action
     * @param color the color to change the panel
     * @param panel the parent panel
     */
    public ColorAction(String name, Icon icon, Color color, JPanel panel){
        putValue(Action.NAME, name);
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, "change panel color to %s ".formatted(name));
        putValue("color", color);
        this.buttonPanel = panel;
    }

    /**
     * @param event the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        var color = (Color) getValue("color");
        this.buttonPanel.setBackground(color);
    }
}

class MyFrame
    extends JFrame{

    /**
     * @param title the title of the frame
     */
    public MyFrame(String title) {
        super(title);

        var panel = new JPanel();

        var components = new Components(panel);
        add(panel);
        pack();
    }
}

class Components
    extends JComponent{

    /**
     * the constructor
     * @param panel the parent panel
     */
    public Components(JPanel panel) {

        var icon = new ImageIcon("./src/main/resources/button_icon.png");
        var redListener = new ColorAction("red", icon, Color.RED, panel);
        var blueListener = new ColorAction("blue", icon, Color.BLUE, panel);
        var greenListener = new ColorAction("green", icon, Color.GREEN, panel);

        var redButton = new JButton(redListener);
        var blueButton = new JButton(blueListener);
        var greenButton = new JButton(greenListener);

        panel.add(redButton);
        panel.add(blueButton);
        panel.add(greenButton);
    }

    /**
     * @return component dimensions
     */
    @Override
    public Dimension preferredSize() {
        return new Dimension(350, 350);
    }
}
