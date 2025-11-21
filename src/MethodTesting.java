import java.io.*;

public class MethodTesting {
  public static void main(String[] args) throws IOException {
    double[][] sampData = {
        { 1, 2, 3, 4, 5, 6 },
        { 7, 8, 9 },
        { 10 },
        { 11, 12, 13, 14 },
        { 15.0, 17.18, 18.20 }
    };
    File numsFile = new File("nums.txt");
    numsFile.createNewFile();
    FileWriter outputFile = new FileWriter(numsFile); // ADD TRUE IF NEEDS TO BE APPENDING
    for (int row = 0; row < sampData.length; row++) {
      for (int index = 0; index < sampData[row].length; index++) {
        outputFile.write(String.valueOf(sampData[row][index]) + " ");
      }
      outputFile.write("\n");
    }
    outputFile.close();
  }

}
