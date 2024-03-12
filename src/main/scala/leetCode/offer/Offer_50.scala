package leetCode.offer

import scala.util.control.Breaks._

object Offer_50 {
  def firstUniqChar(s: String): Char = {
    var res = ' '
    breakable {
      s.indices.foreach(i => {
        if (s.indexOf(s(i)) == s.lastIndexOf(s(i))) {
          res = s(i)
          break()
        }
      })
    }
    res
  }
}
