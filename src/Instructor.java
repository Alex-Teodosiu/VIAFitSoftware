import java.io.Serializable;
import java.util.ArrayList;

public class Instructor extends Person implements Serializable
{
  private static final long serialVersionUID = -5279292488231572240L;
  private ArrayList<Class> instructorsClasses;


  public Instructor(String name, String address, String phoneNumber, String email){
    super(name, address, phoneNumber, email);
    instructorsClasses = new ArrayList<>();
  }

  public String getClasses()
  {
    return instructorsClasses.toString();
  }

  public void addClass(Class clas){
    instructorsClasses.add(clas);
  }

  public void removeClass(Class clas){
    for (int i = 0; i < instructorsClasses.size(); i++){
      if (instructorsClasses.get(i).equals(clas)){
        instructorsClasses.remove(i);
      }
    }
  }

  public void setClasses(ArrayList<Class> instructorsClasses){
    this.instructorsClasses = instructorsClasses;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Instructor)){
      return false;
    }

    return super.equals(obj);
  }

  public String toString(){
    return super.toString();
  }
}
