package PO74.Tokmakov.wdad.learn.xml;

import org.jdom2.input.DOMBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlTask {
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder = factory.newDocumentBuilder();
    private Document document = builder.parse(new File("C:/Users/Admin/IdeaProjects/starting-monkey-to-human-path/src/PO74/Tokmakov/wdad/learn/xml/organizations.xml"));
    private NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
    private XPathFactory xPathFactory = XPathFactory.newInstance();
    private XPath xPath = xPathFactory.newXPath();


    org.jdom2.Element root;
    List<org.jdom2.Element> nodesDepartmentElements;
    XMLOutputter xmlOut;
    org.jdom2.Document jdomDocument;
    String fileName = "";

    public XmlTask() throws IOException, SAXException, ParserConfigurationException {
        fileName = "C:/Users/Admin/IdeaProjects/starting-monkey-to-human-path/src/PO74/Tokmakov/wdad/learn/xml/organizations.xml";
        jdomDocument = createJDOMusingDOMParser(fileName);
        xmlOut = new XMLOutputter();
        org.jdom2.Element root = jdomDocument.getRootElement();
        try {
            nodesDepartmentElements = root.getChildren("department");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static org.jdom2.Document createJDOMusingDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //создаем DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        documentBuilder = dbFactory.newDocumentBuilder();
        Document doc = documentBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();

        return domBuilder.build(doc);

    }


    //возвращает среднюю заработную плату сотрудников организации.
    public double salaryAverage() throws  XPathExpressionException {
        NodeList list = (NodeList) xPath.evaluate("/organization/department/employee/salary", document, XPathConstants.NODESET);
        double summ = 0;
        int count = 0;
        count = Integer.parseInt(xPath.evaluate("count(/organization/department/employee/salary)", document));
        for (int i = 0; i < list.getLength(); i++) {
            summ += Integer.parseInt(list.item(i).getTextContent());
        }
        System.out.println();
        return summ / count;
    }

    //возвращает среднюю заработную плату сотрудников заданного департамента.
    public double salaryAverage(String departmentName) throws  XPathExpressionException {
        NodeList list = (NodeList) xPath.evaluate("/organization/department[@name='" + departmentName + "']/employee/salary", document, XPathConstants.NODESET);
        double summ = 0;
        int count = 0;
        count = Integer.parseInt(xPath.evaluate("count(/organization/department[@name='" + departmentName + "']/employee/salary)", document));
        for (int i = 0; i < list.getLength(); i++) {
            summ += Integer.parseInt(list.item(i).getTextContent());

        }
        return summ / count;
    }

    //изменяет должность сотрудника.
    public void setJobTitile(String firstName, String secondName, String newJobTitle) throws  TransformerException {
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            if (employee.getAttribute("firstname").equals(firstName)
                    && employee.getAttribute("secondname").equals(secondName)) {
                //System.out.println(employee.getAttribute("firstname") + "   " + employee.getAttribute("secondname"));
                Element jobtitle = (Element) employee.getElementsByTagName("jobtitle").item(0);
                jobtitle.setAttribute("value", newJobTitle);

                transformer();
                return;
            }

        }

    }
    // изменяет размер заработной платы сотрудника.
    public void setSalary(String firstName, String secondName, int newSalary)throws   TransformerException {

        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            if (employee.getAttribute("firstname").equals(firstName)
                    && employee.getAttribute("secondname").equals(secondName)) {
                System.out.println(employee.getAttribute("firstname") + "   " + employee.getAttribute("secondname"));
                Element jobtitle = (Element) employee.getElementsByTagName("salary").item(0);
                jobtitle.setTextContent(Integer.toString(newSalary));

                transformer();
                return;

            }

        }
    }



    //удаляющий информацию о сотруднике.
    public void fireEmployee(String firstName, String secondName) throws  TransformerException {
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Element employee = (Element) employeeElements.item(i);
            if (employee.getAttribute("firstname").equals(firstName)
                    && employee.getAttribute("secondname").equals(secondName)) {
                employee.getParentNode().removeChild(employee);
                transformer();
                return;
            }
        }
    }

    //добавить департамент

    public void add(Department department) throws IOException {
        org.jdom2.Element dep = new org.jdom2.Element("department");
        dep.setAttribute("name", department.getName());
        List<Employee> employees = (List<Employee>) department.getEmployees();
        for(Employee employee :employees)
        {
            org.jdom2.Element empNode = new org.jdom2.Element("employee");
            empNode.setAttribute("firstname", employee.getFName());
            empNode.setAttribute("secondname", employee.getSName());
            org.jdom2.Element childHireDate =  new org.jdom2.Element("hiredate");
            org.jdom2.Element childSalary =  new org.jdom2.Element("salary");
            childSalary.setText(String.valueOf(employee.getSalary()));
            org.jdom2.Element childJobtitle =  new org.jdom2.Element("jobtitle");
            childJobtitle.setAttribute("value",employee.getJobTitle());
            empNode.addContent(childHireDate);
            empNode.addContent(childSalary);
            empNode.addContent(childJobtitle);
            dep.addContent(empNode);
        }
        org.jdom2.Element root = jdomDocument.getRootElement();
        root.addContent(dep);
        xmlOut.setFormat(Format.getPrettyFormat());
        xmlOut.output(jdomDocument, new FileWriter(fileName));
    }



    private void transformer() throws TransformerException {
        TransformerFactory factory1 = TransformerFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        Transformer transformer = factory1.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(document.getDocumentURI()));
    }

}





