package fly.tlf.view;

import javax.swing.*;
import fly.tlf.view.LiveBar;

import java.awt.*;

public class StreamWindow {
    private JPanel TopPanel;
    private JScrollPane ScrollPane;
    private JPanel BottomPanel;

    public void setup()
    {
        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.add(TopPanel);
        for (int i = 0; i< 20;++i)
        {
            LiveBar lb = new LiveBar(false, "Text " + i);
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.VERTICAL;
            constraints.gridy = i;
            BottomPanel.add(lb.getTopPanel(),constraints);
        }
        frame.setVisible(true);
    }
}
