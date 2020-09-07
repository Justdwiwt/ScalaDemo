package leetCode

import scala.collection.mutable

object Solution_424 {
  def characterReplacement(s: String, k: Int): Int = {
    val q = mutable.Queue[Char]()
    val m = mutable.Map[Char, Int]().withDefaultValue(0)
    var res = 0
    s.foreach(c => {
      q.enqueue(c)
      m(c) += 1
      var needChange = q.length - (if (m.nonEmpty) m.values.max else 0)
      while (needChange > k) {
        m(q.dequeue()) -= 1
        needChange = q.length - (if (m.nonEmpty) m.values.max else 0)
      }
      res = res.max(q.length)
    })
    res
  }
}
