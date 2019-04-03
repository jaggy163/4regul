package KKS_Rename;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteXML {
    /*
    Нам дают лист DataItem'ов и мы должны написать XML файл со структурой:
        <DataItem .......... />
        <DataItem .......... />
            ...
        <DataItem .......... />
     */

    public static void write(ArrayList<DataItem> data, String fileName) {
        XMLOutputFactory factory      = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(
                    new FileWriter(fileName));

            writer.writeStartDocument();
            for (int i=0; i<data.size(); i++) {
                writer.writeStartElement("DataItem");
                writer.writeAttribute("Name", String.valueOf(data.get(i).getName()));
                writer.writeAttribute("Descr", String.valueOf(data.get(i).getDescr()));
                writer.writeAttribute("TypeId", String.valueOf(data.get(i).getTypeID()));
                writer.writeAttribute("CustomTypeId", String.valueOf(0));
                writer.writeAttribute("HighBound", String.valueOf(data.get(i).getHighBound()));
                writer.writeAttribute("LowBound", String.valueOf(data.get(i).getLowBound()));
                writer.writeAttribute("Scale", String.valueOf(data.get(i).getScale()));
                writer.writeAttribute("IoAdr", String.valueOf(data.get(i).getIoAdr()));
                writer.writeAttribute("MapVarName", String.valueOf(data.get(i).getMapVarName()));
                writer.writeAttribute("Cycle", String.valueOf(data.get(i).getCycle()));
                writer.writeAttribute("DeadBand", String.valueOf(data.get(i).getDeadBand()));
                writer.writeEndElement();
                writer.writeCharacters("\r");
            }

            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
