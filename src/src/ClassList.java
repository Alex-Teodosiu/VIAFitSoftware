import java.io.Serializable;
import java.util.ArrayList;

public class ClassList implements Serializable
{
  private ArrayList<Class> classes;
  private ClassFileAdapter classFileAdapter;

  public ClassList(){
    classes = new ArrayList<Class>();
    classFileAdapter = new ClassFileAdapter("classes.bin");
  }

  public void addClass(Class clas){
    classes.add(clas);
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
