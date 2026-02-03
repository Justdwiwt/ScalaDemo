package leetCode._3900

object Solution_3801 {
  def minMergeCost(lists: Array[Array[Int]]): Long = {
    val n = lists.length
    val U = 1 << n
    val INF = Long.MaxValue / 4

    val sorted = (0 until U).foldLeft(Array.fill(U)(Vector.empty[Int])) { (arr, s) =>
      val lsb = s & -s
      if (lsb == 0) arr
      else {
        val i = Integer.numberOfTrailingZeros(lsb)
        arr.updated(s, (arr(s ^ lsb) ++ lists(i)).sorted)
      }
    }

    def bestSplit(i: Int, j: Int, dp: Array[Long]): Long =
      if (j <= (i ^ j)) INF
      else {
        val k = i ^ j
        val sj = sorted(j)
        val sk = sorted(k)
        val mj = sj((sj.length - 1) / 2)
        val mk = sk((sk.length - 1) / 2)
        val cost = dp(j) + dp(k) + math.abs(mj - mk)
        math.min(cost, bestSplit(i, (j - 1) & i, dp))
      }

    val f = (0 until U).foldLeft(Array.fill[Long](U)(INF)) { (dp, i) =>
      val v =
        if ((i & (i - 1)) == 0) 0L
        else {
          val j0 = i & (i - 1)
          bestSplit(i, j0, dp) + sorted(i).length
        }
      dp.updated(i, v)
    }

    f(U - 1)
  }
}
