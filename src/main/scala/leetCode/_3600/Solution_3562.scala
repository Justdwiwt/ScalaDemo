package leetCode._3600

object Solution_3562 {
  def maxProfit(n: Int, present: Array[Int], future: Array[Int], hierarchy: Array[Array[Int]], budget: Int): Int = {
    val tree = Array.fill(n)(collection.mutable.ListBuffer[Int]())
    hierarchy.withFilter { case Array(_, _) => true; case _ => false }.foreach { case Array(u, v) => tree(u - 1) += (v - 1) }

    def merge(A: Array[Int], B: Array[Int]): Array[Int] = {
      val C = Array.fill(A.length)(Int.MinValue)
      A.indices
        .withFilter(A(_) != Int.MinValue)
        .foreach(i => (0 until A.length - i)
          .withFilter(B(_) != Int.MinValue)
          .foreach(j => C(i + j) = C(i + j).max(A(i) + B(j))))
      C
    }

    def dfs(u: Int): (Array[Int], Array[Int]) = {
      var dp0 = Array.fill(budget + 1)(Int.MinValue)
      var dp1 = Array.fill(budget + 1)(Int.MinValue)
      dp0(0) = 0
      dp1(0) = 0

      tree(u).foreach(v => {
        val (res0, res1) = dfs(v)
        dp0 = merge(dp0, res0)
        dp1 = merge(dp1, res1)
      })

      val ans0 = dp0.clone()
      val ans1 = dp0.clone()

      val cost = present(u)
      (cost to budget).foreach(b => if (dp1(b - cost) != Int.MinValue) {
        ans0(b) = ans0(b).max(dp1(b - cost) + future(u) - cost)
      })

      val discounted = cost / 2
      (discounted to budget).foreach(b => if (dp1(b - discounted) != Int.MinValue) {
        ans1(b) = ans1(b).max(dp1(b - discounted) + future(u) - discounted)
      })

      (ans0, ans1)
    }

    dfs(0)._1.max
  }
}
