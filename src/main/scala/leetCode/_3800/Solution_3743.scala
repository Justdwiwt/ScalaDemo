package leetCode._3800

object Solution_3743 {
  @inline def fmax(a: Long, b: Long): Long =
    if (a > b) a else b

  def maximumScore(nums: Array[Int], k: Int): Long = {

    def profit(arr: Array[Int]): Long = {
      val NEG = Long.MinValue / 4
      val f = Array.fill(k + 2, 3)(NEG)
      (1 to k + 1).foreach(f(_)(0) = 0L)

      arr.foreach(p => {
        (k + 1 to 1 by -1).foreach(j => {
          f(j)(0) = fmax(f(j)(0), fmax(f(j)(1) + p, f(j)(2) - p))
          f(j)(1) = fmax(f(j)(1), f(j - 1)(0) - p)
          f(j)(2) = fmax(f(j)(2), f(j - 1)(0) + p)
        })
      })
      f(k + 1)(0)
    }

    val i = nums.indices.maxBy(nums)
    fmax(
      profit(nums.drop(i) ++ nums.take(i)),
      profit(nums.drop(i + 1) ++ nums.take(i + 1))
    )
  }
}
