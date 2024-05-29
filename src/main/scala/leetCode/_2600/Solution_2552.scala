package leetCode._2600

object Solution_2552 {
  def countQuadruplets(nums: Array[Int]): Long = {
    val n = nums.length
    val great = Array.ofDim[Int](n, n + 1)

    (n - 2 to 0 by -1).foreach(k => {
      great(k) = great(k + 1).clone()
      (nums(k + 1) - 1 to 0 by -1).foreach(great(k)(_) += 1)
    })

    var res = 0L
    (1 until n - 2).foreach(j => (j + 1 until n - 1).foreach(k => {
      val x = nums(k)
      if (nums(j) > x) res += (x - n + 1 + j + great(j)(x)) * great(k)(nums(j))
    }))
    res
  }
}
