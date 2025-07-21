package leetCode._3600

object Solution_3575 {
  def goodSubtreeSum(vals: Array[Int], par: Array[Int]): Int = {
    val n = vals.length
    val M = 1000000007
    val children = Array.fill(n)(collection.mutable.ArrayBuffer[Int]())
    vals.indices.drop(1).foreach(i => children(par(i)) += i)

    val best = Array.fill(n)(0L)

    def dfs(u: Int): Array[Long] = {
      val dp = Array.fill(1 << 10)(Long.MinValue)
      dp(0) = 0L
      val s = vals(u).toString
      val mask = s.foldLeft(0)((m, c) =>
        if (m >= 0 && ((m >> (c - '0')) & 1) == 0) m | (1 << (c - '0'))
        else -1
      )
      if (mask >= 0) dp(mask) = vals(u).toLong

      children(u).foreach(v => {
        val cd = dfs(v)
        val nd = Array.fill(1 << 10)(Long.MinValue)
        (0 until (1 << 10))
          .withFilter(dp(_) >= 0)
          .foreach(m1 => (0 until (1 << 10))
            .withFilter(m2 => cd(m2) >= 0 && (m1 & m2) == 0)
            .foreach(m2 => {
              val m = m1 | m2
              val s = dp(m1) + cd(m2)
              if (s > nd(m)) nd(m) = s
            })
          )
        (0 until (1 << 10)).foreach(m => if (dp(m) >= 0 && dp(m) > nd(m)) nd(m) = dp(m))
        dp.indices.foreach(m => dp(m) = nd(m))
      })

      best(u) = dp.max
      dp
    }

    dfs(0)
    best.foldLeft(0L)((sum, x) => (sum + x) % M).toInt
  }
}
