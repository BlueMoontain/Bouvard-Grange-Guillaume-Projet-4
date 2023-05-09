package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Anything that will read symptom data from a source.
 * The important part is the return value from the operation, which is a list of strings
 * that may contain many duplications.
 *
 * <p>The implementation does not need to order the list.
 */
public interface ISymptomReader {
  
  /**
   * Retrieve a list of symptoms from the data source.
   *
   * @return an ArrayList of symptom strings obtained from a data source;
   *         duplicates are possible/probable.
   */
  public ArrayList<String> getSymptoms();
}