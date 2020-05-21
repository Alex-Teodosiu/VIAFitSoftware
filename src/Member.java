import java.io.Serializable;

public class Member extends Person implements Serializable
{
  private boolean membershipStatus;

  public Member(String name, String address, String phoneNumber, String email, boolean membershipStatus){
    super(name, address, phoneNumber, email);
    this.membershipStatus = membershipStatus;
  }

  public boolean isPremiumMember(){
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
    return super.toString() + "\nPremium member: " + membershipStatus;
  }
}
