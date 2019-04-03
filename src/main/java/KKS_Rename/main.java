package KKS_Rename;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String fileName = "D:/test.xml";
        ArrayList<DataItem> result = new ArrayList<>();

        result = ReadXML.read(fileName);
        System.out.println(result);
        String[] kks = {"A0GHA01AA201", "A0GHA02AA201", "A0GHA03AA201", "A0GHA04AA201", "A0NDE01AA201",
        "A0NDE02AA201", "A0NDE03AA201", "A0NDE04AA201", "A0NDE05AA201", "A0NDE11AA201", "A0NDE12AA201",
        "A0NDE13AA201", "A0NDE14AA201", "A0NDE14AA202", "A0NDE14AA203", "A0NDE21AA201", "A0NDE22AA201",
        "A0NDE40AA201", "A0NDE50AA201", "A0NDF30AA201", "A0NDF30AA202", "A0NDF30AA203", "A0NDF30AA204",
        "A0NDF30AA205", "A0NDF34AA201", "A0NDF35AA201", "A0NDK01AA201", "A0NDK01AA202", "A0NDK02AA201",
        "A0NDK02AA202", "A0NDK03AA201", "A0NDK03AA202", "A0NDK04AA201", "A0NDK04AA202", "A0NDK10AA201",
        "A0NDK10AA202", "A0NDK10AA203", "A0NDK11AA201", "A0NDK12AA201", "A0NDK20AA201", "A0NDK20AA201"};
        result = ChangeList.change(result, kks, result.get(0).getIoAdr());

        WriteXML.write(result, "D:/result.xml");

    }
}
