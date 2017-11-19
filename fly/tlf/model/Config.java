package fly.tlf.model;

import java.io.*;
import java.util.Properties;

public abstract class Config {

    public String FILE_NAME = "";

    private Properties properties = new Properties();

    public Config(String fileName)
    {
        FILE_NAME = fileName;
        File file = new File(fileName);
        try {
            FileReader fr = new FileReader(file);
            properties.load(fr);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find config file "+fileName);
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Could load properties file "+fileName);
        }
    }

    public void putProperty(String key, String value)
    {
        properties.put(key,value);
    }

    public String getProperty(String key)
    {
        return (String)properties.getProperty(key,"");
    }

    public void flush()
    {
        File file = new File(FILE_NAME);
        try {
            FileWriter fw = new FileWriter(file);
            properties.store(fw,"");
        } catch (FileNotFoundException e) {
            System.err.println("Could not find config file "+FILE_NAME);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Could load properties file "+FILE_NAME);
        }
    }
}
