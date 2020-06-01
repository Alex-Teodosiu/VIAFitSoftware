import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;


/** The file adapter serve as intermediates between the FilHandler and the list classes
 * @author Michal Pupák
 * @version 1.0
 * */
public class MemberFileAdapter implements Serializable
{
  private String fileName;
  private FileHandler fileHandler;

  /**
   * Constructor initializing the MemberFileAdapter
   * @param fileName the name of the file to set to the fileName
   */
  public MemberFileAdapter(String fileName){
    this.fileName = fileName;
    fileHandler = new FileHandler();
  }

  /**
   * Gets all members
   * @return returns all members in a MemberList
   */
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

  /**
   * Creates a blank member list
   */
  public void removeAllMembers(){
    MemberList memberList = new MemberList();
    saveMembers(memberList);
  }

  /**
   * Saves the mebers
   * @param memberList this member list has been saved
   */
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

  public static void main(String[] args)
  {
    MemberFileAdapter memberFileAdapter = new MemberFileAdapter("members.bin");
    memberFileAdapter.removeAllMembers();
    System.out.println(memberFileAdapter.getAllMembers());
  }
}
