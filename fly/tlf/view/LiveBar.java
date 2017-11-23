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
    private Icon prevIcon;

    public LiveBar(boolean isLive,String streamerText)
    {
        prevIcon = LIVE_IMAGE.getIcon();
        if(!isLive)
        {
            LIVE_IMAGE.setIcon(null);
        }
        STREAMER_TEXT.setText(streamerText);
        STREAMER_TEXT.setForeground(Color.white);
    }


    public void updateLive(boolean isLive)
    {
        if(isLive)
        {
            LIVE_IMAGE.setIcon(prevIcon);
        }
        else
        {
            LIVE_IMAGE.setIcon(null);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    @Override
    public String toString() {
        return STREAMER_TEXT.getText();
    }

    @Override
    public int hashCode() {
        return STREAMER_TEXT.getText().hashCode();
    }
}
