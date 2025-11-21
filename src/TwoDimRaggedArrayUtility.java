
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class TwoDimRaggedArrayUtility {

  public static double[][] readFile(File file) throws FileNotFoundException {
    try (Scanner inputFile = new Scanner(file)) {
      ArrayList<double[]> strArray = new ArrayList<>();
      while (inputFile.hasNext()) {
        String[] currentString = inputFile.nextLine().split(" ");
        double[] innerArray = new double[currentString.length];
        for (int index = 0; index < currentString.length; index++) {
          innerArray[index] = Double.parseDouble(currentString[index]);
        }
        strArray.add(innerArray);
      }

      double[][] raggedArray = new double[strArray.size()][];

      for (int row = 0; row < strArray.size(); row++) {
        raggedArray[row] = new double[strArray.get(row).length];
        System.arraycopy(strArray.get(row), 0, raggedArray[row], 0, strArray.get(row).length);
      }
      return raggedArray;
    } catch (Exception e) {
      throw e;
    }
  }
  
  public static void writeToFile(double[][] data, File file) throws IOException {
    FileWriter outputFile = new FileWriter(file, true);
    for (double[] row : data) {
      for (int index = 0; index < row.length; index++)
        outputFile.write(String.valueOf(data[index]));
    }
    System.out.println();
  }

}
