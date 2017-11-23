package fly.tlf.controller;

import javax.swing.*;

public class AutoScrollerThread implements Runnable{

    private JScrollPane scrollPane;
    public AutoScrollerThread(JScrollPane scrollBar)
    {
        this.scrollPane = scrollBar;
    }

    private int barValue = 0;

    @Override
    public void run()
    {
        JScrollBar bar = scrollPane.getVerticalScrollBar();
        barValue += 2;
        barValue %= bar.getMaximum()+125;
        if(barValue < bar.getValue() && barValue >0)
        {
            barValue = -250;
        }

        if(barValue < 0)
        {
            bar.setValue(0);
        }
        else
        {
            bar.setValue(barValue);
        }
    }
}
