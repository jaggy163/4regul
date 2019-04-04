package HandlersCall;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class writeFile {
    public static void write(String fileName, ArrayList<Handler> handlers) {
        try(FileWriter writer = new FileWriter(fileName, false)) {
            for (int i=0; i<handlers.size(); i++) {
                String line = "";
                Handler handler = handlers.get(i);
                line=handler.getKks() + "(Modul_num:=" + handler.getModulNum() + ", Cn_Num:=" + handler.getCnNum() +
                        ", index:=" + handler.getIndex() + ", iec104:=ADR(" + handler.getIec104() + "), coment:=\"" +
                        handler.getClearComment() + "\");\r\n";
                writer.write(line);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
