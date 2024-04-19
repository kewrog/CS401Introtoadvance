package CS401project;

public class Searcher {
    // Method to select and perform the specified search algorithm on the data array
    public <T extends Comparable<T>> void performSearch(int searchChoice, T[] data, int count, T target) {
        switch (searchChoice) {
            case 1: // Linear Search
                int linearIndex = linearSearch(data, target, count);
                printSearchResult(linearIndex, target);
                break;
            case 2: // Binary Search
                int binaryIndex = binarySearch(data, target, 0, count - 1);
                printSearchResult(binaryIndex, target);
                break;
            default:
                System.out.println("Invalid search option selected.");
                break;
        }
    }

    // Linear search method
    private <T extends Comparable<T>> int linearSearch(T[] data, T target, int count) {
        for (int i = 0; i < count; i++) {
            if (data[i].compareTo(target) == 0) {
                return i; // Target found, return index
            }
        }
        return -1; // Target not found
    }

    // Binary search method, assumes data is sorted
    private <T extends Comparable<T>> int binarySearch(T[] data, T target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compResult = target.compareTo(data[mid]);

            if (compResult == 0) {
                return mid; // Target found, return index
            } else if (compResult > 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    // Utility method to print search results
    private <T extends Comparable<T>> void printSearchResult(int index, T target) {
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
}
