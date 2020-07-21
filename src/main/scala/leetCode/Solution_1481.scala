package leetCode

import scala.collection.mutable

object Solution_1481 {
  def findLeastNumOfUniqueInts(arr: Array[Int], k: Int): Int = {
    val m = new mutable.HashMap[Int, Int]()
    arr.foreach(i => if (!m.contains(i)) m += i -> 1 else m(i) += 1)
    val sorted = m.toArray.sortWith((a, b) => a._2 < b._2).map(x => x._2)
    var size = sorted.length
    var t = k
    sorted.indices.foreach(i => {
      if (t >= sorted(i)) {
        t = t - sorted(i)
        size -= 1
      } else return size
    })
    0
  }
}
