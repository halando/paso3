import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Properties;

public class Proper {



    Properties pro = new Properties();

    final String PROP_FILE = "config.properties";
    public String readProper(String key) {
        try {
            return tyreadProper(key); 
        } catch (IOException e) {
          String msg = "Hiba! A beállítás beolvasása sikertelen";
          System.err.println(msg);
          return msg;
        }
    }
    public String tyreadProper(String key) 
    throws 
    FileNotFoundException,
     UnsupportedEncodingException,
     IOException{
        FileInputStream fis = new FileInputStream("Config.properties");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        Reader reader = new BufferedReader(isr);
        pro.load(reader);
        String result =pro.getProperty(key);
        return result;
    }
    

    }

