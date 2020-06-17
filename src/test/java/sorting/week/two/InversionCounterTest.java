package sorting.week.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InversionCounterTest {

  @Test
  void testCountInversions() {
    long expected = 2407905288L;
    int[] input = InversionCounter.readFromTxtFile("src/test/resources/IntegerArray.txt");
    long result = InversionCounter.countInversionsBruteForce(input);
    assertEquals(expected, result);
  }

  @Test
  void testCountInversionsOptimized() {
    long expected = 2407905288L;
    int[] input = InversionCounter.readFromTxtFile("src/test/resources/IntegerArray.txt");
    long result = InversionCounter.countInversionsOptimized(input);
    assertEquals(expected, result);
  }
}