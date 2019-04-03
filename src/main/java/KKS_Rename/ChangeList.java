package KKS_Rename;

import java.util.ArrayList;

public class ChangeList {
    /*
    Нам дают лист DataItem'ов в конструкторе.
    А потом методами меняют нужные атрибуты
     */
    public static ArrayList<DataItem> change(ArrayList<DataItem> data, String[] kkss, int startAdr) {
        ArrayList<DataItem> result = new  ArrayList<DataItem>();
        for (int i=0; i< kkss.length; i++) {
            for (int j=0; j<data.size(); j++) {
                DataItem tmp;
                int adr;
                String name;
                String mapVarName;
                tmp=data.get(j);
                adr = tmp.getIoAdr();
                adr = startAdr; startAdr++;
                name = tmp.getName();
                mapVarName = tmp.getMapVarName();
                name = kkss[i] + name.substring(kkss[i].length());
                mapVarName = kkss[i] + mapVarName.substring(kkss[i].length());
                tmp.setIoAdr(adr);
                tmp.setName(name);
                tmp.setMapVarName(mapVarName);
                result.add(new DataItem(tmp));
            }
        }
        return result;
    }
}
