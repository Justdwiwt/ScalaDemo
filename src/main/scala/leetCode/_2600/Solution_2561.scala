package leetCode._2600

import scala.collection.mutable

object Solution_2561 {
  def minCost(basket1: Array[Int], basket2: Array[Int]): Long = {
    val map = mutable.HashMap.empty[Int, Int].withDefaultValue(0)

    basket1.indices.foreach(i => {
      map(basket1(i)) += 1
      map(basket2(i)) -= 1
    })

    var mn = Int.MaxValue
    val buffer = mutable.ArrayBuffer.empty[Int]

    val isOdd = map.exists { case (x, c) =>
      if (c % 2 != 0) true
      else {
        mn = mn.min(x)
        (0 until (c.abs / 2)).foreach(_ => buffer.append(x))
        false
      }
    }

    if (isOdd) return -1

    val sorted = buffer.sorted
    var res = 0L
    (0 until sorted.size / 2).foreach(i => res += sorted(i).min(mn * 2))
    res
  }
}
