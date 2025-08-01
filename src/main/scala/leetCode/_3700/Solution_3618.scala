package leetCode._3700

object Solution_3618 {
  def splitArray(nums: Array[Int]): Long = {
    val (primes, nonPrimes) = nums.zipWithIndex.partition(_._2.isPrime)
    math.abs(primes.longSum - nonPrimes.longSum)
  }

  implicit class Prime(i: Int) {
    def isPrime: Boolean =
      if (i == 2 || i == 3) true
      else if (i % 2 == 0 || i == 1) false
      else loop(2, math.sqrt(i).toInt)

    def loop(value: Int, j: Int): Boolean =
      if (value > j) true
      else if (i % value == 0) false
      else loop(value + 1, j)
  }

  implicit class LongSum(array: Array[(Int, Int)]) {
    def longSum: Long = array.foldLeft(0L) {
      case (sum, (v, _)) => sum + v.toLong
    }
  }
}
