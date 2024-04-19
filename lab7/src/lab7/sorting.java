package lab7;

import java.io.*;
import java.util.*;

public class sorting {

    public static <T extends Comparable<T>> void selectionSort(T[] array, int low, int high) {
        for (int i = low; i <= high; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= high; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int low, int high, T key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = array[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        // Example usage with Employee objects
        employee[] employees = readEmployeesFromFile("emp.txt");
        selectionSort(employees, 0, employees.length - 1);

        System.out.println("Sorted Employees:");
        for (employee emp : employees) {
            System.out.println(emp.id + " " + emp.name);
        }

        // Assume we're looking for the Employee with ID 2
        employee searchKey = new employee(2, ""); // Only ID is used for comparison
        int resultIndex = binarySearch(employees, 0, employees.length - 1, searchKey);
        if (resultIndex != -1) {
            System.out.println("Employee found: " + employees[resultIndex].id + " " + employees[resultIndex].name);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static employee[] readEmployeesFromFile(String filename) {
        List<employee> employees = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                employees.add(new employee(id, name));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return new employee[0];
        }
        return employees.toArray(new employee[0]);
    }
}
