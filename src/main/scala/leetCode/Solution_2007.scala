package leetCode

import scala.collection.mutable

object Solution_2007 {
  def findOriginalArray(changed: Array[Int]): Array[Int] = {
    val sorted = changed.sorted
    if (sorted.length % 2 != 0) return Array.empty
    val freq = mutable.Map.empty ++ sorted.groupBy(identity).mapValues(_.length)
    var res = List.empty[Int]
    sorted.foreach(num => if (freq.getOrElse(num, 0) != 0) {
      val double = num * 2
      if (freq.getOrElse(double, 0) != 0) {
        freq(num) -= 1
        freq(double) -= 1
        res = num :: res
      } else return Array.empty
    })
    if (freq.values.toSet.size != 1) return Array.empty
    res.toArray
  }
}
