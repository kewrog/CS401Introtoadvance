package CS401project;

import java.util.HashMap;
import java.util.Map;

public class Analyzer {
    // Method to analyze the provided data
    public void analyzeData(String[] data) {
        if (data == null) {
            System.out.println("Error: Null value encountered in data.");
            return;
        }

        // Initialize a map to store the frequency of each data item
        Map<String, Integer> frequencyMap = getFrequencyMap(data);

        // Display the frequency of each data item
        System.out.println("Frequency of each data item:");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method to generate a frequency map for the provided data
    private Map<String, Integer> getFrequencyMap(String[] data) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : data) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
}
