package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines the behavior of a class that can write symptom data to a valid data output format.
 */
public interface ISymptomWriter {

  /**
   * Write symptom data to a valid data output format.
   *
   * <p>Map containing symptom names as keys and their corresponding occurrences as values.
   */
  void writeSymptoms(Map<String, Integer> symptoms);
}
