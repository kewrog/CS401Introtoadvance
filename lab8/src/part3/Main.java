package part3;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        // Adding elements
        dll.add(21);
        dll.add(31);
        dll.add(41);
        dll.add(45);
        System.out.println("List after adding elements:");
        dll.display(); 

        // Removing an element
        dll.remove(31);
        System.out.println("List after removing an element:");
        dll.display(); 

        // Checking for an element
        System.out.println("List contains 21: " + dll.contains(21)); // Expected: true
        System.out.println("List contains 31: " + dll.contains(31)); // Expected: false
    }
}
