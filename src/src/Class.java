import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable
{
  private final static long serialVersionUID = -7175877205437391816L;

  private String instructor;
  private ArrayList<Member> members;
  private String className;
  private ArrayList<Date> lessons;
  private int maxNumberOfMembers;

  public Class(String instr, String className, int maxNumberOfMembers){
    instructor = instr;
    members = new ArrayList<Member>();
    this.className = className;
    this.maxNumberOfMembers = maxNumberOfMembers;
    lessons = new ArrayList<>();
  }

  public void addMember(Member member){
    if (members.size() < maxNumberOfMembers){
      members.add(member);
    }
  }

  public void setInstructor(String instr){
    instructor = instr;
  }

  public String getInstructor(){
    return instructor;
  }

  public void addLesson(Date date){
    lessons.add(date);
  }
  public void removeLesson(int index){
    lessons.remove(index);
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

  public String toString(){
    return "Class Name: " + className + "\nInstructor: " + instructor;
  }

}
