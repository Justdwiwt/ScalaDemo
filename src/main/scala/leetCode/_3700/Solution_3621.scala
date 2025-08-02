package leetCode._3700

object Solution_3621 {
  def popcountDepth(n: Long, k: Int): Long = {
    if (k == 0) return if (n >= 1) 1L else 0L

    val bits = n.toBinaryString.map(_.asDigit).toVector
    val m = bits.length

    def dfs(i: Int, left1: Int, isLimit: Boolean, memo: Map[(Int, Int, Boolean), Long]): (Long, Map[(Int, Int, Boolean), Long]) = {
      if (i == m) return (if (left1 == 0) 1L else 0L, memo)
      val key = (i, left1, isLimit)
      memo.get(key) match {
        case Some(v) => (v, memo)
        case None =>
          val up = if (isLimit) bits(i) else 1
          val (res, updatedMemo) = (0 to math.min(up, left1)).foldLeft((0L, memo)) {
            case ((acc, mem), d) =>
              val (r, newMem) = dfs(i + 1, left1 - d, isLimit && d == up, mem)
              (acc + r, newMem)
          }
          (res, updatedMemo.updated(key, res))
      }
    }

    def popcountDepths(limit: Int): Vector[Int] = {
      val f = Array.fill(limit + 1)(0)
      (1 to limit).foreach(i => f(i) = f(Integer.bitCount(i)) + 1)
      f.toVector
    }

    val depths = popcountDepths(m)
    val validCounts = (1 to m).filter(depths(_) == k)

    val total = validCounts.foldLeft((0L, Map.empty[(Int, Int, Boolean), Long])) {
      case ((sum, memo), cnt) =>
        val (res, newMemo) = dfs(0, cnt, isLimit = true, memo)
        (sum + res, newMemo)
    }._1

    if (k == 1) total - 1 else total
  }
}
