package sorting.week.one;

import java.math.BigInteger;

/**
 * The Karatsuba algorithm aims to be a faster multiplication algorithm
 * compared to the 'traditional' algorithm used when multiplying two n-digit
 * numbers.
 * <p>
 * The running time of the algorithm is roughly n^1.58, where the 'traditional'
 * algorithm is n^2.
 */
public final class Karatsuba {

  private Karatsuba() {
  }

  /**
   * x = 10^(n/2) * a + b
   * y = 10^(n/2) * c + d
   * <p>
   * x * y = (10^(n/2) * a + b) * (10^(n/2) * c + d)
   * x * y = 10^(n) * ac + 10^(n/2) * (ad + bc) + bd
   */
  public static String multiply(String x, String y) {
    BigInteger xBigInt = new BigInteger(x);
    BigInteger yBigInt = new BigInteger(y);

    int n = Math.max(xBigInt.bitLength(), yBigInt.bitLength());
    if (n <= 1) return xBigInt.multiply(yBigInt).toString();

    if (n % 2 == 0) {
      n = n / 2;
    } else {
      n = n / 2 + 1;
    }

    BigInteger a, b, c, d, ac, ad, bc, bd, abcd;

    b = xBigInt.shiftRight(n);
    a = xBigInt.subtract(b.shiftLeft(n));
    d = yBigInt.shiftRight(n);
    c = yBigInt.subtract(d.shiftLeft(n));

    ac = new BigInteger(multiply(a.toString(), c.toString()));
    bd = new BigInteger(multiply(b.toString(), d.toString()));
    ad = new BigInteger(multiply(a.toString(), d.toString()));
    bc = new BigInteger(multiply(b.toString(), c.toString()));
    abcd = new BigInteger(ad.add(bc).toString());

    return ac.add(abcd.shiftLeft(n)).add(bd.shiftLeft(2 * n)).toString();
  }
}