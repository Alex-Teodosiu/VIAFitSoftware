import java.io.Serializable;

public abstract class Person implements Serializable
{
  private String name;
  private String address;
  private String phoneNumber;
  private String email;

  public Person(String name, String address, String phoneNumber, String email){
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Person)){
      return false;
    }
    return name.equals(((Person) obj).name) && address.equals(((Person) obj).address) &&
            phoneNumber.equals(((Person) obj).phoneNumber) && email.equals(((Person) obj).email);
  }

  public String toString(){
    return "" + name;
  }

}
