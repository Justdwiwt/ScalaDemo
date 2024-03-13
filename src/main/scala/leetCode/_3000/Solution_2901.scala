package leetCode._3000

import scala.collection.mutable

object Solution_2901 {
  def getWordsInLongestSubsequence(n: Int, words: Array[String], groups: Array[Int]): List[String] = {
    def isValid(i: Int, j: Int): Boolean = {
      if (groups(i) == groups(j)) false
      else if (words(i).length != words(j).length) false
      else words(i).zip(words(j)).count { case (c1, c2) => c1 != c2 } == 1
    }

    val m = mutable.Map.empty[(Int, Int), Seq[String]]

    def dfs(prev: Int, i: Int): Seq[String] = m.getOrElseUpdate((prev, i), {
      if (i == n) Seq.empty
      else {
        val pick = if (prev == -1 || isValid(prev, i)) words(i) +: dfs(i, i + 1) else Seq.empty
        val skip = dfs(prev, i + 1)
        if (pick.length > skip.length) pick else skip
      }
    })

    dfs(prev = -1, i = 0).toList
  }
}
