package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class provides methods to count and sort symptoms and write them to a file.
 */
public class AnalyticsCounter {
  ISymptomReader reader;
  ISymptomWriter writer;

  /**
   * Constructs an instance of AnalyticsCounter with the given ISymptomReader and ISymptomWriter.
   * @param reader An implementation of ISymptomReader used to read symptoms from a data source.
   * @param writer An implementation of ISymptomWriter used to write counted and sorted symptoms.
   */
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  /**
   * Reads the symptoms using the ISymptomReader provided during construction.
   * @return An ArrayList of strings representing the symptoms.
   */
  public ArrayList<String> getSymptoms() {
    ArrayList<String> symptoms = reader.getSymptoms();

    return symptoms;
  }

  /**
   * Counts the number of occurrences of each symptom in the given list of symptoms.
   * @param symptoms A list of symptoms to be counted.
   * @return A map with the symptom as key and the number of occurrences as value.
   */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> countedSymptoms = new HashMap<>();

    for (String symptom : symptoms) {
      if (countedSymptoms.containsKey(symptom)) {
        int occurrences = countedSymptoms.get(symptom);
        countedSymptoms.put(symptom, occurrences + 1);
      } else {
        countedSymptoms.put(symptom, 1);
      }
    }
    return countedSymptoms;
  } 

  /**
   * Sorts the given map of symptoms by key.
   * @param symptoms A map of symptoms to be sorted.
   * @return A sorted TreeMap with the symptom as key and the number of occurrences as value.
   */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
    TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
    return sortedSymptoms;
  }

  /**
   * Writes the given map of symptoms to a file using ISymptomWriter.
   * @param symptoms A map of symptoms to be written to a file.
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);        
  }
}
