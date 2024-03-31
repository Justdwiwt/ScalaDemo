package leetCode._1000

import scala.collection.mutable

object Solution_983 {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val m = mutable.Map.empty[Seq[Int], Int]

    def f(rem: Seq[Int]): Int =
      if (rem.isEmpty) 0
      else if (m.contains(rem)) m(rem)
      else {
        val rc = List(1, 7, 30)
          .zipWithIndex
          .map { case (ds, idx) => costs(idx) + f(rem.dropWhile(_ < rem.head + ds)) }
          .min
        m += (rem -> rc)
        rc
      }

    f(days.toList)
  }
}
