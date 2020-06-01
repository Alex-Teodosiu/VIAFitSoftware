import java.io.Serializable;
import java.util.ArrayList;

/*** A class containing the list of the classes
 * @author Michal Pupák
 * @version 1.0
 * */
public class ClassList implements Serializable
{
  private final static long serialVersionUID = -6119364804332197121L;
  public ArrayList<Class> classes;
  private ClassFileAdapter classFileAdapter;


  /**
   * No-argument constructor initializing the Class list.
   */
  public ClassList(){
    classes = new ArrayList<>();
    classFileAdapter = new ClassFileAdapter("classes.bin");
  }


  /**
   * Replaces the name of the class object at index with name.
   * @param name the class name to replace with
   * @param index the position of the name in the list that will be replaced
   */
  public void setClassName(int index, String name){
    classes.get(index).setClassName(name);
    classFileAdapter.saveClasses(this);
  }


  /**
   * Replaces the number of members of the class object at index with num.
   * @param num the number of members of the class to replace with
   * @param index the position of the number of members in the list that will be replaced
   */
  public void setClassMemberLimit(int index, int num){
    classes.get(index).setMaxNumberOfMembers(num);
    classFileAdapter.saveClasses(this);
  }

  /**
   * Adds a class object to the class list
   * @param clas
   */
  public void addClass(Class clas){
    classes.add(clas);
    classFileAdapter.saveClasses(this);
  }

  /**
   * Replaces the instructor for the class
   * @param index
   * @param instructor
   */
  public void setClassInstructor(int index, Instructor instructor){
    classes.get(index).setInstructor(instructor);
    classFileAdapter.saveClasses(this);
  }


  /**
   * Replaces the class object at index with clas.
   * @param clas this class object will be added
   * @param index the class object will be added to this position
   */
  public void setClass(Class clas, int index){
    classes.set(index, clas);
    classFileAdapter.saveClasses(this);

  }


  /**
   * Removes the Class object from position index.
   * @param index the position in the list that will be removed
   */
  public void removeClass(int index){
    classes.remove(index);
    classFileAdapter.saveClasses(this);
  }


  /**
   * Removes the specific Class object from the list.
   * @param clas the class that will be removed
   */
  public void removeClass(Class clas){
    for (int i = 0; i < classes.size(); i++){
      if (classes.get(i).equals(clas)){
        classes.remove(i);
      }
    }
    classFileAdapter.saveClasses(this);
  }

  /**
   * Updates the class list
   */
  public void updateList(){
    classFileAdapter.saveClasses(this);
  }

  public void signUpMember(int classIndex, Member member){
    classes.get(classIndex).addMember(member);
    classFileAdapter.saveClasses(this);
  }

  public void removeMember(int classIndex, Member member){
    classes.get(classIndex).removeMember(member);
    classFileAdapter.saveClasses(this);
  }

  public void addLesson(int classIndex, Date date){
    classes.get(classIndex).addLesson(date);
    classFileAdapter.saveClasses(this);
  }

  public void removeLesson(int classIndex, Date date){
    classes.get(classIndex).removeLesson(date);
    classFileAdapter.saveClasses(this);
  }

  public Class getClass(int index){
    return classes.get(index);
  }

   /**
   *    * Returns the size of the class list
   *    * @return the size of the class list in int format
    */
  public int size(){
    return classes.size();
  }


  /**
   * Returns a string with the details of the instructor list.
   * */
  public String toString(){
    String str = "";
    for (int i =0; i < classes.size(); i++){
      str += classes.get(i).toString() + "\n";
    }
    return str;
  }
}
