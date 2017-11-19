package fly.tlf.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StreamersList{

    public ArrayList<String> streamerNames = new ArrayList<>();

    public StreamersList()
    {
        File f = new File("Streamers.conf");
        try {
            f.createNewFile();
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            for(String line = br.readLine(); line != null; line = br.readLine())
            {
                streamerNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> getStreamers()
    {
        return streamerNames;
    }

}
