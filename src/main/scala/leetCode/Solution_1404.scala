package leetCode

import scala.util.control.Breaks._

object Solution_1404 {
  def numSteps(s: String): Int = {
    if (s.isEmpty) return 0
    var res = 0
    var cur = 0
    breakable {
      (0 until s.length).reverse.foreach(i => {
        if (i == 0 && cur == 0) break()
        if (s(i) - '0' != cur) {
          cur = 1
          res += 1
        }
        res += 1
      })
    }
    res
  }
}
