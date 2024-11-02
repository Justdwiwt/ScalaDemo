package leetCode._3400

import scala.collection.mutable

// fixme: case 615/622 memory limit exceeded
object Solution_3336 {
  val M: BigInt = BigInt("1000000007")

  def subsequencePairCount(nums: Array[Int]): Int = {
    val n = nums.length
    val cache = mutable.Map[(Int, Int, Int), BigInt]()

    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    def dfs(i: Int, j: Int, k: Int): BigInt =
      if (i < 0) {
        if (j == k) BigInt(1) else BigInt(0)
      } else cache
        .getOrElseUpdate((i, j, k), (dfs(i - 1, j, k) + dfs(i - 1, gcd(j, nums(i)), k) + dfs(i - 1, j, gcd(k, nums(i)))) % M)

    ((dfs(n - 1, 0, 0) - 1 + M) % M).toInt
  }
}
