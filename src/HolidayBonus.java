public class HolidayBonus {

  private static final double HIGHEST_BONUS = 5000;
  private static final double LOWEST_BONUS = 1000;
  private static final double OTHER_BONUS = 2000;

  public static double[] calculateHolidayBonus(double[][] data) {
    double[] bonuses = new double[data.length];
    int maxCols = 0;
    for (int row = 0; row < data.length; row++) {
      if (data[row].length > maxCols) {
        maxCols = data[row].length;
      }
    }

    for (int col = 0; col < maxCols; col++) {
      double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
      double lowestPositive = Double.POSITIVE_INFINITY;
      int positiveCount = 0;
      int positiveIndex = -1;

      for (int row = 0; row < data.length; row++) {
        if (col >= data[row].length) {
          continue;
        }
        double value = data[row][col];
        if (value > 0) {
          if (value < lowestPositive) {
            lowestPositive = value;
          }
          if (positiveIndex == -1) {
            positiveIndex = row;
          }
          positiveCount++;
        }
      }

      if (positiveCount == 0) {
        continue;
      }

      for (int row = 0; row < data.length; row++) {
        if (col >= data[row].length) {
          continue;
        }
        double value = data[row][col];
        if (value <= 0) {
          continue;
        }
        if (positiveCount == 1) {
          bonuses[positiveIndex] += HIGHEST_BONUS;
          break;
        } else if (value == highest) {
          bonuses[row] += HIGHEST_BONUS;
        } else if (value == lowestPositive) {
          bonuses[row] += LOWEST_BONUS;
        } else {
          bonuses[row] += OTHER_BONUS;
        }
      }
    }
    return bonuses;
  }

  public static double calculateTotalHolidayBonus(double[][] data) {
    double[] bonuses = calculateHolidayBonus(data);
    double[][] as2d = { bonuses };
    return TwoDimRaggedArrayUtility.getTotal(as2d);
  }
}
