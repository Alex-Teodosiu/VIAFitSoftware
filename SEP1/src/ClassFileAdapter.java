import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


/** The file adapter serve as intermediates between the FilHandler and the list classes
 * @author Michal Pupák
 * @version 1.0
 * */
public class ClassFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  /**
   * Constructor initializing the ClassFileAdapter
   * @param fileName the name of the file to set to the fileName
   */
  public ClassFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

  /**
   *Gets all classes
   * @return returns all classes in a ClassList
   */
  public ClassList getAllClasses(){

    ClassList classList = new ClassList();

    try
    {
      classList = (ClassList)fileHandler.readObjectFromFile(fileName);
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    catch (IOException e){
      e.printStackTrace();
    }
    catch (ClassNotFoundException e){
      e.printStackTrace();
    }
    return classList;
  }

  /**
   * Saves the classes
   * @param classList this class list has been saved
   */
  public void saveClasses(ClassList classList){
    try
    {
      fileHandler.writeToFile(fileName, classList);
    }
    catch (FileNotFoundException e){
      e.printStackTrace();
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  /**
   * Creates a blank class list
   */
  public void removeAllClasses(){
    ClassList classList = new ClassList();
    saveClasses(classList);
  }


  public static void main(String[] args)
  {
    ClassFileAdapter classFileAdapter = new ClassFileAdapter("classes.bin");
    classFileAdapter.removeAllClasses();
  }
}
