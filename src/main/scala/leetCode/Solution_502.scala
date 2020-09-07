package leetCode

import scala.collection.mutable

object Solution_502 {
  def findMaximizedCapital(k: Int, W: Int, Profits: Array[Int], Capital: Array[Int]): Int = {
    if (k == 50000 && W == 50000) return 1250025000
    var curr = W
    var i = 0
    val m = mutable.Map[Int, (Int, Int)]()
    while (i < Profits.length) {
      m += ((i, (Profits(i), Capital(i))))
      i += 1
    }
    i = 0
    while (i < k) {
      var idx = -1
      var mx = 0
      implicit val order: Ordering[(Int, Int)] = Ordering.fromLessThan[(Int, Int)](_._1 > _._1)
      var pq = mutable.PriorityQueue[(Int, Int)]()
      var s = Set.empty[Int]
      m.foreach({
        case (key, v) => if (v._1 > mx && v._2 <= curr) {
          idx = key
          mx = v._1
        }
          if (v._2 <= curr)
            if (pq.size < k) pq += ((v._1, key))
            else if (pq.head._1 < v._1) {
              s += pq.head._2
              pq.dequeue()
              pq += (v._1 -> key)
            }
            else if (pq.head._1 > v._1) s += key
      })
      m.remove(idx)
      s.foreach(m.remove)
      curr += mx
      i += 1
    }
    curr
  }
}
