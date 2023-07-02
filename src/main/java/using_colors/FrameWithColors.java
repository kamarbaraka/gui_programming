package using_colors;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

class FrameWithColorTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new FrameWithColors("frame with colors");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

public class FrameWithColors
        extends JFrame {

    public FrameWithColors(String title){
        setTitle(title);
        add(new ColorsComponent());
        pack();
    }
}

class ColorsComponent
        extends JComponent{

    private final Dimension DEFAULT_DIMENSIONS = new Dimension(
            Toolkit.getDefaultToolkit().getScreenSize().width,
            Toolkit.getDefaultToolkit().getScreenSize().height
    );

    /*public ColorsComponent(){
        setBackground(Color.GRAY);
    }*/

    @Override
    public void paintComponent(Graphics graphics) {
        var graphics2d = (Graphics2D) graphics;

        var circleRect = new Rectangle2D.Double(250, 250, 400, 350);

        graphics2d.setPaint(Color.RED);
        var circle = new Ellipse2D.Double();
        var rectCenterX = circleRect.getCenterX();
        var rectCenterY = circleRect.getCenterY();
        var radius = 125;
        circle.setFrameFromCenter(new Point2D.Double(rectCenterX, rectCenterY),
                new Point2D.Double(rectCenterX + radius, rectCenterY + radius));

        graphics2d.fill(circle);
    }

    @Override
    public Dimension preferredSize(){
        return this.DEFAULT_DIMENSIONS;
    }
}
