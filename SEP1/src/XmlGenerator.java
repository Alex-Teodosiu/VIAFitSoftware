import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.*;


/*** This class has the method which generates the xmlFile for the website.
 * @author Tamás Péter
 * @version 1.0
 * */
public class XmlGenerator extends VIAFitSystem
{
  /**
   * Puts the class in the right row
   * @param classList our global class list
   * @param i counting parameter
   * @param j counting parameter
   */
  public int getProperTimeSlot(ClassList classList, int i, int j)
  {
    switch (classList.getClass(i).getDate(j).getTimeInterval())
    {
      case "8:00 - 10:00":
        return 0;
      case "10:00 - 12:00":
        return 1;
      case "12:00 - 14:00":
        return 2;
      case "14:00 - 16:00":
        return 3;
      case "16:00 - 18:00":
        return 4;
      case "18:00 - 20:00":
        return 5;
    }
    return 0;
  }


  /**
   * Creates an ArrayList which holds 4 Class[][] objects for each week.
   * @param classList our global class list
   */
  public ArrayList<Class[][]> generate3DArray(ClassList classList){
    Class[][] xmlArrayWeek1 = new Class[6][6];
    Class[][] xmlArrayWeek2 = new Class[6][6];
    Class[][] xmlArrayWeek3 = new Class[6][6];
    Class[][] xmlArrayWeek4 = new Class[6][6];

    LocalDate today = LocalDate.now();
    LocalDate sunday = today.with(nextOrSame(SUNDAY));
    LocalDate sunday2nd = sunday.with(next(SUNDAY));
    LocalDate sunday3rd = sunday2nd.with(next(SUNDAY));
    LocalDate sunday4th = sunday3rd.with(next(SUNDAY));




    for(int i = 0; i < classList.size(); i++)
    {

      if(classList.getClass(i).getLessons() != null)
      {
        //A class has multiple time slots
        for (int j = 0; j < classList.getClass(i).getLessons().size(); j++)
        {

          LocalDate date = LocalDate.of(classList.getClass(i).getDate(j).getYear(),
              classList.getClass(i).getDate(j).getMonth(), classList.getClass(i).getDate(j).getDay());
          if (!date.isBefore(today))
          {
            if (date.isBefore(sunday))
            {
              switch (date.getDayOfWeek())
              {
                case MONDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][0] = classList.getClass(i);
                  break;
                case TUESDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][1] = classList.getClass(i);
                  break;
                case WEDNESDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][2] = classList.getClass(i);
                  break;
                case THURSDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][3] = classList.getClass(i);
                  break;
                case FRIDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][4] = classList.getClass(i);
                  break;
                case SATURDAY:
                  xmlArrayWeek1[getProperTimeSlot(classList, i, j)][5] = classList.getClass(i);
                  break;

              }
            }
            else if (date.isBefore(sunday2nd))
            {
              switch (date.getDayOfWeek())
              {
                case MONDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][0] = classList.getClass(i);
                  break;
                case TUESDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][1] = classList.getClass(i);
                  break;
                case WEDNESDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][2] = classList.getClass(i);
                  break;
                case THURSDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][3] = classList.getClass(i);
                  break;
                case FRIDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][4] = classList.getClass(i);
                  break;
                case SATURDAY:
                  xmlArrayWeek2[getProperTimeSlot(classList, i, j)][5] = classList.getClass(i);
                  break;

              }
            }
            else if (date.isBefore(sunday3rd))
            {
              switch (date.getDayOfWeek())
              {
                case MONDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][0] = classList.getClass(i);
                  break;
                case TUESDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][1] = classList.getClass(i);
                  break;
                case WEDNESDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][2] = classList.getClass(i);
                  break;
                case THURSDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][3] = classList.getClass(i);
                  break;
                case FRIDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][4] = classList.getClass(i);
                  break;
                case SATURDAY:
                  xmlArrayWeek3[getProperTimeSlot(classList, i, j)][5] = classList.getClass(i);
                  break;
              }
            }
            else if (date.isBefore(sunday4th))
            {
              switch (date.getDayOfWeek())
              {
                case MONDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][0] = classList.getClass(i);
                  break;
                case TUESDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][1] = classList.getClass(i);
                  break;
                case WEDNESDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][2] = classList.getClass(i);
                  break;
                case THURSDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][3] = classList.getClass(i);
                  break;
                case FRIDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][4] = classList.getClass(i);
                  break;
                case SATURDAY:
                  xmlArrayWeek4[getProperTimeSlot(classList, i, j)][5] = classList.getClass(i);
                  break;

              }
            }
          }
          else
          {
            classList.getClass(i).removeLesson(j);
          }
        }
      }

    }
    ArrayList<Class[][]> allOfTheWeeks = new ArrayList<Class[][]>();
    allOfTheWeeks.add(xmlArrayWeek1);
    allOfTheWeeks.add(xmlArrayWeek2);
    allOfTheWeeks.add(xmlArrayWeek3);
    allOfTheWeeks.add(xmlArrayWeek4);
    /**
     * the returned variable is the schedule
     * @return the classes from the class list according to the respective date, if there is no class on the date, it will return null
     */
    return allOfTheWeeks;
  }

  /**
   * Generates the xml file for the website
   * @param arrayList the object generated by the generate3Darray method
   */

  public void generateXml(ArrayList<Class[][]> arrayList) {

    try {

      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

      // root elements
      Document doc = docBuilder.newDocument();
      Element rootElement = doc.createElement("schedule");
      doc.appendChild(rootElement);
      for(int i = 0; i < 4; i++)
      {
        for (int j = 0; j < 6; j++)
        {
          for (int k = 0; k < 6; k++)
          {
            // every class element
            Element fitClass = doc.createElement("fitClass");
            rootElement.appendChild(fitClass);

            // time elements
            Element time = doc.createElement("time");
            String timeSlot = "";
            switch(j){
              case 0: timeSlot = "08-10";
                break;
              case 1: timeSlot = "10-12";
                break;
              case 2: timeSlot = "12-14";
                break;
              case 3: timeSlot = "14-16";
                break;
              case 4: timeSlot = "16-18";
                break;
              case 5: timeSlot = "18-20";
                break;

            }
            time.appendChild(doc.createTextNode(timeSlot));
            fitClass.appendChild(time);

            // className elements
            Element className = doc.createElement("className");
            try {
              className.appendChild(doc.createTextNode(arrayList.get(i)[j][k].getClassName()));
            }
            catch(NullPointerException e){
              className.appendChild(doc.createTextNode("----"));
            }

            fitClass.appendChild(className);

            // instructor elements
            Element instructor = doc.createElement("instructor");
            try {
              instructor.appendChild(doc.createTextNode(arrayList.get(i)[j][k].getStringInstructor()));
            }
            catch(NullPointerException e){
              instructor.appendChild(doc.createTextNode("----"));
            }

            fitClass.appendChild(instructor);


          }

        }

      }
      // write the content into xml file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("schedule.xml"));

      transformer.transform(source, result);

      System.out.println("File saved!");
      } catch(ParserConfigurationException pce){
          pce.printStackTrace();
      } catch(TransformerException tfe){
          tfe.printStackTrace();
      }

  }

  public static void main(String[] args)
  {

    XmlGenerator generator = new XmlGenerator();
    ArrayList<Class[][]> allOfTheWeeks = new ArrayList<Class[][]>();
    allOfTheWeeks = generator.generate3DArray(generator.getClassList());

    generator.generateXml(allOfTheWeeks);
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(allOfTheWeeks.get(0)[i][j] + " ");
      }
      System.out.println("\n");
    }
    System.out.println("\n");
    System.out.println("\n");
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(allOfTheWeeks.get(1)[i][j] + " ");
      }
      System.out.println("\n");
    }
    System.out.println("\n");
    System.out.println("\n");
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(allOfTheWeeks.get(2)[i][j] + " ");
      }
      System.out.println("\n");
    }
    System.out.println("\n");
    System.out.println("\n");
    for(int i = 0; i < 6; i++){
      for(int j = 0; j < 6; j++){
        System.out.print(allOfTheWeeks.get(3)[i][j] + " ");
      }
      System.out.println("\n");
    }


    //System.out.println(generator.getClassList().toString() + " " + generator.getClassList().size());
    //System.out.println(generator.generate3DArray(generator.getClassList()));
  }
}
