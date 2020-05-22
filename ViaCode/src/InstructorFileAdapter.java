import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class InstructorFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  public InstructorFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

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
}
