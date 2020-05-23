import java.io.Serializable;
import java.util.ArrayList;

public class Class implements Serializable
{
  private ArrayList<String> instructors;
  private ArrayList<Member> members;
  private String className;
  private Date startTime, endTime;
  private int maxNumberOfMembers;

  public Class(Instructor instr, String className, int maxNumberOfMembers){
    instructors = new ArrayList<String>();
    members = new ArrayList<Member>();
    instructors.add(instr.getName());
    this.className = className;
    this.maxNumberOfMembers = maxNumberOfMembers;
  }

  public void addMember(Member member){
    if (members.size() < maxNumberOfMembers){
      members.add(member);
    }
  }

  public void setInstructor(Instructor instr){
    instructors.add(instr.getName());
  }

  public String getInstructors(){
    return instructors.toString();
  }

  public void setTimeSlot(Date start, Date end){
    startTime = start.copy();
    endTime = end.copy();
  }

  public String getClassName(){
    return className;
  }

  public String getTimeSlot(){
    return startTime + " till " + endTime;
  }

  public String toString(){
    return "Class Name: " + className + "\nInstructor(s): " + instructors + getTimeSlot();
  }

}
