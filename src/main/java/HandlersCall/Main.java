package HandlersCall;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Handler> handlers = new ArrayList<>();

        handlers = readFile.read("D:\\test.txt");
        //System.out.println(handlers);
        writeFile.write("D:\\result.txt", handlers);
    }
}
