import java.util.ArrayList;

public class Instructor extends Person
{
  private ArrayList<String> classes;

  public Instructor(String name, String address, String phoneNumber, String email, ArrayList<String> classes){
    super(name, address, phoneNumber, email);
    this.classes = classes;
  }

  public ArrayList<String> getClasses()
  {
    return classes;
  }

  public void setClasses(ArrayList<String> classes){
    this.classes = classes;
  }

  public String toString(){
    return super.toString() + "Classes: " + classes;
  }

}
