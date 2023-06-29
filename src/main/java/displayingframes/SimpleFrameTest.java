package displayingframes;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        Logger.getAnonymousLogger().info("thank you");
    }
}

class SimpleFrame
        extends JFrame{

    private final int DEFAULT_WIDTH = 300;
    private final int DEFAULT_HEIGHT = 300;

    public SimpleFrame(){
        setTitle("frame test");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocation(100, 50);
    }
}
