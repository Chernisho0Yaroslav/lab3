package PO74.Tokmakov.wdad.learn.xml;

import PO74.Tokmakov.wdad.resources.configuration.PreferencesManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class TestXmlTask {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException, XMLStreamException {
        XmlTask xmlTask= new XmlTask();
        String name="Министерство смеха";
        String firstname="Светлана";
        String secondname="Кот";
        System.out.println(xmlTask.salaryAverage());
        System.out.println(xmlTask.salaryAverage(name));

        // xmlTask.setJobTitile(firstname, secondname, "head");
        // xmlTask.fireEmployee("Glen1", "Sand1");
        //xmlTask.setSalary(firstname, secondname, 20000);
       // xmlTask.setJobTitile(firstname, secondname, "manager");

        // System.out.println(PreferencesManager.getInstance().getProperties());


    }
}
