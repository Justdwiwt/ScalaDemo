package leetCode._2100

import scala.collection.mutable

object Solution_2062 {
  def countVowelSubstrings(word: String): Int = {
    var cnt = 0
    val diff = Set[Char]('a', 'e', 'i', 'o', 'u')
    (4 until word.length)
      .withFilter(i => diff.contains(word.charAt(i)))
      .foreach(i => {
        var j = i
        val st = mutable.HashSet.empty[Char]
        while (j >= 0 && st.size < 5 && diff.contains(word.charAt(j))) {
          val cur = word.charAt(j)
          st += cur
          j -= 1
        }
        if (st.size == 5) cnt += 1
        while (j >= 0 && diff.contains(word.charAt(j))) {
          cnt += 1
          j -= 1
        }
      })
    cnt
  }
}
