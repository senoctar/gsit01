package org.gsit.bunnyrace;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class BunnyFrame extends JFrame {

    public BunnyFrame(List<RabbitRunnable> rabbits) throws IOException {
        JPanel pane = buildPane(rabbits);
        add(pane);
    }

    private JPanel buildPane(List<RabbitRunnable> rabbits) throws IOException {
        final BufferedImage buffer = new BufferedImage(900, 700, BufferedImage.TYPE_INT_RGB);
        final BufferedImage image = ImageIO.read(BunnyRaceMain.class.getResourceAsStream("/bunny-clipart-black-and-white-2.jpg"));

        JPanel pane = new JPanel() {
            @Override
            public void paint(Graphics g) {
                //painted by render thread
            }
        };

        new Thread("RenderThread") {
            @Override
            public void run() {
                while (true) {
                    if (pane.getGraphics() != null) {
                        drawSceneInBuffer();
                        pane.getGraphics().drawImage(buffer, 0, 0, null);
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }

            private void drawSceneInBuffer() {
                Graphics graphics = buffer.getGraphics();
                graphics.setColor(Color.WHITE);
                graphics.fillRect(0, 0, 900, 700);

                for (int i = 0; i < rabbits.size(); i++) {
                    graphics.drawImage(image, rabbits.get(i).getDistance(), i*130, null);
                }
            }
        }.start();

        return pane;
    }


    public void showBunnies() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 700);
        setVisible(true);
    }

}
