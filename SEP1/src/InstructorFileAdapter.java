import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


/** The file adapter serve as intermediates between the FilHandler and the list classes
 * @author Michal Pupák
 * @version 1.0
 * */
public class InstructorFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  /**
   * Constructor initializing the InstructorFileAdapter
   * @param fileName the name of the file to set to the fileName
   */
  public InstructorFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

  /**
   * Gets all instructors
   * @return returns all instructors in an InstructorList
   */
  public InstructorList getAllInstructors(){

    InstructorList instructorList = new InstructorList();

    try
    {
      instructorList = (InstructorList)fileHandler.readObjectFromFile(fileName);
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
    return instructorList;
  }

  /**
   * Saves he instructors
   * @param instructorList this instructorlist has been saved
   */
  public void saveInstructors(InstructorList instructorList){
    try
    {
      fileHandler.writeToFile(fileName, instructorList);
    }
    catch (FileNotFoundException e){

    }
    catch (IOException e){
    }
  }

  /**
   * Creates a blank instructor list
   */
  public void removeAllInstructors(){
    InstructorList instructorList = new InstructorList();
    saveInstructors(instructorList);
  }

  public static void main(String[] args)
  {
    InstructorFileAdapter instructorFileAdapter = new InstructorFileAdapter("instructors.bin");
    instructorFileAdapter.removeAllInstructors();
  }
}
