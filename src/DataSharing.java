import javafx.scene.Parent;

public class DataSharing
{
  private static Class selectedClass;
  private static Member selectedMember;
  private static int classIndex;

  public static int getClassInstructorIndex()
  {
    return classInstructorIndex;
  }

  public static void setClassInstructorIndex(int classInstructorIndex)
  {
    DataSharing.classInstructorIndex = classInstructorIndex;
  }

  private static int classInstructorIndex;



  public static void setSelectedClass(Class selectedClasss){
    selectedClass = selectedClasss;
  }

  public static Class getSelectedClass(){
    return selectedClass;
  }

  public static void setMember(Member mmbr){
    selectedMember = mmbr;
  }

  public static Member getMember(){
    return selectedMember;
  }

  public static void setClassIndex(int index){
    classIndex = index;
  }

  public static int getClassIndex()
  {
    return classIndex;
  }


}
