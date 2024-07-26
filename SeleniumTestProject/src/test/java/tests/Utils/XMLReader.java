package tests.Utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse("files/data.xml");

      document.getDocumentElement().normalize();

      NodeList nList = document.getElementsByTagName("food");

      for (int temp = 0; temp < nList.getLength(); temp++) {
          Node nNode = nList.item(temp);
          System.out.println("\nCurrent Element: " + nNode.getNodeName());

          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              System.out.println("Element Attribute: " + eElement.getAttribute("name"));
              System.out.println("Element Value: " + eElement.getElementsByTagName("price")
                               .item(0)
                               .getTextContent());
          }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

 
