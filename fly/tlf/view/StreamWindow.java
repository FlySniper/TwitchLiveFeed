package fly.tlf.view;

import javax.swing.*;

import fly.tlf.controller.AutoScrollerThread;
import fly.tlf.controller.Controller;
import fly.tlf.view.LiveBar;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class StreamWindow {
    private JPanel TopPanel;

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    private JScrollPane ScrollPane;
    private JPanel BottomPanel;

    private int streamerCount = 0;

    private ArrayList<LiveBar> allBars = new ArrayList<>();

    public void setup()
    {
        JFrame frame = new JFrame();
        frame.setSize(1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.add(TopPanel);
        frame.setVisible(true);
        Controller ctl = new Controller(this);
        ctl.execute();
    }
    public void addLiveBar(LiveBar lb,boolean isLive)
    {
        if(allBars.contains(lb))
        {
            allBars.get(allBars.indexOf(lb)).updateLive(isLive);
            return;
        }
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridy = streamerCount;
        BottomPanel.add(lb.getTopPanel(),constraints);
        allBars.add(lb);
        ++streamerCount;
    }
}
