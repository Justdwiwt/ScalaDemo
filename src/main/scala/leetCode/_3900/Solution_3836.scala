package leetCode._3900

object Solution_3836 {
  def maxScore(nums1: Array[Int], nums2: Array[Int], k: Int): Long = {

    val m = nums1.length
    val n = nums2.length
    val negInf = Long.MinValue / 4

    type Key = (Int, Int, Int)

    def dfs(t: Int, i: Int, j: Int, memo: Map[Key, Long]): (Long, Map[Key, Long]) = {
      if (t == 0) return (0L, memo)
      if (i < 0 || j < 0) return (negInf, memo)
      if (i + 1 < t || j + 1 < t) return (negInf, memo)

      val key = (t, i, j)

      memo.get(key) match {
        case Some(v) => (v, memo)

        case None =>
          val (r1, m1) = dfs(t, i - 1, j, memo)
          val (r2, m2) = dfs(t, i, j - 1, m1)
          val (r3Base, m3) = dfs(t - 1, i - 1, j - 1, m2)

          val r3 =
            if (r3Base == negInf) negInf
            else r3Base + nums1(i).toLong * nums2(j)

          val res = List(r1, r2, r3).max
          (res, m3 + (key -> res))
      }
    }

    dfs(k, m - 1, n - 1, Map.empty)._1
  }
}
