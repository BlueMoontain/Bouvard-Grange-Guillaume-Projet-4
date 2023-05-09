/**
 * Reads symptom data from a file and returns a list of symptoms.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
  private String filepath;

  /**
   * Constructs a new `ReadSymptomDataFromFile` instance.
   *
   * @param filepath a full or partial path to file with symptom strings in it, one per line
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  /**
   * Reads the symptom data from the file and returns a list of symptoms.
   *
   * @return an ArrayList of String objects representing the symptoms
   */
  @Override
  public ArrayList<String> getSymptoms() {
    ArrayList<String> symptoms = new ArrayList<String>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
      String line = reader.readLine();
      while (line != null) {
        symptoms.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.out.println("Une erreur s'est produite");
    }

    return symptoms;
  }
}
