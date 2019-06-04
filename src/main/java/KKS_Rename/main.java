package KKS_Rename;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String fileName = "D:/test.xml";
        ArrayList<DataItem> result;

        result = ReadXML.read(fileName);
        System.out.println(result);
        String[] kks = {"A0NDC11AP001", "A0NDC12AP001", "A0NDC13AP001", "A0NDC14AP001", "A0NDC15AP001", "A0NDC18AP001",
                "A0NDC21AP001", "A0NDC22AP001", "A0NDC23AP001", "A0NDC24AP001", "A0NDC25AP001", "A0NDC26AP001",
                "A0NDC27AP001", "A0NDC42AP001", "A0NDC43AP001", "A0NDK01AP001", "A0NDK02AP001", "A0NDK03AP001", "A0NDK04AP001"};
        result = ChangeList.change(result, kks, result.get(0).getIoAdr());

        WriteXML.write(result, "D:/result.xml");

    }
}
