package leetCode._2100

object Solution_2067 {
  private def valid(a: Array[Int], b: Array[Int], cnt: Int): Boolean =
    (0 until 26).forall(i => {
      val diff = b(i) - a(i)
      diff <= 0 || diff == cnt
    })

  def equalCountSubstrings(s: String, count: Int): Int = {
    val n = s.length
    val dp = Array.ofDim[Int](n + 1, 26)

    def cal(i: Int, k: Int): Int =
      if (i - k * count < 0) 0
      else if (valid(dp(i - k * count), dp(i), count)) 1 + cal(i, k + 1)
      else cal(i, k + 1)

    (1 to n).foldLeft(0)((acc, i) => {
      dp(i)(s(i - 1) - 'a') += 1
      (0 until 26).foreach(j => dp(i)(j) += dp(i - 1)(j))
      acc + cal(i, 1)
    })
  }
}
