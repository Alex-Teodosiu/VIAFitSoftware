

import java.io.Serializable;
import java.util.ArrayList;


/** A class containing the basic fields of a class
 * @author Tamás Péter, Michal Pupák, Alexandru Mihail Teodosiu
 * @version 1.0
 * */
public class Class implements Serializable
{
  private final static long serialVersionUID = -7175877205437391816L;

  private Instructor instructor;
  private ArrayList<Member> members;
  private String className;
  private ArrayList<Date> lessons;
  private int maxNumberOfMembers;
  private String numberOfMembers;

  /**
   * Constructor initializing the class
   * @param className the name of the class
   * @param instructor the instructor
   * @param maxNumberOfMembers the maximum number of members the class can have
   */
  public Class(String className, Instructor instructor, int maxNumberOfMembers){
      this.className = className;
      this.instructor = instructor;
      members = new ArrayList<>();
      this.maxNumberOfMembers = maxNumberOfMembers;
      numberOfMembers = "0";

    lessons = new ArrayList<>();
  }



  /**
      * Adds a new member to the class
   * @param member this member has been added to the class
   */
  public void addMember(Member member){
    if (members.size() < maxNumberOfMembers){
      this.members.add(member);
      numberOfMembers = Integer.toString(members.size());
    }
  }

  /**
   * Removes a member from the class
   * @param member
   */
  public void removeMember(Member member){
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).equals(member)){
        members.remove(i);
        numberOfMembers = Integer.toString(members.size());
        break;
      }
    }
  }

  /**
   * Removes a lesson from the class according to his date
   * @param date
   */
  public void removeLesson(Date date){
    for (int i = 0; i < lessons.size(); i++){
      if (lessons.get(i).equals(date)){
        lessons.remove(i);
        break;
      }
    }
  }

  /**
   * Gets a Member object from position index from the list.
   * @param i the position in the list of the Member object
   * @return the Member at index if one exists, else null
   */
  public Member getMember(int i){
    return members.get(i);
  }

  /**
   * Gets the members as an array list
   * @return returnes an areay list
   */
  public ArrayList<Member> getMembers(){
    return members;
  }

  /**
   * Replaces the members with the array list
   * @param members this list is the new value of the Array list
   */
  public void setMembers(ArrayList<Member> members){
    this.members = members;
    numberOfMembers = Integer.toString(members.size());
  }

  /**
   * Returns the number of members as a string
   * @return returns the number of members as a string
   */
  public String getNumberOfMembers(){
    return numberOfMembers;
  }

  /**
   * Returns the maximum number of the members
   * @return returns the maximum number of the members
   */
  public int getMaxNumberOfMembers()
  {
    return maxNumberOfMembers;
  }

  /**
   * Replaces the instructor of this class
   * @param instructor the instructor to replace with
   */
  public void setInstructor(Instructor instructor){
    this.instructor = instructor;
  }

  /**
   * Gets the instructor
   * @return returns the instructor
   */
  public Instructor getInstructor(){
    return instructor;
  }

  /**
   * Gets the instructor's name
   * @return Gets the instructor's name
   */
  public String getStringInstructor(){
    return instructor.getName();
  }

  /**
   * Adds a new lesson to the class
   * @param date the lesson will be attached to this date
   */
  public void addLesson(Date date){
    lessons.add(date);
  }

  /**
   * Removes a lesson from the position index
   * @param index the lesson will be removed from this index
   */
  public void removeLesson(int index){
    lessons.remove(index);
  }

  /**
   * Replaces the lessons with the dateArrayList array list
   * @param dateArrayList the array list to replace with
   */
  public void setLessons(ArrayList<Date> dateArrayList){
    lessons = dateArrayList;
  }

  /**
   * Replaces the name of the class
   * @param className the name to replace with
   */
  public void setClassName(String className){
    this.className = className;
  }

  /**
   * Replaces the maximum number of the member list
   * @param i the number to replace withs
   */
  public void setMaxNumberOfMembers(int i){
    maxNumberOfMembers = i;
  }

  /**
   * Gets the name of the class
   * @return returns the name of the class
   */
  public String getClassName(){
    return className;
  }

  /**
   * Gets the lessons as an array list
   * @return returns the lessons as an array list
   */
  public ArrayList<Date> getLessons(){
    return lessons;
  }

  /**
   * Gets the date from the position index
   * @param index the position in the list that will be returned
   * @return returns the date from the position index
   */
  public Date getDate(int index){
    return lessons.get(index);
  }

  /**
   * Compare the class object with another Class object
   * @param obj the other class object
   * @return returns true if the classes are the same, false if not
   */
  public boolean equals(Object obj){
    if (!(obj instanceof Class)){
      return false;
    }
    return className.equals(((Class) obj).className) && instructor.equals(((Class) obj).instructor)&& maxNumberOfMembers == ((Class) obj).maxNumberOfMembers;
  }

  /**
   * Returns the details of a class in string format
   * @return
   */
  public String toString(){
    return "Class Name: " + className + "\nInstructor: " + instructor+"\nMembers: "+members;
  }

}
