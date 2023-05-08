package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {

private String fileName; // Variable pour contenir le nom du fichier

// Constructeur sans paramètre
public WriteSymptomDataToFile() {
    this.fileName = "result.out"; 
}


public void writeSymptoms(Map<String, Integer> symptoms) {
    
    //result.write(entry.getKey());
    //result.write(entry.getValue());

    
    try {
        FileWriter fileWriter = new FileWriter("result.out"); // écrire dans le fichier result.out
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 

        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { //avec une boucle qui parcourt la map en param
            String symptom = entry.getKey();
            int occurrence = entry.getValue();
            bufferedWriter.write(symptom + " : " + occurrence); //format attendu => symptom : nb occurences
            bufferedWriter.newLine();
        }
        bufferedWriter.close(); //ne pas oublier de close

    } catch (IOException e) { //ne pas oublier le try catch
        System.out.println("Une erreur s'est produite");
    }
}
}