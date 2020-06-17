package sorting.week.one;

/**
 * Implementation of the 'Merge Sort' algorithm as discussed in the lectures.
 */
public final class MergeSort {

  private MergeSort() {
  }

  public static void sort(int[] array) {
    int[] helper = new int[array.length];
    sort(array, helper, 0, array.length - 1);
  }

  private static void sort(int[] array, int[] helper, int lo, int hi) {
    if (lo < hi) {
      int mid = (lo + hi) / 2;
      sort(array, helper, lo, mid);
      sort(array, helper, mid + 1, hi);
      merge(array, helper, lo, mid, hi);
    }
  }

  private static void merge(int[] array, int[] helper, int lo, int mid, int hi) {

    // Fill up the helper array, with what is currently in the (not yet sorted), original array.
    for (int i = lo; i <= hi; i++) {
      helper[i] = array[i];
    }

    int left = lo;
    int current = lo;
    int right = mid + 1;

    // Traverse, compare, and update the original array
    while (left <= mid && right <= hi) {
      if (helper[left] <= helper[right]) {
        array[current] = helper[left];
        left++;
      } else {
        array[current] = helper[right];
        right++;
      }

      current++;
    }


    /*
     * Handle the remaining; the idea behind this is that the right array will always be copied
     * over to the original array.
     * Example: two arrays A and B, where A's elements are all greater than B's elements.
     *
     * In the above example, B would always be copied over, but A's elements would not.
     * We could make the case that if A's elements are always less than B, wouldn't we
     * forget about B's elements?
     *
     * That would be fine, since the original array would always have B's elements, anyway.
     * This is because and B are in completely sorted order when combined,
     * which means that the original array is already in sorted order.
     */
    int remaining = mid - left;
    for (int i = 0; i <= remaining; i++) {
      array[current] = helper[i + left];
      current++;
    }
  }
}