package eventhandling;

import adapterclasses.WindowTerminator;

import javax.swing.*;
import java.awt.*;

class ConciseButtonFrameTest{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ConciseButtonFrame();
            frame.addWindowListener(new WindowTerminator(frame));
            frame.setVisible(true);
        });
    }
}

public class ConciseButtonFrame
    extends JFrame {

    private JPanel buttonPanel;

    public ConciseButtonFrame(){
        setSize(400, 400);
        setTitle("concise button frame");
        this.buttonPanel = new JPanel();
        add(this.buttonPanel);

        makeButton("red", Color.RED);
        makeButton("green", Color.GREEN);
        makeButton("blue", Color.BLUE);
        makeButton("magenta", Color.MAGENTA);
    }

    public void makeButton(String label, Color backgroundColor){
        var button = new JButton(label);
        this.buttonPanel.add(button);
        button.addActionListener(event -> {
            this.buttonPanel.setBackground(backgroundColor);
        });
    }

}
