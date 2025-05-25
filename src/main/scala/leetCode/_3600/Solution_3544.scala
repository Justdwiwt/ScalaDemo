package leetCode._3600

object Solution_3544 {
  def subtreeInversionSum(edges: Array[Array[Int]], nums: Array[Int], k: Int): Long = {
    val n = nums.length
    val tree = Array.fill[List[Int]](n)(List())
    edges
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(u, v) =>
        tree(u) = v :: tree(u)
        tree(v) = u :: tree(v)
      }

    val dp = Array.fill[Long](n, 2, k + 1)(Long.MinValue)

    def dfs(u: Int, parent: Int): Unit = {
      tree(u)
        .withFilter(_ != parent)
        .foreach(dfs(_, u))

      (0 to 1).foreach(flipped => (0 to k).foreach(dist => {
        val base: Long = if (flipped == 1) -nums(u).toLong else nums(u).toLong
        var totalNoFlip: Long = base

        tree(u)
          .withFilter(_ != parent)
          .foreach(v => {
            val nextDist = if (dist < k) dist + 1 else k
            totalNoFlip += dp(v)(flipped)(nextDist)
          })

        dp(u)(flipped)(dist) = totalNoFlip

        if (dist >= k) {
          val flippedVal: Long = if (flipped == 1) nums(u).toLong else -nums(u).toLong
          var totalFlip: Long = flippedVal

          tree(u)
            .withFilter(_ != parent)
            .foreach(totalFlip += dp(_)(1 - flipped)(1))

          dp(u)(flipped)(dist) = totalFlip.max(dp(u)(flipped)(dist))
        }
      }))
    }

    dfs(0, -1)
    dp.head.head(k)
  }
}
