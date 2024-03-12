package leetCode._2500

import scala.collection.mutable

object Solution_2478 {
  def beautifulPartitions(s: String, k: Int, minLength: Int): Int = {
    def prime(ch: Char): Boolean = "2357".contains(ch)

    def jump(atStart: Boolean): Int = if (atStart) minLength - 1 else 1

    val m = mutable.Map.empty[(Int, Boolean, Int), Long]

    def dfs(i: Int, atStart: Boolean, k: Int): Long = m.getOrElseUpdate((i, atStart, k),
      if (i == s.length) if (k == 0) 1 else 0
      else if (i > s.length || k == 0 || (!prime(s(i)) && atStart)) 0
      else if (prime(s(i))) dfs(i + jump(atStart), atStart = false, k)
      else (dfs(i + 1, atStart = true, k - 1) + dfs(i + 1, atStart, k)) % 1000000007
    )

    dfs(i = 0, atStart = true, k).toInt
  }
}
