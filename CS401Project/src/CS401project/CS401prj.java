package CS401project;

import java.util.Scanner;
import java.util.Arrays;

public class CS401prj {
    private Scanner scanner = new Scanner(System.in);
    private DataHandler dataHandler = new DataHandler();
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();
    private Analyzer analyzer = new Analyzer();

    public static void main(String[] args) {
        CS401prj project = new CS401prj();
        project.runMenu();
    }

    private void runMenu() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    handleDataInput();
                    break;
                case 2:
                    handleSort();
                    break;
                case 3:
                    handleSearch();
                    break;
                case 4:
                    handleDataOperations();
                    break;
                case 5:
                    handleDataAnalysis();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n=================================================");
        System.out.println("                   CS401 Project Menu            ");
        System.out.println("=================================================");
        System.out.println("| 1 - Add Data                                   |");
        System.out.println("| 2 - Sort Data                                  |");
        System.out.println("| 3 - Search Data                                |");
        System.out.println("| 4 - Manage Data (Add/Delete/Update/Restore)    |");
        System.out.println("| 5 - Analyze Data                               |");
        System.out.println("| 0 - Exit                                       |");
        System.out.println("=================================================");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;  // Returns -1 if input is not a valid integer
        }
    }

    private void handleDataInput() {
        System.out.print("How many entries do you want to add? ");
        int entries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < entries; i++) {
            addData();
        }
    }

    private void addData() {
        System.out.print("Enter data to add: ");
        String data = scanner.nextLine();
        dataHandler.addData(data);
        System.out.println("Data added successfully.");
    }

    private void handleDataOperations() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Manage Data Operations ---");
            System.out.println("1 - Add Data");
            System.out.println("2 - Delete Data");
            System.out.println("3 - Update Data");
            System.out.println("4 - Restore Data");
            System.out.println("0 - Return to Main Menu");

            System.out.print("Enter your choice: ");
            int operationChoice = getUserChoice();
         // Inside the menu loop
            switch (operationChoice) {
                case 1:
                    addData();
                    break;
                case 2:
                    deleteData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    restoreData();
                    break;
                case 0:
                    System.out.println("Thank you for using the CS401 Project application!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

            // After the switch statement
            if (operationChoice == 0) {
                break; // Exit the menu loop
            }

        }
    }

    private void deleteData() {
        System.out.print("Enter the index of the data to delete: ");
        int index = Integer.parseInt(scanner.nextLine());
        dataHandler.deleteData(index);
        System.out.println("Data deleted successfully.");
    }

    private void updateData() {
        System.out.print("Enter the index of the data to update: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new data: ");
        String newData = scanner.nextLine();
        dataHandler.updateData(index, newData);
        System.out.println("Data updated successfully.");
    }

    private void restoreData() {
        System.out.print("Enter the index of the data to restore: ");
        int index = Integer.parseInt(scanner.nextLine());
        dataHandler.restoreData(index);
        System.out.println("Data restored successfully.");
    }

    private void handleSort() {
        if (dataHandler.getCount() == 0) {
            System.out.println("No data to sort.");
            return;
        }
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Merge Sort");
        int sortChoice = getUserChoice();
        if (sortChoice != 1 && sortChoice != 2) {
            System.out.println("Invalid sorting choice.");
            return;
        }
        String[] data = dataHandler.getActiveData();
        System.out.println("Data before sorting: " + Arrays.toString(data));
        sorter.performSort(sortChoice, data, data.length);
        System.out.println("Data after sorting: " + Arrays.toString(data));
    }

    private void handleSearch() {
        if (dataHandler.getCount() == 0) {
            System.out.println("No data to search.");
            return;
        }
        System.out.println("Choose a search method:");
        System.out.println("1 - Linear Search");
        System.out.println("2 - Binary Search");
        int searchChoice = getUserChoice();
        System.out.print("Enter the target to search for: ");
        String target = scanner.nextLine();
        searcher.performSearch(searchChoice, dataHandler.getActiveData(), dataHandler.getCount(), target);
    }

    private void handleDataAnalysis() {
        if (dataHandler.getCount() == 0) {
            System.out.println("No data to analyze.");
            return;
        }
        String[] data = dataHandler.getActiveData();
        if (data.length == 0) {
            System.out.println("No active data to analyze.");
            return;
        }
        System.out.println("Analyzing data...");
        analyzer.analyzeData(data);
    }

}
