package leetCode

import scala.collection.mutable

object Solution_1207 {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val s = new mutable.HashSet[Int]()
    val t = new Array[Int](2001)
    arr.foreach(i => t(i + 1000) += 1)
    t.foreach(i => {
      if (i > 0 && s.contains(i)) return false
      s.add(i)
    })
    true
  }
}
