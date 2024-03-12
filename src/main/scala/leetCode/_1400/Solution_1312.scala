package leetCode._1400

import scala.collection.mutable

object Solution_1312 {
  def minInsertions(s: String): Int = {
    def mem[I, O](f: I => O): mutable.HashMap[I, O] = new mutable.HashMap[I, O]() {
      override def apply(k: I): O = getOrElseUpdate(k, f(k))
    }

    lazy val dp: ((Int, Int)) => Int = mem {
      case (i, j) if i >= j => 0
      case (i, j) if s(i) == s(j) => dp(i + 1, j - 1)
      case (i, j) => (dp(i + 1, j) + 1).min(dp(i, j - 1) + 1).min(dp(i + 1, j - 1) + 2)
    }

    dp(0, s.length - 1)
  }
}
