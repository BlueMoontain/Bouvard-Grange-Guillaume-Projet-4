package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

  private String fileName; // Variable to hold the name of the file

  /**
   * Creates a new WriteSymptomDataToFile object with default file name "result.out".
   */
  public WriteSymptomDataToFile() {
    this.fileName = "result.out"; 
  }

  /**
   * Writes the given symptom data to a file.
   * Map containing symptom names and its occurrence count.
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {

    try {
      FileWriter fileWriter = new FileWriter(fileName); // Write to the file specified in fileName
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        String symptom = entry.getKey();
        int occurrence = entry.getValue();
        bufferedWriter.write(symptom + " : " + occurrence);
        bufferedWriter.newLine();
      }
      bufferedWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
  }
}