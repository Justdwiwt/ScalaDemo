package leetCode

import scala.collection.mutable

object Solution_13 {
  def romanToInt(s: String): Int = {
    val map: mutable.Map[String, Int] = mutable.Map("I" -> 1, "V" -> 5, "X" -> 10, "L" -> 50, "C" -> 100, "D" -> 500, "M" -> 1000)
    var res = map(s.last.toString)
    for (i <- s.length - 2 to 0 by (-1))
      if (map(s(i).toString) < map(s(i + 1).toString)) res += -map(s(i).toString)
      else res += map(s(i).toString)
    res
  }
}
