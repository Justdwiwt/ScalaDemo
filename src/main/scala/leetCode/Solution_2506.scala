package leetCode

import scala.collection.mutable

object Solution_2506 {
  def similarPairs(words: Array[String]): Int = {
    val m = mutable.HashMap.empty[Int, Int]
    var res = 0
    words.foreach(w => {
      var t = 0
      w.indices.foreach(i => t |= 1 << (w(i) - 'a'))
      res += m.getOrElse(t, 0)
      m += t -> (m.getOrElse(t, 0) + 1)
    })
    res
  }
}
