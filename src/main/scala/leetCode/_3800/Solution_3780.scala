package leetCode._3800

object Solution_3780 {
  def maximumSum(nums: Array[Int]): Int = {
    val K = 3
    val MOD = 3
    val negInf = Int.MinValue / 2

    val init = Array.fill(K + 1, MOD)(negInf)
    init(0)(0) = 0

    val dp = nums.foldLeft(init)((f, x) => {
      val g = f.map(_.clone)
      (K to 1 by -1).foreach(j => (0 until MOD).foreach(r => {
        val prev = f(j - 1)((r - x % MOD + MOD) % MOD)
        g(j)(r) = math.max(g(j)(r), prev + x)
      }))
      g
    })

    math.max(dp(3)(0), 0)
  }
}
