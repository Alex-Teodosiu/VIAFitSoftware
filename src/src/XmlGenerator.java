import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlGenerator extends VIAFitSystem {

  public void generateXml() {

    try {

      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

      // root elements
      Document doc = docBuilder.newDocument();
      Element rootElement = doc.createElement("schedule");
      doc.appendChild(rootElement);
      for(int i = 0; i < super.getClassList().size(); i++)
      {
        // every class element
        Element fitClass = doc.createElement("fitClass");
        rootElement.appendChild(fitClass);

        // set attribute to fitClass element
        /*Attr attr = doc.createAttribute("id");
        attr.setValue(i);
        fitClass.setAttributeNode(attr);*/

        // shorten way
        // staff.setAttribute("id", "1");

        // day elements
        Element date = doc.createElement("date");
        date.appendChild(doc.createTextNode(super.getClassList().getClass(i).getDate(i).toString()));
        fitClass.appendChild(date);

        // time elements
        Element time = doc.createElement("time");
        time.appendChild(doc.createTextNode(super.getClassList().getClass(i).getDate(i).getTimeInterval()));
        fitClass.appendChild(time);

        // className elements
        Element className = doc.createElement("className");
        className.appendChild(doc.createTextNode(super.getClassList().getClass(i).getClassName()));
        fitClass.appendChild(className);

        // instructor elements
        Element instructor = doc.createElement("instructor");
        //instructor.appendChild(doc.createTextNode(super.getClassList().getClass(i).getInstructors()));
        fitClass.appendChild(instructor);
      }
      // write the content into xml file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("file.xml"));

      // Output to console for testing
      // StreamResult result = new StreamResult(System.out);

      transformer.transform(source, result);

      System.out.println("File saved!");

    } catch (ParserConfigurationException pce) {
      pce.printStackTrace();
    } catch (TransformerException tfe) {
      tfe.printStackTrace();
    }
  }

  public static void main(String[] args)
  {

    XmlGenerator generator = new XmlGenerator();
    generator.generateXml();
    System.out.println(generator.getClassList().toString());
  }
}
