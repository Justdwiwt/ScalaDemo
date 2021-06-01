package leetCode

import scala.collection.mutable

object Solution_474 {
  def cnt(s: String): (Int, Int) = {
    val m = s.toCharArray.groupBy(identity).mapValues(_.length)
    (m.getOrElse('0', 0), m.getOrElse('1', 0))
  }

  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = mutable.Map.empty[(Int, Int), Int].withDefaultValue(0)
    strs.foreach(s => {
      val (zeros, ones) = cnt(s)
      (zeros to m).reverse.foreach(z =>
        (ones to n).reverse.foreach(o =>
          dp((z, o)) = dp((z, o)).max(dp((z - zeros, o - ones)) + 1)))
    })
    dp((m, n))
  }
}
