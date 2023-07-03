package eventhandling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ButtonFrameTest{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ButtonFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

public class ButtonFrame
    extends JFrame  {

    private JPanel buttonPanel;
    private final Dimension DEAFAULT_DIMENSION = new Dimension(400, 400);

    public ButtonFrame(){
        setSize(DEAFAULT_DIMENSION);

        var redButton = new JButton("red");
        var greenButton = new JButton("green");
        var blueButton = new JButton("blue");

        var redButtonListener = new ButtonHandler(Color.RED);
        var greenButtonListener = new ButtonHandler(Color.GREEN);
        var blueButtonListener = new ButtonHandler(Color.BLUE);

        redButton.addActionListener(redButtonListener);
        greenButton.addActionListener(greenButtonListener);
        blueButton.addActionListener(blueButtonListener);

        this.buttonPanel = new JPanel();
        this.buttonPanel.add(redButton);
        this.buttonPanel.add(greenButton);
        this.buttonPanel.add(blueButton);

        add(this.buttonPanel);
    }

    private class ButtonHandler
        implements ActionListener{

        private Color color;
        public ButtonHandler(Color color){
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(color);
        }
    }

}
