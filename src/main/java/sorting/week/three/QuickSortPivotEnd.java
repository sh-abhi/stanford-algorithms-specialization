package sorting.week.three;

/**
 * Sorts a distinct array of integers, using the last element of the array as a pivot.
 */
public final class QuickSortPivotEnd {

  private QuickSortPivotEnd() {
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

  private static int partition(int[] array, int lo, int hi) {
    int pivot = array[hi];
    array[hi] = array[lo];
    array[lo] = pivot;

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
}
