package leetCode._3400

object Solution_3376 {
  def findMinimumTime(strength: List[Int], k: Int): Int = {
    val n = strength.length
    val arr = Array.fill(1 << n)(0)
    (1 until (1 << n)).foreach(i => {
      val x = 1 + k * (n - Integer.bitCount(i))
      arr(i) = strength
        .indices
        .collect { case j if ((i >> j) & 1) == 1 => arr(i ^ (1 << j)) + (strength(j) - 1) / x }
        .min + 1
    })

    arr((1 << n) - 1)
  }
}
