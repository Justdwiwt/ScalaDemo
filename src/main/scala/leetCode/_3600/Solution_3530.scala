package leetCode._3600

object Solution_3530 {
  def maxProfit(n: Int, edges: Array[Array[Int]], score: Array[Int]): Int =
    if (edges.isEmpty) score.sorted.zipWithIndex.map { case (s, i) => s * (i + 1) }.sum
    else {
      val pre = Array.fill(n)(0)
      edges.foreach { case Array(x, y) => pre(y) |= 1 << x }

      def dfs(state: Int, memo: Map[Int, Int]): (Int, Map[Int, Int]) = {
        memo.get(state) match {
          case Some(v) => (v, memo)
          case None =>
            val i = Integer.bitCount(state) + 1
            val candidates = (0 until n).filter(j => (state >> j & 1) == 0 && (state | pre(j)) == state)

            val (maxRes, updatedMemo) = candidates.foldLeft((0, memo)) {
              case ((curMax, curMemo), j) =>
                val nextState = state | (1 << j)
                val (res, newMemo) = dfs(nextState, curMemo)
                val total = res + score(j) * i
                (curMax max total, newMemo)
            }

            (maxRes, updatedMemo + (state -> maxRes))
        }
      }

      dfs(0, Map.empty)._1
    }
}
