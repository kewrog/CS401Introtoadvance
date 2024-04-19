package part1;

import java.util.LinkedList;

public class SortedLinkedList extends LinkedList<employee> {
    // Custom method to add an employee in sorted order based on ID, renamed to avoid overriding confusion
    public void addSorted(employee emp) {
        if (this.isEmpty() || emp.getId() > this.getLast().getId()) {
            super.add(emp);
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (emp.getId() < this.get(i).getId()) {
                    super.add(i, emp);
                    break;
                }
            }
        }
    }

    // Removes an employee by ID, consider if renaming or adjustments are needed
    public boolean removeById(int id) {
        return this.removeIf(emp -> emp.getId() == id);
    }

    // Checks if an employee exists by ID, consider if renaming or adjustments are needed
    public boolean containsById(int id) {
        return this.stream().anyMatch(emp -> emp.getId() == id);
    }
}