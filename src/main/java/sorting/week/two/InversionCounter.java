package sorting.week.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * While an implementation of the 'Merge Sort' algorithm, {@link InversionCounter}
 * aims to count the number of inversions within each subarray.
 * <p>
 * This is the solution for the second programming assignment. The prompt is as follows:
 * <p>
 * "This file contains all of the 100,000 integers between 1 and 100,000 (inclusive)
 * in some order, with no integer repeated. Your task is to compute the number of inversions
 * in the file given, where the ith row of the file indicates the ith entry of an array.
 * Because of the large size of this array, you should implement the fast
 * divide-and-conquer algorithm covered in the video lectures."
 */
public final class InversionCounter {

  private InversionCounter() {
  }

  public static long countInversionsOptimized(int[] array) {
    int[] helper = new int[array.length];
    long numberOfInversions = countInversionsOptimized(array, helper, 0, array.length - 1);
    return numberOfInversions;
  }

  private static long countInversionsOptimized(int[] array, int[] helper, int lo, int hi) {
    long numberOfInversions = 0;

    if (lo < hi) {
      int mid = (lo + hi) / 2;
      numberOfInversions += countInversionsOptimized(array, helper, lo, mid);
      numberOfInversions += countInversionsOptimized(array, helper, mid + 1, hi);
      numberOfInversions += count(array, helper, lo, mid, hi);
    }

    return numberOfInversions;
  }

  private static long count(int[] array, int[] helper, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) {
      helper[i] = array[i];
    }

    int left = lo;
    int right = mid + 1;
    int count = lo;
    long numberOfInversions = 0;

    while (left <= mid && right <= hi) {
      if (helper[left] <= helper[right]) {
        array[count] = helper[left];
        left++;
      } else {
        array[count] = helper[right];
        numberOfInversions += (mid + 1 - left);
        right++;
      }

      count++;
    }

    int remaining = mid - left;
    for (int i = 0; i <= remaining; i++) {
      array[count] = helper[left + i];
      count++;
    }

    return numberOfInversions;
  }

  public static long countInversionsBruteForce(int[] array) {
    long numberOfInversions = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] > array[j]) {
          numberOfInversions++;
        }
      }
    }
    return numberOfInversions;
  }

  public static int[] readFromTxtFile(String path) {
    int[] array = new int[100_000];
    int count = 0;
    try {
      File file = new File(path);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextInt()) {
        array[count] = scanner.nextInt();
        count++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    return array;
  }
}
