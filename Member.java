public class Member extends Person
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

}
