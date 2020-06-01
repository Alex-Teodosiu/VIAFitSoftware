import java.io.Serializable;

/*** A class containing the basic fields of a member extending the Person class
 * @author Tamás Péter, Michal Pupák, Alexandru Mihail Teodosiu
 * @version 1.0
 * */

public class Member extends Person implements Serializable
{
  private static final long serialVersionUID = 2611549234936586114L;
  private boolean membershipStatus;
  private String stringMembership;


  /**
   * Constructor initializing the member.
   * @param name the name of the person
   * @param address the address of the person
   * @param phoneNumber the phone number of the person
   * @param email email of the person
   * @param membershipStatus true if the member has premium membership, false if not
   */
  public Member(String name, String address, String phoneNumber, String email, boolean membershipStatus){
    super(name, address, phoneNumber, email);
    this.membershipStatus = membershipStatus;
    if (membershipStatus) {
      stringMembership = "Premium";
    }
    else
      stringMembership = "Standard";
  }

  public String getStringMembership(){
    return stringMembership;
  }
  /**
   * @return true if the member has premium membership.
   * */
  public boolean isPremiumMember(){
    return membershipStatus;
  }

  /**
   * Gets the membership status of the member.
   * */
  public boolean getMembershipStatus()
  {
    return membershipStatus;
  }

  /**
   * Sets the membership of the person.
   * @param membershipStatus true if premium, false if not
   * */
  public void setMembershipStatus(boolean membershipStatus){
    this.membershipStatus = membershipStatus;
  }

  /**
   * Checking if a member has the same properties as this member
   * @param obj a member object
   * @return if the obj is the same as the member
   * */
  public boolean equals(Object obj){
    if (!(obj instanceof Member)){
      return false;
    }
    return super.equals(obj) && membershipStatus == ((Member) obj).membershipStatus;
  }
  /**
   * Returns a string with the details of the member.
   * */
  public String toString(){
    return super.toString();
  }
}
