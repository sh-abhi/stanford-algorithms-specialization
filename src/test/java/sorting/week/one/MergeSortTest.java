package sorting.week.one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

  @Test
  void testEmptyArray() {
    int[] actual = new int[]{};
    int[] expected = new int[]{};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testSingleElementArray() {
    int[] actual = new int[]{100};
    int[] expected = new int[]{100};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testArrayOfSizeTwo() {
    int[] actual = new int[]{100, 1};
    int[] expected = new int[]{1, 100};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testShorterLengthArray() {
    int[] actual = new int[]{7, 3, 5, 4, 1, 2};
    int[] expected = new int[]{1, 2, 3, 4, 5, 7};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testMediumLengthArray() {
    int[] actual = new int[]{100, 7, 15, 11, 20, 21, 25, 40};
    int[] expected = new int[]{7, 11, 15, 20, 21, 25, 40, 100};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testLongerLengthArray() {
    int[] actual = new int[]{43, 99, 100, 21, 27, 13, 58, 76, 67, 88, 80, 49, 12, 12, 1, 63, 83, 95, 1000, 300, 2};
    int[] expected = new int[]{1, 2, 12, 12, 13, 21, 27, 43, 49, 58, 63, 67, 76, 80, 83, 88, 95, 99, 100, 300, 1000};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testArrayWithNegativeNumbers() {
    int[] actual = new int[]{-16, Integer.MIN_VALUE, Integer.MAX_VALUE, -33, -111, 20, -1, 80};
    int[] expected = new int[]{Integer.MIN_VALUE, -111, -33, -16, -1, 20, 80, Integer.MAX_VALUE};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  void testCompletelyOutOfOrder() {
    int[] actual = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    MergeSort.sort(actual);
    assertArrayEquals(expected, actual);
  }

}