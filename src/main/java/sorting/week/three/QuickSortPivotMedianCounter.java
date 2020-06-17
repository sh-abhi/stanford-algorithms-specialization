package sorting.week.three;

/**
 * An implementation of the 'Quick Sort' algorithm, but counts
 * the total number of comparisons used to sort a given array
 * following the 'median-of-three' pivot rule.
 * <p>
 * This is part of programming assignment #3, where the prompt
 * states to count the number of comparisons when sorting the
 * numbers found in QuickSort.txt (found in the test/resources
 * folder).
 */
public final class QuickSortPivotMedianCounter {

  private QuickSortPivotMedianCounter() {
  }

  private static long counter = 0;

  public static long sort(int[] array) {
    sort(array, 0, array.length - 1);
    return counter;
  }

  private static void sort(int[] array, int lo, int hi) {
    if (lo < hi) {
      counter += (hi - lo);
      int partition = partition(array, lo, hi);
      sort(array, lo, partition - 1);
      sort(array, partition + 1, hi);
    }
  }

  private static int choosePivot(int lo, int mid, int hi) {
    if ((lo - mid) * (hi - lo) >= 0) {
      return lo;
    }

    if ((mid - lo) * (hi - mid) >= 0) {
      return mid;
    }

    return hi;
  }


  private static int partition(int[] array, int lo, int hi) {
    int median = findMedian(array, lo, hi);
    int pivot = choosePivot(array[lo], array[hi], median);

    for (int k = 0; k < array.length; k++) {
      if (array[k] == pivot) {
        // Index of pivot found
        array[k] = array[lo];
        array[lo] = pivot;
      }
    }

    int i = lo + 1;
    for (int j = lo + 1; j <= hi; j++) {
      if (array[j] < pivot) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
        i++;
      }
    }

    array[lo] = array[i - 1];
    array[i - 1] = pivot;
    return i - 1;
  }

  private static int findMedian(int[] array, int lo, int hi) {
    int distance = hi + lo;
    int midpoint = distance / 2;
    return array[midpoint];
  }
}
