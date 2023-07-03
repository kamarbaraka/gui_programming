package usingfonts;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FontTest {

    public static void main(String[] args) throws IOException {
        /*var fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        try{
            var fileWriter = new FileWriter("./src/main/resources/fonts.txt");
            var print = new PrintWriter(fileWriter);
            Arrays.stream(fonts).forEach(print::println);
        }
        catch (IOException exception){
            System.out.println("exception");
        }*/


        var componentForDisplay = new JComponent(){
            @Override
            public void paintComponent(Graphics graphics) {
                var graph = (Graphics2D) graphics;
                var font = new Font("Sans Serif", Font.BOLD, 14);
                graph.setFont(font);
                graph.setBackground(Color.BLUE);
                graph.setPaint(Color.MAGENTA);
                graph.drawString("hello world", 250, 250);
            }
        };

        var frame = new JFrame();

        EventQueue.invokeLater(() -> {
            frame.setSize(400, 400);
            frame.add(componentForDisplay);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
