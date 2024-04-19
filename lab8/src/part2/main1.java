package part2;

	import java.io.BufferedReader;
	import java.io.FileReader;

	public class main1 {
	    public static void main(String[] args) {
	        CircularLinkedList list = new CircularLinkedList();

	        try (BufferedReader br = new BufferedReader(new FileReader("emp.txt"))) {
	            String line;
	            int count = 0;
	            while ((line = br.readLine()) != null && count < 8) {
	                String[] parts = line.split("\\s+", 2);
	                if (parts.length == 2) {
	                    int id = Integer.parseInt(parts[0]);
	                    String name = parts[1];
	                    Employee emp = new Employee(id, name);
	                    list.insert(emp);
	                    count++;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        System.out.println("Elements after inserting:");
	        list.display();

	        // Assuming we want to delete the employee with ID 3
	        list.deleteById(3);
	        System.out.println("\nAfter deleting ID 3:");
	        list.display();
	    }
	}

