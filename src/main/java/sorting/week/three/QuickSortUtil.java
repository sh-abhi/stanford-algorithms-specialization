package sorting.week.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSortUtil {

  private QuickSortUtil() {
  }

  public static int[] readFromTxtFile(String path) {
    int[] array = new int[10_000];
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
