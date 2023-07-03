package displayingimages;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.util.logging.Logger;

class ImageFrameTest{

    public static void main(String[] args) {
        Logger.getAnonymousLogger().info("starting");
        EventQueue.invokeLater(() -> {
            var frame = new ImageDisplayFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

public class ImageDisplayFrame
        extends JFrame{

    public ImageDisplayFrame(){

        setTitle("image drawing");
        add(new ImageDisplayComponent());
        pack();
    }
}

class ImageDisplayComponent
        extends JComponent{

    @Override
    public void paintComponent(Graphics graphics) {
        var image = new ImageIcon("./src/main/resources/user_icon.png").getImage();

        for (int i = 0, j = 0; i * 100 <= getWidth() &&
        j * 100 <= getHeight(); i++,j++)
            if (i + j > 0)
                graphics.copyArea(0, 0, 100, 100,
                        i * 100, j *100);
        graphics.drawImage(image, 0, 0, null);


        /*for (int i = 0; i * image.getWidth(null) <= getWidth(); i++)
            for (int j = 0; j * image.getHeight(null) <= getHeight(); i++)
                if (i + j > 0)
                    graphics.copyArea(0, 0, image.getWidth(null), image.getHeight(null),
                            i * image.getWidth(null), j * image.getHeight(null));
        graphics.drawImage(image, 0, 0 , null);*/
    }

    @Override
    public Dimension preferredSize() {
        return new Dimension(
                Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height
        );
    }
}
