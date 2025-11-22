
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

  public static double getAverage(double[][] data) {
    int totalElements = 0;
    double sum = getTotal(data);
    for (double[] row : data) {
      for (double elem : row) {
        totalElements++;
      }
    }
    return sum / totalElements;
  }
  
  public static double getRowTotal(double[][] data, int row) {
    double[][] total = { data[row] };
    return getTotal(total);
  }

  public static double getColumnTotal(double[][] data, int col) {
    double accumulator = 0;

    for (int row = 0; row < data.length; row++) {
      if (col < data[row].length) {
        accumulator += data[row][col];
      }
    }
    return accumulator;
  }
  
  public static double getHighestInRow(double[][] data, int row) {
    double highestInRow = data[row][0];
    for (double elem : data[row]) {
      highestInRow = highestInRow < elem ? elem : highestInRow;
    }
    return highestInRow;
  }

  public static int getHighestInRowIndex(double[][] data, int row) {
    double highestInRow = getHighestInRow(data, row);
    int indexOfHighestNum = -1;
    for (int index = 0; index < data[row].length; index++) {
      if (data[row][index] == highestInRow) {
        indexOfHighestNum = index;
        break;
      }
    }
    return indexOfHighestNum;
  }

  public static double getLowestInRow(double[][] data, int row) { 
    double lowestInRow = data[row][0];
    for (double elem : data[row]) {
      lowestInRow = lowestInRow > elem ? elem : lowestInRow;
    }
    return lowestInRow;
  }

  public static int getLowestInRowIndex(double[][] data, int row) { 
    double lowestInRow = getLowestInRow(data, row);
    int indexOfLowestNum = -1;
    for (int index = 0; index < data[row].length; index++) {
      if (data[row][index] == lowestInRow) {
        indexOfLowestNum = index;
      }
    }
    return indexOfLowestNum;
  }

  public static double getHighestInColumn(double[][] data, int col) { 
    ArrayList<Double> highestInColumn = new ArrayList<>();
    for (int row = 0; row < data.length; row++) {
      if (col < data[row].length) {
        highestInColumn.add(data[row][col]);
      }
    }
    return Collections.max(highestInColumn);
  }

  public static int getHighestInColumnIndex(double[][] data, int col) {
    double highestInColumn = getHighestInColumn(data, col);
    int index = 0;
    for (int row = 0; row < data.length; row++) {
      if (col < data[row].length) {
        if (highestInColumn == data[row][col]) {
          index = row;
          break;
        }
      }
    }
    return index;
  }

  public static double getLowestInColumn(double[][] data, int col) {
    ArrayList<Double> lowestInColumn = new ArrayList<>();
    for (int row = 0; row < data.length; row++) {
      if (col < data[row].length) {
        lowestInColumn.add(data[row][col]);
      }
    }
    return Collections.min(lowestInColumn);
  }

  public static int getLowestInColumnIndex(double[][] data, int col) {// 14
    double lowestInColumn = getLowestInColumn(data, col);
    int index = 0;
    for (int row = 0; row < data.length; row++) {
      if (col < data[row].length) {
        if (lowestInColumn == data[row][col]) {
          index = row;
          break;
        }
      }
    }
    return index;
  }

  public static double getHighestInArray(double[][] data) {
    double highestInArray = data[0][0];
    for (double[] row : data) {
      for (double elem : row) {
        highestInArray = highestInArray < elem ? elem : highestInArray;
      }
    }
    return highestInArray;
  }

  public static double getLowestInArray(double[][] data) {
    double lowestInArray = data[0][0];
    for (double[] row : data) {
      for (double elem : row) {
        lowestInArray = lowestInArray > elem ? elem : lowestInArray;
      }
    }
    return lowestInArray;
  }

}
