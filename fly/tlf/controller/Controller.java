package fly.tlf.controller;

import fly.tlf.view.StreamWindow;

import javax.swing.*;

public class Controller extends SwingWorker<Void,Void> {

    private StreamWindow window;

    public Controller(StreamWindow sw) {
        window = sw;
    }

    @Override
    protected Void doInBackground() throws Exception
    {
        AutoScrollerThread ast = new AutoScrollerThread(window.getScrollPane());
        UpdateTwitchRecords utr = new UpdateTwitchRecords();
        while (true)
        {
            ast.run();
            utr.run();
            try {
                Thread.sleep(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
