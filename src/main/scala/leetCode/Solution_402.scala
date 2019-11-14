package leetCode

import scala.util.control.Breaks._

object Solution_402 {
  def removeKdigits(num: String, k: Int): String = {
    var res = num
    var t = k
    while (t > 0) {
      var index = res.length - 1
      breakable {
        (0 until res.length - 1).foreach(i => {
          if (res(i) > res(i + 1)) {
            index = i
            break
          }
        })
      }
      res = res.substring(0, index).concat(res.substring(index + 1))
      t -= 1
    }
    while (res.length > 0 && res(0) == '0') res = res.substring(1)
    if ("".equals(res)) "0" else res
  }
}
