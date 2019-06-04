package KKS_Rename;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReadXML {
    /*
    Нам дают файл со структорой:
        <DataItem .......... />
        <DataItem .......... />
            ...
        <DataItem .......... />
    Мы должны его разобрать в лист DataItem'ов
     */
    public static ArrayList<DataItem> read(String fileName) {
        ArrayList<DataItem> data = new ArrayList<>();
        DataItem item = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                item = new DataItem();
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("CmdItem")) {
                        Attribute name = startElement.getAttributeByName(new QName("Name"));
                        item.setName(name.getValue());
                        Attribute descr = startElement.getAttributeByName((new QName("Descr")));
                        item.setDescr(descr.getValue());
                        Attribute mapVarName = startElement.getAttributeByName((new QName("MapVarName")));
                        item.setMapVarName(mapVarName.getValue());
                        Attribute typeId = startElement.getAttributeByName((new QName("TypeId")));
                        item.setTypeID(Integer.parseInt(typeId.getValue()));
                        Attribute highBound = startElement.getAttributeByName((new QName("HighBound")));
                        item.setHighBound(Integer.parseInt(highBound.getValue()));
                        Attribute lowBound = startElement.getAttributeByName((new QName("LowBound")));
                        item.setLowBound(Integer.parseInt(lowBound.getValue()));
                        Attribute scale = startElement.getAttributeByName((new QName("Scale")));
                        item.setScale(Integer.parseInt(scale.getValue()));
                        Attribute ioAdr = startElement.getAttributeByName((new QName("IoAdr")));
                        item.setIoAdr(Integer.parseInt(ioAdr.getValue()));
//                        Attribute cycle = startElement.getAttributeByName((new QName("Cycle")));
//                        item.setCycle(Integer.parseInt(cycle.getValue()));
//                        Attribute deadBand = startElement.getAttributeByName((new QName("DeadBand")));
//                        item.setDeadBand(Integer.parseInt(deadBand.getValue()));
                        Attribute MirrorAdr = startElement.getAttributeByName((new QName("MirrorAdr")));
                        item.setMirrorAdr(Integer.parseInt(MirrorAdr.getValue()));
                        Attribute SelectPeriod = startElement.getAttributeByName((new QName("SelectPeriod")));
                        item.setSelectPeriod(Integer.parseInt(SelectPeriod.getValue()));
                        Attribute ExecTimeout = startElement.getAttributeByName((new QName("ExecTimeout")));
                        item.setExecTimeout(Integer.parseInt(ExecTimeout.getValue()));

                        data.add(item);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return data;
    }
}
