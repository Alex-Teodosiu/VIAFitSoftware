public class VIAFitSystem
{
  private MemberList memberList;
  private InstructorList instructorList;
  private ClassList classList;

  private MemberFileAdapter memberFileAdapter;
  private InstructorFileAdapter instructorFileAdapter;
  private ClassFileAdapter classFileAdapter;

  public VIAFitSystem(){
    memberFileAdapter = new MemberFileAdapter("members.bin");
    instructorFileAdapter = new InstructorFileAdapter("instructors.bin");
    classFileAdapter = new ClassFileAdapter("classes.bin");

    memberList = memberFileAdapter.getAllMembers();
    instructorList = instructorFileAdapter.getAllInstructors();
    classList = classFileAdapter.getAllClasses();
  }

  public MemberList getMemberList()
  {
    return memberList;
  }

  public InstructorList getInstructorList()
  {
    return instructorList;
  }

  public ClassList getClassList()
  {
    return classList;
  }

  public static void main(String[] args)
  {
    VIAFitSystem viaFitSystem = new VIAFitSystem();
    System.out.println(viaFitSystem.getMemberList().getMember(1));
  }
}
