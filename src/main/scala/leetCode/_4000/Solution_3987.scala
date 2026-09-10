package leetCode._4000

object Solution_3987 {
  def minimumCost(nums: Array[Int], k: Int): Int = {
    val mod = 1000000007L
    val s = (nums.foldLeft(0L)(_ + _) - 1) / k

    ((s % mod) * ((s + 1) % mod) / 2 % mod).toInt
  }
}
