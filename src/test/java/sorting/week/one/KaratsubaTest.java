package sorting.week.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KaratsubaTest {

  @Test
  void testMultiplyBaseCase() {
    String result = Karatsuba.multiply("2", "2");
    Assertions.assertNotNull(result);
    Assertions.assertTrue(result.equals("4"));
  }

  @Test
  void testMultiplyByZero() {
    String result = Karatsuba.multiply("328937981272137912847123987314901273012987217301231720", "0");
    Assertions.assertNotNull(result);
    Assertions.assertTrue(result.equals("0"));
  }

  @Test
  void testMultiplyLectureExample() {
    String result = Karatsuba.multiply("5678", "1234");
    Assertions.assertNotNull(result);
    Assertions.assertTrue(result.equals("7006652"));
  }

  @Test
  void testMultiplyWithAssignmentInputs() {
    String result = Karatsuba.multiply("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627");
    Assertions.assertNotNull(result);
    Assertions.assertTrue(result.equals("8539734222673567065463550869546574495034888535765114961879601127067743044893204848617875072216249073013374895871952806582723184"));
  }

}