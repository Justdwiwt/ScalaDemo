package leetCode._3600

object Solution_3591 {
  def checkPrimeFrequency(nums: Array[Int]): Boolean = nums
    .groupBy(identity)
    .values
    .exists(x => isPrime(x.length))

  private def isPrime(num: Int): Boolean =
    if (num < 2) false
    else (2 until num).forall(num % _ != 0)
}
