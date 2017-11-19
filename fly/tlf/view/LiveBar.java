package fly.tlf.view;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LiveBar {
    private JLabel LIVE_IMAGE;
    private JLabel STREAMER_TEXT;

    public JPanel getTopPanel() {
        return TopPanel;
    }

    private JPanel TopPanel;

    public LiveBar(boolean isLive,String streamerText)
    {
        if(!isLive)
        {
            LIVE_IMAGE.setIcon(null);
        }
        STREAMER_TEXT.setText(streamerText);
    }





}
