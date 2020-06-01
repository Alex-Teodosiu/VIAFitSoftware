import java.io.Serializable;
import java.util.ArrayList;
/*** A class containing the list of the members
 * @author Michal Pupák
 * @version 1.0
 * */
public class MemberList implements Serializable
{
  private static final long serialVersionUID = 3132772975308072199L;

  public ArrayList<Member> members;
  private MemberFileAdapter memberFileAdapter;

  /**
   * No-argument constructor initializing the Member list.
   */
  public MemberList(){
    members = new ArrayList<>();
    memberFileAdapter = new MemberFileAdapter("members.bin");
  }

  /**
   * Adds a member to the member list
   * @param member this member object will be added
   */
  public void addMember(Member member){
    members.add(member);
    memberFileAdapter.saveMembers(this);
  }

  /**
   * Replaces the Member object at index with member.
   * @param member the member to replace with
   * @param index the position in the list that will be replaced
   */

  public void setMember(Member member, int index){
    members.set(index, member);
    memberFileAdapter.saveMembers(this);
  }


  /**
   * Removes the Member object from position index.
   * @param index the position in the list that will be removed
   */
  public void removeMember(int index){
    members.remove(index);
    memberFileAdapter.saveMembers(this);
  }

  /**
   * Removes the specific Member object from the list.
   * @param member the member that will be removed
   */
  public void removeMember(Member member){
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).equals(member)){
        members.remove(i);
      }
    }
    memberFileAdapter.saveMembers(this);
  }

  /**
   * Gets a Member object from position index from the list.
    * @param index the position in the list of the Member object
    * @return the Member at index if one exists, else null
   */

  public Member getMember(int index){
    return members.get(index);
  }

  /**
   * Returns the size of the member list
   * @return the size of the member list in int format
   */
  public int size(){
    return members.size();
  }

  /**
   * Returns the premium members as an array list
   * @return Returns the premium members as an array list
   */
  public ArrayList<Member> getPremiumMembers(){
    ArrayList<Member> premiumMembers = new ArrayList<>();
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).isPremiumMember()){
        premiumMembers.add(members.get(i));
      }
    }
    return premiumMembers;
  }

  /**
   * Returns a string with the details of the member list.
   * */
  public String toString(){
    String str = "";
    for (int i =0; i < members.size(); i++){
      str += members.get(i).toString() + "\n";
    }
    return str;
  }
}
