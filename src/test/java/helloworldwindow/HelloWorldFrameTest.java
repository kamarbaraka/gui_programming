package helloworldwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldFrameTest {

    @Test
    public void frameTest(){
        EventQueue.invokeLater(() -> {
            Logger.getAnonymousLogger().log(Level.INFO, "starting frame");
            var frame = new HelloWorldFrame("Hello World");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            System.out.println("on.....");
            frame.setVisible(true);
            Assertions.assertTrue(frame.isVisible());
            Logger.getAnonymousLogger().log(Level.INFO, "frame visible");
        });
    }

}