package part2;

public class Employee {
    int id;
    String name;
    Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null; // Initially, the next reference is null
    }
}
