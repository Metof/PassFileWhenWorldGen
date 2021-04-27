package com.PassFileWhenWorldGen;

import java.io.*;
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
        this.copy(roots[roots.length - 1], path);
    }

    public void copy(String fileName ,String path) throws IOException {
        File inputFile = new File("PathCartellaconfig" + "/" + ConfigFolder.CONFIG_FILE_FOLDER + "/" + fileName);
        File outputFile = new File("WorldPath" + "/" + path);
        InputStream finput = new BufferedInputStream(new FileInputStream(inputFile));
        OutputStream foutput = new BufferedOutputStream( new FileOutputStream(outputFile));
        byte[] buffer = new byte[1024 * 500];
        int bytes_letti = 0;
        while((bytes_letti = finput.read(buffer)) > 0)
            foutput.write(buffer, 0, bytes_letti);
        finput.close();
        foutput.close();
    }
}
