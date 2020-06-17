package sorting.week.three;

/**
 * Sorts a distinct array of integers, while choosing the median of three as the pivot.
 */
public final class QuickSortPivotMedian {

  private QuickSortPivotMedian() {
  }

  public static void sort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int lo, int hi) {
    if (lo < hi) {
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
