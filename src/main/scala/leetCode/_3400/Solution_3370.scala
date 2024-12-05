package leetCode._3400

import scala.math.BigInt.int2bigInt

object Solution_3370 {
  def smallestNumber(n: Int): Int =
    (1 << n.bitLength) - 1
}
