import javafx.scene.Parent;
/***Sharing information between controllers
 * @author  Michal Pupák
 * @version 1.0
 * */
public class DataSharing
{
  private static Class selectedClass;
  private static Member selectedMember;
  private static int classIndex;

  /**
   *Gets the index of the instructor
   * @return returns the index of the classInstructorIndex
   */
  public static int getClassInstructorIndex()
  {
    return classInstructorIndex;
  }

  /**
   * Replaces the index of the instructor
   * @param classInstructorIndex replaces the index of the classInstructorIndex
   */
  public static void setClassInstructorIndex(int classInstructorIndex)
  {
    DataSharing.classInstructorIndex = classInstructorIndex;
  }

  private static int classInstructorIndex;

  /**
   * Selects a class
   * @param selectedClasss the selected class
   */
  public static void setSelectedClass(Class selectedClasss){
    selectedClass = selectedClasss;
  }

  /**
   *Gets the selected class
   * @return returns the selected class
   */
  public static Class getSelectedClass(){
    return selectedClass;
  }

  /**
   * Replaces the member with mmbr
   * @param mmbr the member to replace with
   */
  public static void setMember(Member mmbr){
    selectedMember = mmbr;
  }

  /**
   * Gets the selected member
   * @return returns the selected member
   */
  public static Member getMember(){
    return selectedMember;
  }

  /**
   * Replaces the index of the class with index
   * @param index the index to replace with
   */
  public static void setClassIndex(int index){
    classIndex = index;
  }

  /**
   * Gets the class index
   * @return returns the class index
   */
  public static int getClassIndex()
  {
    return classIndex;
  }


}
