package leetCode

import scala.util.control.Breaks._

object Solution_1419 {
  def minNumberOfFrogs(croakOfFrogs: String): Int = {
    var c = 0
    var k = 0
    var r = 0
    var a = 0
    var o = 0
    var res = 0
    croakOfFrogs.indices.foreach(i => {
      croakOfFrogs(i) match {
        case 'c' => c += 1
        case 'r' => r += 1
        case 'o' => o += 1
        case 'a' => a += 1
        case 'k' => k += 1
        case _ =>
      }
      res = (c - k).max(res)
      breakable {
        if (c >= r && r >= o && o >= a && a >= k) break()
        else return -1
      }
    })

    if (c == a && a == o && o == k && r == c) res else -1
  }
}
