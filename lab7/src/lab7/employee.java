package lab7;

class employee implements Comparable<employee> {
    int id;
    String name;

    employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(employee other) {
        return Integer.compare(this.id, other.id);
    }
}
