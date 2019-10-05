package Managers;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileManager configFileManager;

    private FileReaderManager() {

    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileManager getConfigReader() {
        return (configFileManager == null) ? new ConfigFileManager() : configFileManager;
    }


}
