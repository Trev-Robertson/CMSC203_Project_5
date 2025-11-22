import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;

public class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8,9}};
	private double[][] d = {
			{ 13.0, 24.0, 3.0, 4.0, 5.0, 1.9 },
			{ 7.0, 8.0, 900.0 },
			{ 10.0 },
			{ 11.0, 122.0, 13.0, 14.0 },
			{ 150.0, 17.18, 18.2 }
	};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

  @Test
	public void testReadFile() throws IOException {
		File tempFile = File.createTempFile("dataSetTemp", ".txt");
		tempFile.deleteOnExit();
		Files.write(tempFile.toPath(), ("7.2 2.5 9.3 4.8\r\n" +
				"5.9\r\n" +
				"8.1 1.7 3.3\r\n" +
				"11.6 6.9 7.3 2.7\r\n" +
				"-4.2 7.3 -5.9 2.6").getBytes(StandardCharsets.UTF_8));

		double[][] expected = {
				{ 7.2, 2.5, 9.3, 4.8 },
				{ 5.9 },
				{ 8.1, 1.7, 3.3 },
				{ 11.6, 6.9, 7.3, 2.7 },
				{ -4.2, 7.3, -5.9, 2.6 }
		};

		assertTrue(Arrays.deepEquals(expected, TwoDimRaggedArrayUtility.readFile(tempFile)));
	}
	
	@Test
	public void testGetRowTotalDataSetD() {
		assertEquals(185.38, TwoDimRaggedArrayUtility.getRowTotal(d, 4), 0.001);
		assertEquals(160.0, TwoDimRaggedArrayUtility.getRowTotal(d, 3), 0.001);
	}

	/**
	 * Test getRowTotal method
	 * Returns the total of all the elements of row 1.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotalDataSet1() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
	}
}
