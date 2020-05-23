import java.io.Serializable;
import java.util.ArrayList;

public class InstructorList implements Serializable
{
  private ArrayList<Instructor> instructors;
  private InstructorFileAdapter instructorFileAdapter;

  public InstructorList(){
    instructors = new ArrayList<Instructor>();
    instructorFileAdapter = new InstructorFileAdapter("instructors.bin");
  }

  public void addInstructor(Instructor instructor){
    instructors.add(instructor);
    instructorFileAdapter.saveInstructors(this);
  }

  public void setInstructor(Instructor instructor, int index){
    instructors.set(index, instructor);
    instructorFileAdapter.saveInstructors(this);

  }

  public void removeInstructor(int index){
    instructors.remove(index);
  }

  public void removeInstructor(Instructor instructor){
    for (int i = 0; i < instructors.size(); i++){
      if (instructors.get(i).equals(instructor)){
        instructors.remove(i);
      }
    }
    instructorFileAdapter.saveInstructors(this);
  }

  public Instructor getInstructor(int index){
    return instructors.get(index);
  }

  public int size(){
    return instructors.size();
  }

  public String toString(){
    String str = "";
    for (int i =0; i < instructors.size(); i++){
      str += instructors.get(i).toString() + "\n";
    }
    return str;
  }
}
