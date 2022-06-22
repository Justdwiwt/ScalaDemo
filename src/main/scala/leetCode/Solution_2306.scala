package leetCode

import scala.collection.mutable

object Solution_2306 {
  def distinctNames(ideas: Array[String]): Long = {
    val st = mutable.HashSet.empty[String]
    val cnt = Array.fill(26, 26)(0)
    ideas.foreach(st.add)
    ideas.indices.foreach(i => (0 until 26).foreach(j => {
      val ch = ('a' + j).toChar
      if (!st.contains(ch + ideas(i).substring(1)))
        cnt(ideas(i).head - 'a')(j) += 1
    }))
    var res = 0L
    (0 until 26).foreach(i => (0 until 26).foreach(j => res += cnt(i)(j) * cnt(j)(i)))
    res
  }
}
