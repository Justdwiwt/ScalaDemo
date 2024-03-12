package leetCode._2900

import scala.collection.mutable

object Solution_2857 {
  def countPairs(coordinates: List[List[Int]], k: Int): Int = {
    var res = 0
    val m = mutable.HashMap.empty[(Int, Int), Int].withDefaultValue(0)
    coordinates.foreach(coordinate => {
      val x = coordinate.head
      val y = coordinate(1)
      (0 to k).foreach(i => res += m((x ^ i, y ^ (k - i))))
      m((x, y)) += 1
    })
    res
  }
}
