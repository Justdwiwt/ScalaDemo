package leetCode

import java.math.BigInteger

object Code_16_09 {

  class Operations() {

    def minus(a: Int, b: Int): Int = {
      BigInteger.valueOf(a).subtract(BigInteger.valueOf(b)).intValue()
    }

    def multiply(a: Int, b: Int): Int = {
      BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).intValue()
    }

    def divide(a: Int, b: Int): Int = {
      BigInteger.valueOf(a).divide(BigInteger.valueOf(b)).intValue()
    }

  }

}
