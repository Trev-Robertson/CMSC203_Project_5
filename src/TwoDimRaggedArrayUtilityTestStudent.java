import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	
	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

  @Test
	public void testReadFile() throws IOException {
		File tempFile = File.createTempFile("dataSetTemp", ".txt");
		tempFile.deleteOnExit();
		Files.writeString(tempFile.toPath(), "7.2 2.5 9.3 4.8\r\n" +
				"5.9\r\n" +
				"8.1 1.7 3.3\r\n" +
				"11.6 6.9 7.3 2.7\r\n" +
				"-4.2 7.3 -5.9 2.6");

		double[][] expected = {
				{ 7.2, 2.5, 9.3, 4.8 },
				{ 5.9 },
				{ 8.1, 1.7, 3.3 },
				{ 11.6, 6.9, 7.3, 2.7 },
				{ -4.2, 7.3, -5.9, 2.6 }
		};

		assertTrue(Arrays.deepEquals(expected, TwoDimRaggedArrayUtility.readFile(tempFile)));
	}
	
	// @Test
	// public void writeToFile() throws IOException {
	// 	File tempFile = File.createTempFile("numsTempFile", ".txt");
	// 	tempFile.deleteOnExit();
	// 	double[][] data = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9 }, { 10 }, { 11, 12, 13, 14 }, { 15.0, 17.18, 18.20 } };
	// 	String expected
	// }

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	// @Test
	// public void testGetRowTotal() {
	// 	assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	// }
}
