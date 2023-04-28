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
import java.io.File;
import java.io.IOException;

public class XmlGenUtils {
    public XmlGenUtils() {}

    public static void createXML() throws ParserConfigurationException, TransformerException{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("departments");
        document.appendChild(rootElement);

        Element DepartmentElement = document.createElement("department");
        rootElement.appendChild(DepartmentElement);

        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode("HR"));
        DepartmentElement.appendChild(nameElement);

        Element emailElement = document.createElement("email");
        emailElement.appendChild(document.createTextNode("hr@oracle.com"));
        DepartmentElement.appendChild(emailElement);

        Element DepartmentElement2 = document.createElement("department");
        rootElement.appendChild(DepartmentElement2);

        Element nameElement2 = document.createElement("firstname");
        nameElement2.appendChild(document.createTextNode("IT"));
        DepartmentElement2.appendChild(nameElement2);

        Element emailElement2 = document.createElement("email");
        emailElement2.appendChild(document.createTextNode("it@java.com"));
        DepartmentElement2.appendChild(emailElement2);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File("D:\\CodingApps\\JVM Studies\\JavaMidtermPractice\\src\\Departments\\Departments.xml"));

        transformer.transform(domSource, streamResult);
    }
    public static void parseXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("D:\\CodingApps\\JVM Studies\\JavaMidtermPractice\\src\\Departments\\Departments.xml"));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("department");
        Element departmentElement = (Element) nodeList.item(0);
        Element nameElement = (Element) departmentElement.getElementsByTagName("name").item(0);
        Element emailElement = (Element) departmentElement.getElementsByTagName("email").item(0);

        System.out.println(nameElement.getTextContent());
        System.out.println(emailElement.getTextContent());
    }
}
