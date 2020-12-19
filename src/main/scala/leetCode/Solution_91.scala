package leetCode

import scala.collection.mutable

object Solution_91 {
  def numDecodings(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    val m = mutable.HashMap.empty[Int, Int]

    def f(idx: Int): Int = idx match {
      case i if i == s.length => 1
      case i if s(i) == '0' => 0
      case i if i == s.length - 1 => 1
      case i if m.contains(i) => m(i)
      case i =>
        var res = f(i + 1)
        if (s.substring(i, i + 2).toInt <= 26) res += f(i + 2)
        m += i -> res
        res
    }

    f(0)
  }
}
