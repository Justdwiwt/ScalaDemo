package leetCode._2700

object Solution_2614 {
  def diagonalPrime(nums: Array[Array[Int]]): Int = {
    def isPrime(n: Int): Boolean =
      n > 1 && (n == 2 || (n % 2 != 0 && (3 to math.sqrt(n).toInt by 2).forall(n % _ != 0)))

    nums
      .indices
      .flatMap(i => Seq(nums(i)(i), nums(nums.length - 1 - i)(i)))
      .filter(isPrime)
      .reduceOption(_.max(_))
      .getOrElse(0)
  }
}
