package sorting.week.three;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

  private static final String TEST_INPUT_FILE_PATH = "src/test/resources/QuickSort.txt";

  @Test
  void testBaseCaseFirstElementPivot() {
    int[] input = new int[]{10, 2, 1, 5, 4, 6, 8, 9, 7, 3};
    QuickSortPivotFirst.sort(input);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, input);
  }

  @Test
  void testBaseCaseLastElementPivot() {
    int[] input = new int[]{10, 2, 1, 5, 4, 6, 8, 9, 7, 3};
    QuickSortPivotEnd.sort(input);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, input);
  }

  @Test
  void testBaseCaseMedianOfThreePivot() {
    int[] input = new int[]{10, 2, 1, 5, 4, 6, 8, 9, 7, 3};
    QuickSortPivotMedian.sort(input);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, input);
  }

  @Test
  void testFirstElementPivot() {
    int[] input = QuickSortUtil.readFromTxtFile(TEST_INPUT_FILE_PATH);
    QuickSortPivotFirst.sort(input);
    int[] expected = new int[10_000];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = i + 1;
    }

    assertArrayEquals(expected, input);
  }

  @Test
  void testLastElementPivot() {
    int[] input = QuickSortUtil.readFromTxtFile(TEST_INPUT_FILE_PATH);
    QuickSortPivotEnd.sort(input);
    int[] expected = new int[10_000];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = i + 1;
    }

    assertArrayEquals(expected, input);
  }

  @Test
  void testCountWithFirstPivot() {
    long expected = 162_085;
    int[] input = QuickSortUtil.readFromTxtFile(TEST_INPUT_FILE_PATH);
    long result = QuickSortPivotFirstCounter.sort(input);
    int[] expectedArray = new int[10_000];
    for (int i = 0; i < expectedArray.length; i++) {
      expectedArray[i] = i + 1;
    }

    assertArrayEquals(expectedArray, input);
    assertEquals(expected, result);
  }

  @Test
  void testCountWithEndPivot() {
    long expected = 164_123;
    int[] input = QuickSortUtil.readFromTxtFile(TEST_INPUT_FILE_PATH);
    long result = QuickSortPivotEndCounter.sort(input);
    int[] expectedArray = new int[10_000];
    for (int i = 0; i < expectedArray.length; i++) {
      expectedArray[i] = i + 1;
    }

    assertArrayEquals(expectedArray, input);
    assertEquals(expected, result);
  }

  @Test
  void testCountWithMedianPivot() {
    long expected = 138_382;
    int[] input = QuickSortUtil.readFromTxtFile(TEST_INPUT_FILE_PATH);
    long result = QuickSortPivotMedianCounter.sort(input);
    int[] expectedArray = new int[10_000];
    for (int i = 0; i < expectedArray.length; i++) {
      expectedArray[i] = i + 1;
    }

    assertArrayEquals(expectedArray, input);
    assertEquals(expected, result);
  }
}