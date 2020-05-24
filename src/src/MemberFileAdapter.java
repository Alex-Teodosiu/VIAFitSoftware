import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class MemberFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  public MemberFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

  public MemberList getAllMembers(){

    MemberList memberList = new MemberList();

    try
    {
      memberList = (MemberList)fileHandler.readObjectFromFile(fileName);
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
    return memberList;
  }

  public void removeAllMembers(){
    MemberList memberList = new MemberList();
    saveMembers(memberList);
  }

  public void saveMembers(MemberList memberList){
    try
    {
      fileHandler.writeToFile(fileName, memberList);
    }
    catch (FileNotFoundException e){

    }
    catch (IOException e){
    }
  }
}
