package LibraryManagement;

public class Member {
    public String name;
    public int id;

    public Member(String n, int i) {
        name = n;
        id = i;
    }

    public void display() {
        System.out.println("Member: " + name + ", ID: " + id);
    }
}
