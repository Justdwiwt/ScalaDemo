package leetCode._1500

import scala.collection.mutable

object Solution_1405 {
  def longestDiverseString(a: Int, b: Int, c: Int): String = {
    val pq = mutable.PriorityQueue((a, 'a'), (b, 'b'), (c, 'c'))
    var res = ""
    (0 until (a + b + c)).foreach(i => {
      val (cnt, ch) = pq.dequeue()
      if (i >= 2 && ch == res(i - 1) && ch == res(i - 2)) {
        val (nextCnt, nextCh) = pq.dequeue()
        if (nextCnt == 0) return res
        res += nextCh
        pq += ((nextCnt - 1, nextCh))
        pq += ((cnt, ch))
      } else {
        res += ch
        pq += ((cnt - 1, ch))
      }
    })
    res
  }
}
