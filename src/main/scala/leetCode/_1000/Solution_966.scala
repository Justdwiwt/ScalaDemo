package leetCode._1000

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_966 {
  def spellchecker(wordlist: Array[String], queries: Array[String]): Array[String] = {
    val m = mutable.Map[String, ListBuffer[String]]()
    val strToIdx = mutable.Map[String, Int]()

    var mn = Integer.MAX_VALUE
    var mx = Integer.MIN_VALUE
    wordlist.indices.foreach(i => {
      val w = wordlist(i)
      if (!strToIdx.contains(w)) strToIdx += w -> i
      val _w = w.toLowerCase
      if (!m.contains(_w)) m += _w -> new ListBuffer[String]()
      m(_w) += w
      mn = mn.min(w.length)
      mx = mx.max(w.length)
    })

    val s = Set('a', 'e', 'i', 'o', 'u')

    def f(query: String): String = {
      if (queries.equals("") | queries.length == 0) return query
      if (strToIdx.contains(query)) return query
      val len = query.length
      if (len < mn || len > mx) return ""
      val _q = query.toLowerCase
      if (m.contains(_q)) return m(_q).head

      val isVisited = mutable.Set[String]()
      val q = mutable.Queue[(String, Int)]()

      q += ((_q, 0))
      var idx = -1
      var res = ""
      while (q.nonEmpty) {
        val cur = q.dequeue()
        if (!isVisited.contains(cur._1)) {
          if (m.contains(cur._1))
            if (idx == -1 || strToIdx(m(cur._1).head) < idx) {
              idx = strToIdx(m(cur._1).head)
              res = m(cur._1).head
            }
          isVisited += cur._1
          (cur._2 until cur._1.length)
            .withFilter(i => s.contains(cur._1.charAt(i)))
            .foreach(i => s.withFilter(c => c != cur._1.charAt(i))
              .foreach(c => q += ((cur._1.substring(0, i) + c + cur._1.substring(i + 1), i + 1))))
        }
      }
      res
    }

    queries.map(f)
  }
}
