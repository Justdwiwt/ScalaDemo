package leetCode._1800

import scala.collection.mutable

object Solution_1711 {
  def countPairs(deliciousness: Array[Int]): Int = {
    var m = mutable.HashMap.empty[Int, Long]
    var res = 0L
    deliciousness.foreach(d => {
      (0 to 21).foreach(i => res = (res + m.getOrElse((1 << i) - d, 0L)) % 1000000007)
      m += d -> (m.getOrElse(d, 0L) + 1)
    })
    res.toInt
  }
}
