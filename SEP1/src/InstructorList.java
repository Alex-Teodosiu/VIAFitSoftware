import java.io.Serializable;
import java.util.ArrayList;
/*** A class containing the list of the instructors
 * @author Michal Pupák
 * @version 1.0
 * */
public class InstructorList implements Serializable
{
  private static final long serialVersionUID = -8845764428490235464L;
  public ArrayList<Instructor> instructors;
  private InstructorFileAdapter instructorFileAdapter;


  /**
   * No-argument constructor initializing the Instructor list.
   */
  public InstructorList(){
    instructors = new ArrayList<Instructor>();
    instructorFileAdapter = new InstructorFileAdapter("instructors.bin");
  }

  /**
   * Adds an instructor to the instructor list
   * @param instructor this instructor object will be added
   */
  public void addInstructor(Instructor instructor){
    instructors.add(instructor);
    instructorFileAdapter.saveInstructors(this);
  }

  /**
   * Replaces the Instructor object at index with instructor.
   * @param instructor the instructor to replace with
   * @param index the position in the list that will be replaced
   */
  public void setInstructor(Instructor instructor, int index){
    instructors.set(index, instructor);
    instructorFileAdapter.saveInstructors(this);

  }


  /**
   * Removes the Instructor object from position index.
   * @param index the position in the list that will be removed
   */
  public void removeInstructor(int index){
    instructors.remove(index);
    instructorFileAdapter.saveInstructors(this);
  }


  /**
   * Removes the specific Instructor object from the list.
   * @param instructor the instructor that will be removed
   */
  public void removeInstructor(Instructor instructor){
    for (int i = 0; i < instructors.size(); i++){
      if (instructors.get(i).equals(instructor)){
        instructors.remove(i);
      }
    }
    instructorFileAdapter.saveInstructors(this);
  }


  /**
   * Gets a Instructor object from position index from the list.
   * @param index the position in the list of the Instructor object
   * @return the Instructor at index if one exists, else null
   */
  public Instructor getInstructor(int index){

    return instructors.get(index);
  }


  /**
   * Returns the size of the instructor list
   * @return the size of the instructor list in int format
   */
  public int size(){
    return instructors.size();
  }

  /**
   * Adds the classs to the position index of the list
   * @param instructorIndex the position
   * @param classs the Class object
   */
  public void addInstructorClass(int instructorIndex, Class classs){
    instructors.get(instructorIndex).addClass(classs);
    instructorFileAdapter.saveInstructors(this);
  }

  /**
   * Returns a string with the details of the instructor list.
   * */
  public String toString(){
    String str = "";
    for (int i =0; i < instructors.size(); i++){
      str += instructors.get(i).toString() + "\n";
    }
    return str;
  }
}
