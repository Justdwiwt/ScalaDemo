package leetCode

object Solution_402 {
  def removeKdigits(num: String, k: Int): String = {
    @scala.annotation.tailrec
    def f(strAcc: String, recurStr: String, n: Int): String = {
      if (n == 0) strAcc + recurStr
      else if (recurStr.length <= n) strAcc
      else {
        val min = recurStr.take(n + 1).zipWithIndex.minBy(_._1)
        f(strAcc :+ min._1, recurStr.substring(min._2 + 1), n - min._2)
      }
    }

    @scala.annotation.tailrec
    def g(str: String): String = {
      if (str.isEmpty) "0"
      else if (str.head == '0') g(str.tail)
      else str
    }

    g(f("", num, k))
  }
}
