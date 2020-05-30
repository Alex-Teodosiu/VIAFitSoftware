import java.io.Serializable;
import java.util.ArrayList;

public class ClassList implements Serializable
{
  private final static long serialVersionUID = -6119364804332197121L;
  public ArrayList<Class> classes;
  private ClassFileAdapter classFileAdapter;

  public ClassList(){
    classes = new ArrayList<>();
    classFileAdapter = new ClassFileAdapter("classes.bin");
  }

  public void setClassName(int index, String name){
    classes.get(index).setClassName(name);
    classFileAdapter.saveClasses(this);
  }

  public void setClassMemberLimit(int index, int num){
    classes.get(index).setMaxNumberOfMembers(num);
    classFileAdapter.saveClasses(this);
  }

  public void addClass(Class clas){
    classes.add(clas);
    classFileAdapter.saveClasses(this);
  }

  public void setClassInstructor(int index, Instructor instructor){
    classes.get(index).setInstructor(instructor);
    classFileAdapter.saveClasses(this);
  }

  public void setClass(Class clas, int index){
    classes.set(index, clas);
    classFileAdapter.saveClasses(this);

  }

  public void removeClass(int index){
    classes.remove(index);
    classFileAdapter.saveClasses(this);
  }

  public void removeClass(Class clas){
    for (int i = 0; i < classes.size(); i++){
      if (classes.get(i).equals(clas)){
        classes.remove(i);
      }
    }
    classFileAdapter.saveClasses(this);
  }

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

  public int size(){
    return classes.size();
  }

  public String toString(){
    String str = "";
    for (int i =0; i < classes.size(); i++){
      str += classes.get(i).toString() + "\n";
    }
    return str;
  }
}
