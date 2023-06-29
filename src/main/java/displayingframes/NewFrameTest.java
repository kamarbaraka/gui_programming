package displayingframes;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.jar.Manifest;
import java.util.logging.Logger;

public class NewFrameTest {

    public static void main(String[] args) {
        var logger = Logger.getAnonymousLogger();
        logger.info("entering main");

        EventQueue.invokeLater(() -> {
            var frame = new MainFrame("hello world");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            logger.info("displaying frame");
        });

        logger.info("leaving main");
    }
}

class MainFrame
        extends JFrame{

    private int frameWidth, frameHeight;

    public MainFrame(String title){
        title = Objects.requireNonNullElse(title, "test");

        var toolkit = Toolkit.getDefaultToolkit();
        var screenSize = toolkit.getScreenSize();
        this.frameWidth = screenSize.width;
        this.frameHeight = screenSize.height;

        var imageIcon = new ImageIcon("C:\\Users\\kamar\\Downloads\\user_icon.png").getImage();

        setTitle(title);
        setIconImage(imageIcon);
        setSize(this.frameWidth, this.frameHeight);
    }
}
