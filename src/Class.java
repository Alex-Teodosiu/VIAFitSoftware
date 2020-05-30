import com.sun.glass.ui.Menu;

import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable
{
  private final static long serialVersionUID = -7175877205437391816L;

  private Instructor instructor;
  private ArrayList<Member> members;
  private String className;
  private ArrayList<Date> lessons;
  private int maxNumberOfMembers;
  private String numberOfMembers;

  public Class(String className, Instructor instructor, int maxNumberOfMembers){
      this.className = className;
      this.instructor = instructor;
      members = new ArrayList<>();
      this.maxNumberOfMembers = maxNumberOfMembers;
      numberOfMembers = "0";

    lessons = new ArrayList<>();
  }

  public void addMember(Member member){
    if (members.size() < maxNumberOfMembers){
      this.members.add(member);
      numberOfMembers = Integer.toString(members.size());
    }
  }

  public void removeMember(Member member){
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).equals(member)){
        members.remove(i);
        numberOfMembers = Integer.toString(members.size());
        break;
      }
    }
  }

  public void removeLesson(Date date){
    for (int i = 0; i < lessons.size(); i++){
      if (lessons.get(i).equals(date)){
        lessons.remove(i);
        break;
      }
    }
  }

  public Member getMember(int i){
    return members.get(i);
  }

  public ArrayList<Member> getMembers(){
    return members;
  }

  public void setMembers(ArrayList<Member> members){
    this.members = members;
    numberOfMembers = Integer.toString(members.size());
  }

  public String getNumberOfMembers(){
    return numberOfMembers;
  }

  public int getMaxNumberOfMembers()
  {
    return maxNumberOfMembers;
  }

  public void setInstructor(Instructor instructor){
    this.instructor = instructor;
  }

  public Instructor getInstructor(){
    return instructor;
  }

  public String getStringInstructor(){
    return instructor.getName();
  }

  public void addLesson(Date date){
    lessons.add(date);
  }
  public void removeLesson(int index){
    lessons.remove(index);
  }

  public void setLessons(ArrayList<Date> dateArrayList){
    lessons = dateArrayList;
  }

  public void setClassName(String className){
    this.className = className;
  }

  public void setMaxNumberOfMembers(int i){
    maxNumberOfMembers = i;
  }

  public String getClassName(){
    return className;
  }

  public ArrayList<Date> getLessons(){
    return lessons;
  }

  public Date getDate(int index){
    return lessons.get(index);
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Class)){
      return false;
    }
    return className.equals(((Class) obj).className) && instructor.equals(((Class) obj).instructor)&& maxNumberOfMembers == ((Class) obj).maxNumberOfMembers;
  }

  public String toString(){
    return "Class Name: " + className + "\nInstructor: " + instructor+"\nMembers: "+members;
  }

}
