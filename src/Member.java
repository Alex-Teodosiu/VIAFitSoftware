import java.io.Serializable;

public class Member extends Person implements Serializable
{
  private static final long serialVersionUID = 2611549234936586114L;
  private boolean membershipStatus;
  private String stringMembership;

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

  public boolean isPremiumMember(){
    return membershipStatus;
  }

  public boolean getMembershipStatus()
  {
    return membershipStatus;
  }

  public void setMembershipStatus(boolean membershipStatus){
    this.membershipStatus = membershipStatus;
  }

  public boolean equals(Object obj){
    if (!(obj instanceof Member)){
      return false;
    }
    return super.equals(obj) && membershipStatus == ((Member) obj).membershipStatus;
  }

  public String toString(){
    return super.toString();
  }
}
