import java.io.Serializable;

/*** A class containing the basic fields of a person
 * @author Tamás Péter, Michal Pupák
 * @version 1.0
 * */


public abstract class Person implements Serializable
{
  private String name;
  private String address;
  private String phoneNumber;
  private String email;
  /**
   * Constructor initializing the Person.
   * @param name the name of the person
   * @param address the address of the person
   * @param phoneNumber the phone number of the person
   * @param email email of the person
   *
   */
  public Person(String name, String address, String phoneNumber, String email){
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }


/**
 * Gets the name of the person.
 * */
  public String getName(){
    return name;
  }
/**
 * Sets the name of the person
 * @param name the name of the person
 * */
  public void setName(String name){
    this.name = name;
  }

  /**
   * Gets the adress of a person
   * */
  public String getAddress()
  {
    return address;
  }

  /**
   * Sets the address of the person.
   * @param address the address of the person
   * */
  public void setAddress(String address){
    this.address = address;
  }

  /**
   * Gets the phone number of the person.
   * */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * Sets the phone number of the person
   * @param phoneNumber the phone number of the person
   * */
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  /**
   * Gets the email of the person
   * */
  public String getEmail()
  {
    return email;
  }

  /**
   * Sets the email of the person
   * @param email the email of the person
   * */
  public void setEmail(String email){
    this.email = email;
  }


  /**
   * Checking if a person has the same properties as this person
   * @param obj a person object
   * @return if the obj is the same as the person
   * */
  public boolean equals(Object obj){
    if (!(obj instanceof Person)){
      return false;
    }
    return name.equals(((Person) obj).name) && address.equals(((Person) obj).address) &&
            phoneNumber.equals(((Person) obj).phoneNumber) && email.equals(((Person) obj).email);
  }


  /**
   * Returns a string with the details of the person.
   * */
  public String toString(){
    return "" + name;
  }

}
