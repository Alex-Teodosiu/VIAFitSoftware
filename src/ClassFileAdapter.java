import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class ClassFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  public ClassFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

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
