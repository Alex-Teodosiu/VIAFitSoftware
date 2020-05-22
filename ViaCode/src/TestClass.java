public class TestClass
{
  public static void main(String[] args)
  {
    MemberFileAdapter fileAdapter = new MemberFileAdapter("members.bin");
    MemberList memberList = new MemberList();
    memberList.addMember(new Member("Michal","Kamtjatka","12345","michal.pupak",true));
    System.out.println(fileAdapter.getAllMembers());
    System.out.println("-------------------");
    memberList.addMember(new Member("Ivan","Kamtjatka","12345","ivan.pupak",true));
    //memberList.removeMember(0);
    System.out.println(fileAdapter.getAllMembers());
  }
}
