import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/*** This class contains all of the lists
 * @author Michal Pupák
 * @version 1.0
 * */
public class VIAFitSystem
{
  private MemberList memberList;
  private InstructorList instructorList;
  private ClassList classList;

  private MemberFileAdapter memberFileAdapter;
  private InstructorFileAdapter instructorFileAdapter;
  private ClassFileAdapter classFileAdapter;
  /**
   * Constructor initializing the VIAFitSystem.
   */
  public VIAFitSystem(){
    memberFileAdapter = new MemberFileAdapter("members.bin");
    instructorFileAdapter = new InstructorFileAdapter("instructors.bin");
    classFileAdapter = new ClassFileAdapter("classes.bin");

    memberList = memberFileAdapter.getAllMembers();
    instructorList = instructorFileAdapter.getAllInstructors();
    classList = classFileAdapter.getAllClasses();
  }
  /**
   * Gets the list of the members
   */
  public MemberList getMemberList()
  {
    return memberList;
  }


  /**
   * Gets the list of the instructors
   */
  public InstructorList getInstructorList()
  {
    return instructorList;
  }

  /**
   * Gets the names of the instructors in an Array list
   */
  public ArrayList<String> getInstructorNames(){
    ArrayList<String> names = new ArrayList<String>();

    for (int i = 0; i < instructorList.size(); i++){
      names.add(instructorList.getInstructor(i).getName());
    }

    String[] strings = new String[names.size()];
    for (int i = 0; i < instructorList.size(); i++){
      strings[i] = names.get(i);
    }

    Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < instructorList.size(); i++){
      names.set(i, strings[i]);
    }
    return names;
  }

  /**
   * Gets the names of the members in an Array list
   */
  public ArrayList<String> getMemberNames(){
    ArrayList<String> names = new ArrayList<String>();

    for (int i = 0; i < memberList.size(); i++){
      names.add(memberList.getMember(i).getName());
    }

    String[] strings = new String[names.size()];
    for (int i = 0; i < memberList.size(); i++){
      strings[i] = names.get(i);
    }

    Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < memberList.size(); i++){
      names.set(i, strings[i]);
    }
    return names;
  }

  /**
   * Gets the names of the classes in an Array list
   */
  public ArrayList<String> getClassNames(){
    ArrayList<String> names = new ArrayList<String>();

    for (int i = 0; i < classList.size(); i++){
      names.add(classList.getClass(i).getClassName());
    }

    String[] strings = new String[names.size()];
    for (int i = 0; i < classList.size(); i++){
      strings[i] = names.get(i);
    }

    Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < classList.size(); i++){
      names.set(i, strings[i]);
    }
    return names;
  }


  /**
   * Gets the Class list
   */
  public ClassList getClassList()
  {
    return classList;
  }

  public static void main(String[] args)
  {
    VIAFitSystem viaFitSystem = new VIAFitSystem();
    //viaFitSystem.getMemberList().addMember(new Member("Michal Pupak","Kamtjatka","####","mail@gmail.com",true));
    System.out.println(viaFitSystem.getMemberList().getMember(0));
  }
}