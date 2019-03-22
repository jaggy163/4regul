package KKS_Rename;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String fileName = "D:/test.xml";
        ArrayList<DataItem> result = new ArrayList<>();

        result = ReadXML.read(fileName);
        System.out.println(result);
    }
}
