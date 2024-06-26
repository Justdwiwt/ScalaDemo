package leetCode._100

import scala.collection.mutable

object Solution_44 {
  def isMatch(s: String, p: String): Boolean = {
    val mem = mutable.Map.empty[(Int, Int), Boolean]

    def dfs(i: Int, j: Int): Boolean = mem.getOrElseUpdate((i, j), {
      if (i == s.length) j == p.length || p.substring(j).forall(_ == '*')
      else if (j == p.length) i == s.length
      else if (p(j) == '?') dfs(i + 1, j + 1)
      else if (p(j) == '*') dfs(i + 1, j) || dfs(i, j + 1) || dfs(i + 1, j + 1)
      else s(i) == p(j) && dfs(i + 1, j + 1)
    })

    dfs(i = 0, j = 0)
  }
}
