public class HolidayBonus {

  private static final double HIGHEST_BONUS = 5000.0;
  private static final double LOWEST_BONUS = 1000.0;
  private static final double OTHER_BONUS = 2000.0;

  public static double[] calculateHolidayBonus(double[][] data) {
    double[] bonuses = new double[data.length];
    int maxCols = 0;
    for (double[] row : data) {
      if (row.length > maxCols) {
        maxCols = row.length;
      }
    }

    for (int col = 0; col < maxCols; col++) {
      double highest = Double.NEGATIVE_INFINITY;
      double lowest = Double.POSITIVE_INFINITY;

      // find highest and lowest for this column
      for (double[] row : data) {
        if (col < row.length && row[col] > highest) {
          highest = row[col];
        }
        if (col < row.length && row[col] < lowest) {
          lowest = row[col];
        }
      }

      for (int row = 0; row < data.length; row++) {
        if (col >= data[row].length) {
          continue;
        }
        double value = data[row][col];
        if (value <= 0) {
          continue; // no bonus for non-positive values
        }
        if (value == highest) {
          bonuses[row] += HIGHEST_BONUS;
        } else if (value == lowest) {
          bonuses[row] += LOWEST_BONUS;
        } else {
          bonuses[row] += OTHER_BONUS;
        }
      }
    }
    return bonuses;
  }

  public static double calculateTotalHolidayBonus(double[][] data) {
    double total = 0;
    for (double bonus : calculateHolidayBonus(data)) {
      total += bonus;
    }
    return total;
  }
}
