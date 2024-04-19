package part2;

public class CircularLinkedList {
    Employee head = null;
    Employee tail = null;

    // Insert a new employee into the list
    public void insert(Employee newEmployee) {
        if (head == null) {
            head = newEmployee;
            tail = newEmployee;
            newEmployee.next = head;
        } else {
            tail.next = newEmployee;
            tail = newEmployee;
            tail.next = head;
        }
    }

    // Display the elements of the list
    public void display() {
        if (head != null) {
            Employee temp = head;
            do {
                System.out.println("Employee ID: " + temp.id + ", Name: " + temp.name);
                temp = temp.next;
            } while (temp != head);
        } else {
            System.out.println("The list is empty.");
        }
    }

    // Delete an employee by ID
    public void deleteById(int id) {
        if (head == null) {
            return; // List is empty
        }

        Employee current = head;
        Employee previous = null;

        do {
            if (current.id == id) {
                if (current == head && current == tail) { // Only one element
                    head = null;
                    tail = null;
                } else if (current == head) { // Deleting the head
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) { // Deleting the tail
                    tail = previous;
                    tail.next = head;
                } else { // Middle element
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }
}
