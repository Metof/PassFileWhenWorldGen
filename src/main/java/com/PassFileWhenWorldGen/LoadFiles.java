package com.PassFileWhenWorldGen;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class LoadFiles {

    public LoadFiles(LinkedList<String> fileToCustom) throws IOException {
        new ConfigFolder();
        for(int i = 0; i < fileToCustom.size(); i++){
            loadFile(fileToCustom.get(i));
        }
    }

    private void loadFile(String path) throws IOException {
        String[] roots = path.split("/");
        File file;
        String root = "";
        for(int i = 0; i < roots.length - 1; i++){
            root += roots[i];
            file = new File(root);
            if(!file.exists()){
                file.mkdir();
            }
            root += "/";
        }
        file = new File(path);
        file.createNewFile();
    }
}
