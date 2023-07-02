package helloworldwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

class HelloWorld{

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var logger = Logger.getAnonymousLogger();
            logger.log(Level.INFO, "starting app");
            var frame = new HelloWorldFrame("hello world");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logger.log(Level.INFO, "opening window...");
            frame.setVisible(true);
            Toolkit.getDefaultToolkit().beep();
            logger.info("opened");
        });
    }
}

public class HelloWorldFrame
    extends JFrame {

    public HelloWorldFrame(String title){
        setTitle(title);
        add(new HelloWorldComponent());
        pack();
    }
}

class HelloWorldComponent
    extends JComponent{

    private final int DEFAULT_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int DEFAULT_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;

    private final int MESSAGE_X = 300;
    private final int MESSAGE_Y = 200;

    @Override
    public void paintComponent(Graphics graphics) {

        var graphics2d = (Graphics2D) graphics;

        graphics2d.setPaint(Color.RED);
        var rect = new Rectangle2D.Double(100, 100, 300, 250);
        graphics2d.draw(rect);

        graphics2d.setPaint(Color.GREEN);
        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        graphics2d.draw(ellipse);

        graphics2d.setPaint(Color.BLUE);
        var diagonal = new Line2D.Double(new Point2D.Double(100, 100), new Point2D.Double(400, 350));
        graphics2d.draw(diagonal);

        graphics2d.setPaint(Color.PINK);
        var circle = new Ellipse2D.Double();
        var centerX = rect.getCenterX();
        var centerY = rect.getCenterY();
        var radius = 200;
        circle.setFrameFromCenter(new Point2D.Double(centerX, centerY), new Point2D.Double(centerX + radius,
                centerY + radius));
        graphics2d.draw(circle);
    }

    @Override
    public Dimension preferredSize(){
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
