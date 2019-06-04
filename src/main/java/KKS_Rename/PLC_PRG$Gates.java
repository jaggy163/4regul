package KKS_Rename;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PLC_PRG$Gates {
    public static void main(String[] args) throws IOException {
        String plate;
        String plateKks = "A0NDC11AP001";
        String result="";
        String[] kkss = {"A0NDC11AP001", "A0NDC12AP001", "A0NDC13AP001", "A0NDC14AP001", "A0NDC15AP001", "A0NDC18AP001",
                "A0NDC21AP001", "A0NDC22AP001", "A0NDC23AP001", "A0NDC24AP001", "A0NDC25AP001", "A0NDC26AP001",
                "A0NDC27AP001", "A0NDC42AP001", "A0NDC43AP001", "A0NDK01AP001", "A0NDK02AP001", "A0NDK03AP001", "A0NDK04AP001"};
        Path gatePath = Paths.get("D:\\java\\gate.txt");
        Scanner gateSc = new Scanner(gatePath, "windows-1251");
        plate = gateSc.useDelimiter("\\A").next();

        for (int i=0; i<kkss.length; i++) {
            result += plate.replaceAll(plateKks, kkss[i]);
            result += "\n\r";
        }

        System.out.println(result);
    }
}
