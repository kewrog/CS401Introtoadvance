package part1;

public class employee {
    private int id;
    private String name;

    public employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "employee{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
