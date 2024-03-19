package leetCode._2200

object Solution_2193 {
  def minMovesToMakePalindrome(s: String): Int = {
    @scala.annotation.tailrec
    def dfs(s: String, res: Int): Int =
      if (s.isEmpty) res
      else {
        val idx = s.indexOf(s.last)
        if (idx == s.length - 1) dfs(s.dropRight(1), res + idx / 2)
        else dfs(s.patch(idx, Nil, 1).dropRight(1), res + idx)
      }

    dfs(s, 0)
  }
}
