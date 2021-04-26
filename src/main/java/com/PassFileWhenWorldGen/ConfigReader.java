import java.io.*;
import java.util.LinkedList;

public class ConfigReader {
    private BufferedReader br;

    public ConfigReader() throws FileNotFoundException {
        this.br = new BufferedReader(new FileReader(new File(ConfigFolder.CONFIG_FOLDER + "/" + ConfigFolder.CONFIG_FILE)));
    }

    public boolean uploadFiles() throws IOException {
        LinkedList<String> fileLines = readFile();
        for(int i = 0; i < fileLines.size(); i++){
            if(fileLines.get(i).contains(Config.OPEN_WORLD_COMMAND)){
                fileLines.get(i).replace(Config.OPEN_WORLD_COMMAND, "");
                fileLines.get(i).replace(" ", "");
                return Boolean.parseBoolean(fileLines.get(i));
            }
        }
        return false;
    }

    public LinkedList<String> getCustomFiles() throws IOException {
        LinkedList<String> fileLines = readFile();
        LinkedList<String> customLines = new LinkedList<>();
        for(int i = 0; i < fileLines.size(); i++){
            if(fileLines.get(i).contains(Config.LOAD_COMMAND)){
                while (fileLines.get(i).contains(Config.STARTING_COMMAND)){
                    i++;
                }
                i++;
                while (fileLines.get(i).contains(Config.ENDING_COMMAND)){
                    if(!fileLines.get(i).replace(" ", "").equals("")){
                        customLines.add(fileLines.get(i));
                    }
                    i++;
                }
                break;
            }
        }
        return customLines;
    }

    private LinkedList<String> readFile() throws IOException {
        LinkedList<String> fileLines = new LinkedList<>();
        try {
            String line;
            while(true){
                line = this.br.readLine();
                if(!line.contains(Config.COMMENT_PREFIX)){
                    fileLines.add(line);
                }
            }
        } catch (EOFException ex) {}
        return fileLines;
    }
}
