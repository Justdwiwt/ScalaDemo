package leetCode

import scala.util.control.Breaks._

object Solution_1432 {
  def maxDiff(num: Int): Int = {
    val one = 1.toString.charAt(0)
    val zero = 0.toString.charAt(0)
    val nine = 9.toString.charAt(0)
    var flag = true
    var s1 = num.toString
    var s2 = num.toString
    breakable {
      s1.indices.foreach(i => {
        if (i == 0) {
          if (s1(i) == one) flag = false
          else if (s1(i) != nine) {
            s1 = s1.replace(s1(i), nine)
            break()
          }
        } else {
          if ((flag && s1(i) != nine) || (!flag && s1(i) != zero && s1(i) != one)) {
            s1 = if (flag) s1.replace(s1(i), nine) else s1.replace(s1(i), zero)
            break()
          }
        }
      })
    }
    s2 = if (flag) s2.replace(s2(0), one) else s2.replace(s2(0), nine)
    (s1.toInt - s2.toInt).abs
  }
}
