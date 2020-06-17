package sorting.week.three;

/**
 * Sorts a distinct array of integers, using the first element of the array as a pivot.
 */
public final class QuickSortPivotFirst {

  private QuickSortPivotFirst() {
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
    int pivot = array[lo];
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
