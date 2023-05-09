package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main class for the Analytics project.
 * Reads a list of symptoms from a file, counts their occurrences, sorts them
 * alphabetically, and writes the results to a new file.
 */
public class Main {

  /**
   * Main method of the Analytics project.
   * Reads the symptoms from a file, counts their occurrences, sorts them
   * alphabetically, and writes the results to a new file.
   *
   * @param args command line arguments, unused.
   */
  public static void main(String[] args) {
    // Create an instance of ReadSymptomDataFromFile using the default input file name.
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

    // Create an instance of WriteSymptomDataToFile.
    ISymptomWriter writer = new WriteSymptomDataToFile();

    // Create an instance of AnalyticsCounter using the reader and writer.
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

    // Get the list of symptoms from the reader.
    ArrayList<String> symptoms = counter.getSymptoms();

    // Count the occurrences of each symptom and store the results in a map.
    Map<String, Integer> symptomCounts = counter.countSymptoms(symptoms);

    // Sort the symptoms alphabetically and store the results in a map.
    Map<String, Integer> sortedSymptoms = counter.sortSymptoms(symptomCounts);

    // Write the sorted symptoms to a new file using the writer.
    counter.writeSymptoms(sortedSymptoms);
  }
}
