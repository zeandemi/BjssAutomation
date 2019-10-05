package Managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileManager {

    private Properties properties;
    private final String configFilePath = "ConfigFile.properties";

    public ConfigFileManager(){
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader(configFilePath));
            properties = new Properties();
            try {
                properties.load(bufferedReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw  new RuntimeException("Config file path not found " +configFilePath);
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

}
