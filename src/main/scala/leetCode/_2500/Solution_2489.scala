package leetCode._2500

import scala.collection.mutable

object Solution_2489 {
  def fixedRatio(s: String, num1: Int, num2: Int): Long =
    s.foldLeft((0L, (0L, 0L, mutable.Map(0L -> 1L)))) {
      case ((res, (one, zero, map)), i) =>
        val (newOne, newZero) = if (i == '1') (one + 1, zero) else (one, zero + 1)
        val tep = num1 * newOne - num2 * newZero
        val newResult = res + map.getOrElse(tep, 0L)
        map(tep) = map.getOrElse(tep, 0L) + 1
        (newResult, (newOne, newZero, map))
    }._1
}
