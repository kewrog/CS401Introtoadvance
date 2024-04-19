package part1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();

        try (BufferedReader reader = new BufferedReader(new FileReader("emp.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    employee emp = new employee(id, name);
                    list.addSorted(emp); // Use addSorted instead of add to maintain order
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid format for employee ID: " + e.getMessage());
        }

        System.out.println("Sorted Employees:");
        list.forEach(System.out::println);

        // Demonstrate remove and contains
        if (list.containsById(1)) {
            System.out.println("\nEmployee with ID 1 exists.");
        }

        System.out.println("\nRemoving employee with ID 1.");
        list.removeById(1);

        if (!list.containsById(1)) {
            System.out.println("Employee with ID 1 has been removed.");
        }
    }
}
