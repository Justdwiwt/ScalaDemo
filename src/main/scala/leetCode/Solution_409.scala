package leetCode

import scala.collection.immutable.HashSet

object Solution_409 {
  def longestPalindrome(s: String): Int = {
    val (cnt, st) = s./:((0, HashSet.empty[Char]))((t, cur) => if (t._2.contains(cur)) (t._1 + 2, t._2 - cur) else (t._1, t._2 + cur))
    cnt + (if (st.nonEmpty) 1 else 0)
  }
}
