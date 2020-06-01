import java.io.Serializable;
import java.util.ArrayList;

/*** A class containing the basic fields of an instructor extending the Person class
 * @author Tamás Péter, Michal Pupák, Alexandru Mihail Teodosiu
 * @version 1.0
 * */

public class Instructor extends Person implements Serializable
{
  private static final long serialVersionUID = -5279292488231572240L;
  private ArrayList<Class> instructorsClasses;

  /**
   * Constructor initializing the instructor and creating an Array list for their classes.
   * @param name the name of the person
   * @param address the address of the person
   * @param phoneNumber the phone number of the person
   * @param email email of the person
   */
  public Instructor(String name, String address, String phoneNumber, String email){
    super(name, address, phoneNumber, email);
    instructorsClasses = new ArrayList<>();
  }

  /**
   * Gets the array list of the classes.
   * */
  public String getClasses()
  {
    return instructorsClasses.toString();
  }


  /**
   * Adds a new class to the array
   * @param clas this class has been added to the list
   * */
  public void addClass(Class clas){
    instructorsClasses.add(clas);
  }


  /**
   * Removes the specific class from the array
   * @param clas this class has been removed from the list
   * */
  public void removeClass(Class clas){
    for (int i = 0; i < instructorsClasses.size(); i++){
      if (instructorsClasses.get(i).equals(clas)){
        instructorsClasses.remove(i);
      }
    }
  }

  /**
   * Overwrites the items in the Array list
   * @param instructorsClasses this list is the new value of the Array list
   * */
  public void setClasses(ArrayList<Class> instructorsClasses){
    this.instructorsClasses = instructorsClasses;
  }

  /**
   * Checking if an instructor has the same properties as this instructor
   * @param obj a instructor object
   * @return if the obj is the same as the instructor
   * */
  public boolean equals(Object obj){
    if (!(obj instanceof Instructor)){
      return false;
    }

    return super.equals(obj);
  }


  /**
   * Returns a string with the details of the instructor.
   * */
  public String toString(){
    return super.toString();
  }
}
