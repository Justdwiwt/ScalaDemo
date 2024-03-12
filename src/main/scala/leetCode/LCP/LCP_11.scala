package leetCode.LCP

import scala.util.control.Breaks._

object LCP_11 {
  def expectNumber(scores: Array[Int]): Int = {
    val s = scores.sorted
    var res = 1
    var t = s(0)
    (1 until s.length).foreach(i => {
      breakable {
        if (s(i) == t) break()
        else {
          res += 1
          t = s(i)
        }
      }
    })
    res
  }
}
