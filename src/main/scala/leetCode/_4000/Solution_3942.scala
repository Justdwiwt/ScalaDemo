package leetCode._4000

object Solution_3942 {
  def minOperations(nums: Array[Int]): Int = {
    val n = nums.length
    val z = nums.indexOf(0)
    val breaks = nums.zip(nums.last +: nums.init).count { case (a, b) => (a - b).abs > 1 }

    if (breaks > 1) -1
    else if (nums((z + 1) % n) > 1) (z + 2).min(n - z)
    else z.min(n - z + 2)
  }
}
