import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HolidayBonusStudentTest {

  @Test
  public void testCalculateHolidayBonus() {
    double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
    double[] expected = { 3000.0, 4000.0, 15000.0 };
    assertArrayEquals(expected, HolidayBonus.calculateHolidayBonus(data), 0.001);
  }

  @Test
  public void testCalculateTotalHolidayBonus() {
    double[][] data = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
    assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(data), 0.001);
  }
}
