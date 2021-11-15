package leetCode

import scala.collection.mutable

object Solution_2070 {
  def maximumBeauty(items: Array[Array[Int]], queries: Array[Int]): Array[Int] = {
    val sorted = items.sortWith((a, b) => a.head < b.head)
    val m = mutable.HashMap.empty[Int, Int]
    val ts = mutable.TreeSet.empty[Int]((a, b) => Integer.compare(a, b))
    queries.foreach(x => ts += x)
    val i = 0
    val len = sorted.length
    var mx = 0
    ts.foreach(q =>
      if (i == len) m += (q -> mx)
      else {
        if (sorted(i).head > q) m += (q -> 0)
        else {
          var j = i
          while (j < len && sorted(j).head <= q) {
            mx = mx.max(sorted(j)(1))
            j += 1
          }
          m += (q -> mx)
        }
      }
    )
    queries.map(m(_))
  }
}
