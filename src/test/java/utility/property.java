package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class property {

    Properties prop;

    public property(){
        File src=new File("C:\\Users\\dsahay\\IdeaProjects\\Assignment1\\src\\test\\config\\config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        }
        catch(Exception e){
            System.out.println("Unable to load config file");
        }
    }

    public String getBrowser(){
        return prop.getProperty("Browser");
    }
    public String getUrl(){
        return prop.getProperty("url");
    }
    public String getUsername(){
        return prop.getProperty("username");
    }
    public String getPassword(){
        return prop.getProperty("password");
    }
    public String getTag(){
        return prop.getProperty("tag");
    }
}
