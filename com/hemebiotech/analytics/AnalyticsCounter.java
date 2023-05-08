package com.hemebiotech.analytics;

import java.util.LinkedList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter; 
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;



public class AnalyticsCounter {

    ISymptomReader reader;
    ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

   public ArrayList<String> getSymptoms() {
        ArrayList<String> symptoms = reader.getSymptoms();
        return symptoms; 
    }  
// 

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> countedSymptoms = new HashMap<>();

    for (String symptom : symptoms) { //une boucle qui parcourt la liste des symptomes

        if (countedSymptoms.containsKey(symptom)) { //vérifier que la clé (symptome) existe dans la map

            int occurrences = countedSymptoms.get(symptom); 
            countedSymptoms.put(symptom, occurrences + 1); //si elle existe, je rajoute +1 à la valeur (nb d'occurrences)
        } 

        else {
            countedSymptoms.put(symptom, 1); //si elle existe pas, je l'ajoute à la map, avec une valeur de 1
        }
    }
    return countedSymptoms; // return countedSymptoms;
        //{'headache' => 6, 'cold' => 4, 'maladie' => 1}
        //et qui retourne une map
        //une map ne peut pas avoir 2 clés identiques
   
    }
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) 
    { 
        TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
        return sortedSymptoms;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {

        writer.writeSymptoms(symptoms);
         
    // try {
    //     FileWriter fileWriter = new FileWriter("result.out"); 
    //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

    //     for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { 
    //         String symptom = entry.getKey();
    //         int occurrence = entry.getValue();
    //         bufferedWriter.write(symptom + " : " + occurrence); 
    //         bufferedWriter.newLine();
    //     }
    //     bufferedWriter.close(); 

    // } catch (IOException e) { 
    //     System.out.println("Une erreur s'est produite");
    // }
}
}