package CS401project;

import java.lang.reflect.Array;

public class Sorter {
    // Generic method to perform sorting based on the provided choice
    public <T extends Comparable<T>> void performSort(int sortChoice, T[] data, int count) {
        try {
            if (sortChoice == 1) {
                bubbleSort(data, count);
            } else if (sortChoice == 2) {
                mergeSort(data, 0, count - 1);
            } else {
                System.out.println("Invalid sort choice.");
            }
        } catch (ClassCastException e) {
            System.out.println("Error: Incompatible types found for sorting.");
        } catch (NullPointerException e) {
            System.out.println("Error: Null values found in data.");
        }
    }

    private <T extends Comparable<T>> void bubbleSort(T[] data, int count) {
        boolean swapped;
        for (int i = 0; i < count - 1; i++) {
            swapped = false;
            for (int j = 0; j < count - i - 1; j++) {
                if (data[j] != null && data[j + 1] != null && data[j].compareTo(data[j + 1]) > 0) {
                    T temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    private <T extends Comparable<T>> void mergeSort(T[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private <T extends Comparable<T>> void merge(T[] data, int left, int mid, int right) {
        T[] L = createArray(data, mid - left + 1);
        T[] R = createArray(data, right - mid);

        System.arraycopy(data, left, L, 0, L.length);
        System.arraycopy(data, mid + 1, R, 0, R.length);

        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) {
            if (L[i].compareTo(R[j]) <= 0) {
                data[k++] = L[i++];
            } else {
                data[k++] = R[j++];
            }
        }

        while (i < L.length) data[k++] = L[i++];
        while (j < R.length) data[k++] = R[j++];
    }

    // Safely create an array of a type that matches the data array's component type
    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> T[] createArray(T[] data, int length) {
        return (T[]) Array.newInstance(data.getClass().getComponentType(), length);
    }
}
