package leetCode

import scala.util.control.Breaks._

object Solution_1798 {
  def getMaximumConsecutive(coins: Array[Int]): Int = {
    var res = 0
    val sorted = coins.sorted
    breakable {
      sorted.foreach(v => {
        if (v <= res + 1) res += v
        else break()
      })
    }
    res + 1
  }
}
