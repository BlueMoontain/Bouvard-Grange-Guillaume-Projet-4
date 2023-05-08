package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public ArrayList<String> getSymptoms(){
	
	ArrayList<String> symptoms = new ArrayList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line = reader.readLine();
            while (line != null) {
                symptoms.add(line);
                line = reader.readLine();
            }
            reader.close();
        } 
        
		catch (IOException e) { 
				System.out.println("Une erreur s'est produite");
			}
		
		return symptoms ; //avant result
		//{'headache','cold',...}
	}

}