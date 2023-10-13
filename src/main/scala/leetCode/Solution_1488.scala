package leetCode

import scala.collection.mutable

object Solution_1488 {
  def avoidFlood(rains: Array[Int]): Array[Int] = {
    val n = rains.length
    val fullLakes = mutable.Map.empty[Int, Int]
    val dryDays = mutable.Set.empty[Int]
    val res = Array.fill(n)(0)
    rains.indices.foreach(i =>
      if (rains(i) == 0) {
        dryDays += i
        res(i) = 1
      } else {
        val lake = rains(i)
        if (fullLakes.contains(lake)) {
          val dryDay = dryDays.find(_ > fullLakes(lake)).getOrElse(-1)
          if (dryDay == -1) return Array.empty
          res(dryDay) = lake
          dryDays -= dryDay
        }
        fullLakes(lake) = i
        res(i) = -1
      })

    dryDays.foreach(day => res(day) = 1)
    res
  }
}
