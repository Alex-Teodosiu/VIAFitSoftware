import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable
{
  private ArrayList<Member> members;
  private MemberFileAdapter memberFileAdapter;

  public MemberList(){
    members = new ArrayList<Member>();
    memberFileAdapter = new MemberFileAdapter("members.bin");
  }

  public void addMember(Member member){
    members.add(member);
    memberFileAdapter.saveMembers(this);
  }

  public void setMember(Member member, int index){
    members.set(index, member);
    memberFileAdapter.saveMembers(this);
  }

  public void removeMember(int index){
    members.remove(index);
    memberFileAdapter.saveMembers(this);
  }

  public void removeMember(Member member){
    for (int i = 0; i < members.size(); i++){
      if (members.get(i).equals(member)){
        members.remove(i);
      }
    }
    memberFileAdapter.saveMembers(this);
  }

  public Member getMember(int index){
    return members.get(index);
  }

  public int size(){
    return members.size();
  }

  public String toString(){
    String str = "";
    for (int i =0; i < members.size(); i++){
      str += members.get(i).toString() + "\n";
    }
    return str;
  }
}
