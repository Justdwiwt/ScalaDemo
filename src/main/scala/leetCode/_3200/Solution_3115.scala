package leetCode._3200

import scala.math.sqrt

object Solution_3115 {
  def maximumPrimeDifference(nums: Array[Int]): Int = {
    def isPrime(n: Int): Boolean =
      n >= 2 && (2 to sqrt(n).toInt).forall(n % _ != 0)

    val i = nums.indexWhere(isPrime)
    val j = nums.lastIndexWhere(isPrime)

    j - i
  }
}
