package leetCode

import scala.collection.mutable

object Solution_447 {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
    var res = 0
    points.indices.foreach(i => {
      var record = new mutable.HashMap[Int, Int]()
      points.indices.foreach(j => {
        if (j != i)
          record += distance(points(i), points(j)) -> (record.getOrElse(distance(points(i), points(j)), 0) + 1)
      })
      record.values.foreach(v => if (v >= 2) res += v * (v - 1))
    })
    res
  }

  def distance(x: Array[Int], y: Array[Int]): Int = {
    (x(0) - y(0)) * (x(0) - y(0)) + (x(1) - y(1)) * (x(1) - y(1))
  }
}
