import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodTesting {
  public static void main(String[] args) throws IOException {
    double[][] sampData = {
        { 1, 2, 3, 4, 5, 6 },
        { 7, 8, 9 },
        { 10 },
        { 11, 12, 13, 14 },
        { 15.0, 17.18, 18.20 }
    };

    double sum = getTotal(sampData);

    System.out.print(sum);
    double[][] d = {
        { 13.0, 24.0, 3.0, 4.0, 5.0, 1.9 },
        { 7.0, 8.0, 900.0 },
        { 10.0 },
        { 11.0, 122.0, 13.0, 14.0 },
        { 150.0, 17.18, 18.2 }
    };
  }
  

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
    }
  }

  public static void writeToFile(double[][] data, File file) throws IOException {
    try (FileWriter outputFile = new FileWriter(file, true)) {
      for (int row = 0; row < data.length; row++) {
        for (int index = 0; index < data[row].length; index++) {
          outputFile.write(data[row][index] + " ");
        }
      }
    }
  }

  public static double getTotal(double[][] data) {
    double sumOfArray = 0;
    for (int row = 0; row < data.length; row++) {
      for (int index = 0; index < data[row].length; index++) {
        sumOfArray += data[row][index];
      }
    }
    return sumOfArray;
  }

}
