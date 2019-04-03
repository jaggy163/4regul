package HandlersCall;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
    public static ArrayList<Handler> read(String fileName) throws IOException {
        int modulNum=1, cnNum=1, index=1;
        ArrayList<Handler> handlers = new ArrayList<>();
        boolean flag = false;
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        scanner.useDelimiter(System.getProperty("line.separator"));
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.contains(":")) {
                handlers.add(parse(str, modulNum, cnNum, index));
                flag = true;
                cnNum++; index++;
            } else {
                if (flag) { modulNum++; cnNum=1; }
            }
        }

        return handlers;
    }

    public static Handler parse(String line, int modulNum, int cnNum, int index) {
        System.out.println(line);
        String kks, comment, tmp;
        int delim;
        Handler handler = new Handler();

        delim = line.indexOf(":");
        kks=line.substring(0, delim).trim();

        tmp = line.substring(delim);
        delim = tmp.indexOf("//");
        comment = tmp.substring(delim).trim();

        handler.setKks(kks);
        handler.setComment(comment);
        handler.setModulNum(modulNum);
        handler.setCnNum(cnNum);
        handler.setIndex(index);
        return handler;
    }


}
