package com.PassFileWhenWorldGen;

import java.io.*;

public class ConfigFolder {
    public static final String CONFIG_FOLDER = "PassFileWhenWorldGen";
    public static final String CONFIG_FILE = "PassFileWhenWorldGen.cfg";
    public static final String CONFIG_FILE_FOLDER = "custom files";

    public ConfigFolder(){
        checkCreateFolder();
    }

    private void checkCreateFolder(){
        this.checkCreateFolderConfig();
        this.checkCreateFolderFiles();
        try {
            this.createConfigFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createConfigFile() throws IOException {
        File config = new File("PathFolderConfig" + "/" + ConfigFolder.CONFIG_FOLDER + "/" + ConfigFolder.CONFIG_FILE);
        if(!config.exists()){
            config.createNewFile();
            this.writeConfig(config);
        }
    }

    private void writeConfig(File config) throws IOException {
        PrintWriter configWriter = new PrintWriter(config);
        configWriter.println(Config.COMMENT_PREFIX + "this command make the file pass not only during the world creation but every time the world is open !NOT IMPLEMENTS NAW!");
        configWriter.println(Config.COMMENT_PREFIX + "standard false");
        configWriter.println(Config.OPEN_WORLD_COMMAND + " : false");
        configWriter.println();
        configWriter.println(Config.LOAD_COMMAND);
        configWriter.println(Config.STARTING_COMMAND);
        configWriter.println();
        configWriter.println(Config.ENDING_COMMAND);

    }

    private void checkCreateFolderConfig(){
        this.checkFolder("PathFolderConfig" + "/" + ConfigFolder.CONFIG_FOLDER);
    }

    private void checkCreateFolderFiles(){
        this.checkFolder("PathFolderConfig" + "/" + ConfigFolder.CONFIG_FOLDER + "/" + ConfigFolder.CONFIG_FILE_FOLDER);
    }

    private void checkFolder(String path){
        File file = new File(path);
        if(!(file.exists() && file.isFile())){
            file.mkdir();
        }
    }


}
