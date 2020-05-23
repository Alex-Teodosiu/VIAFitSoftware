import java.io.Serializable;
import java.util.ArrayList;

public class Instructor extends Person implements Serializable
{
  private ArrayList<String> classes;


  public Instructor(String name, String address, String phoneNumber, String email){
    super(name, address, phoneNumber, email);
    classes = new ArrayList<String>();
  }

  public ArrayList<String> getClasses()
  {
    return classes;
  }

  public void addClass(Class clas){
    classes.add(clas.getClassName());
  }

  public void removeClass(Class clas){
    for (int i = 0; i < classes.size(); i++){
      if (classes.get(i).matches(clas.getClassName())){
        classes.remove(i);
      }
    }
  }

  public void setClasses(ArrayList<String> classes){
    this.classes = classes;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Instructor)){
      return false;
    }
    if (classes.size() != ((Instructor) obj).classes.size()){
      return false;
    }

    for (int i = 0; i < classes.size(); i++){
      if (!classes.get(i).equals(((Instructor) obj).classes.get(i))){
        return false;
      }
    }
    return super.equals(obj);
  }

  public String toString(){
    return super.toString() + "Classes: " + classes;
  }

}
