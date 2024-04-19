package CS401project;

public class DataHandler {
    private String[] dataArray;  // Array to store the data.
    private boolean[] deleted;   // Parallel array to mark deleted items.
    private int count;           // Number of active entries.

    public DataHandler() {
        dataArray = new String[100];  // Initial capacity for data.
        deleted = new boolean[100];   // Initial deletion marks.
        count = 0;                    // Initially no data.
    }

    // Method to add data
    public void addData(String data) {
        if (data == null || data.isEmpty()) {
            System.out.println("Cannot add null or empty data.");
            return;
        }
        if (count >= dataArray.length) {
            increaseCapacity();
        }
        dataArray[count] = data;
        deleted[count] = false;
        count++;
        System.out.println("Data added successfully. Total entries: " + count);
    }

    // Method to delete data at a specified index
    public void deleteData(int index) {
        if (index < 0 || index >= count || deleted[index]) {
            System.out.println("Invalid index or data already deleted at index: " + index);
            return;
        }
        deleted[index] = true;
        System.out.println("Data at index " + index + " marked as deleted.");
    }

    // Method to update data at a specified index
    public void updateData(int index, String newData) {
        if (index < 0 || index >= count || deleted[index]) {
            System.out.println("Invalid index or data is deleted at index: " + index);
            return;
        }
        dataArray[index] = newData;
        System.out.println("Data updated at index " + index);
    }

    // Method to restore data at a specified index
    public void restoreData(int index) {
        if (index < 0 || index >= count || !deleted[index]) {
            System.out.println("Invalid index or no deleted data at index: " + index);
            return;
        }
        deleted[index] = false;
        System.out.println("Data restored at index " + index);
    }

    // Method to increase the capacity of dataArray when it is full
    private void increaseCapacity() {
        String[] newdataArray = new String[dataArray.length * 2];
        boolean[] newDeleted = new boolean[deleted.length * 2];
        System.arraycopy(dataArray, 0, newdataArray, 0, dataArray.length);
        System.arraycopy(deleted, 0, newDeleted, 0, deleted.length);
        dataArray = newdataArray;
        deleted = newDeleted;
        System.out.println("Array capacity increased to " + dataArray.length);
    }

    // Method to get all active (non-deleted) data for display or other purposes
    public String[] getActiveData() {
        int activeCount = 0;
        for (int i = 0; i < count; i++) {
            if (!deleted[i]) {
                activeCount++;
            }
        }
        String[] activeData = new String[activeCount];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (!deleted[i]) {
                activeData[j++] = dataArray[i];
            }
        }
        return activeData;
    }

    // Method to get the current count of data items
    public int getCount() {
        return count;
    }
}
