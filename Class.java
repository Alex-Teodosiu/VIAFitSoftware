import java.util.ArrayList;

public class Class
{
  private ArrayList<String> instructors;
  private String className;
  private Date startTime, endTime;

  public Class(Instructor instr, String className){
    instructors = new ArrayList<String>();
    instructors.add(instr.getName());
    this.className = className;
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

  public String getTimeSlot(){
    return startTime + " till " + endTime;
  }

  public String toString(){
    return "Class Name: " + className + "\nInstructor(s): " + instructors + getTimeSlot();
  }

}
