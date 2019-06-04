package Handler_Repair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String kks;
        String index;
        String handler;
        Path iec = Paths.get("D:\\java\\iec.txt");
        Path handlers = Paths.get("D:\\java\\handlers.txt");
        Scanner scannerIec = new Scanner(iec, "windows-1251");
        handler = readUsingScanner("D:\\java\\handlers.txt");
        scannerIec.useDelimiter("[\\t\\n]");
        //System.out.println(handler);

        while (scannerIec.hasNext()) {
            kks=scannerIec.next();
            kks=kks.substring(0,kks.length()-4);
            scannerIec.next();
            index=scannerIec.next();
            index = index.trim();
            if (handler.contains(kks + "(")) {
                String str;
                String oldStr;
                int tmp = handler.indexOf(kks + "(");
                str = handler.substring(tmp);
                str = str.substring(0, str.indexOf(");"));
                oldStr = str;
                String indexStr = str.substring(str.indexOf("index"));
                String oldIndexStr;
                indexStr = indexStr.substring(0, indexStr.indexOf(","));
                oldIndexStr = indexStr;
                String numberStr = indexStr.substring(7);
                indexStr = indexStr.replace(numberStr, index);
                String tmpStr = indexStr;
                str = oldStr.replace(oldIndexStr, indexStr);
                handler = handler.replace(oldStr, str);
            }
        }
        System.out.println(handler);
    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), "windows-1251");
        //здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
        String data = scanner.useDelimiter("\\A").next();
        //scanner.close();
        return data;
    }

}
