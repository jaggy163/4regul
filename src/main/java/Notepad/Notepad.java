package Notepad;

import javax.swing.*;
import java.io.*;

public class Notepad
{
    private File currentFile;

    File newFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(null);

        File file = new File(fileChooser.getSelectedFile().getPath());

        try {
            file.createNewFile();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    void saveFile(byte[] data) {
        try {
            if(currentFile != null) {
                currentFile.delete();
                currentFile.createNewFile();
            }
            else
                currentFile = newFile();

            FileOutputStream stream = new FileOutputStream(currentFile);
            stream.write(data);
            stream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    String openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        currentFile = fileChooser.getSelectedFile();
        String line, all="";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentFile));
            while ((line=reader.readLine()) != null) {
                all+=line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return all;
    }

    public File getCurrentFile() {
        return currentFile;
    }
}