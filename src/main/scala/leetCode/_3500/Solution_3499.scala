package leetCode._3500

object Solution_3499 {
  def maxActiveSectionsAfterTrade(s: String): Int = {
    val groups = s.foldRight(List.empty[(Char, Int)]) {
      case (ch, (c, n) :: tail) if c == ch => (c, n + 1) :: tail
      case (ch, acc) => (ch, 1) :: acc
    }

    groups.foldLeft((0, 0, Option.empty[Int])) {
      case ((sum, maxZero, pre0), ('1', cnt)) => (sum + cnt, maxZero, pre0)
      case ((sum, maxZero, Some(p0)), ('0', cnt)) => (sum, maxZero.max(p0 + cnt), Some(cnt))
      case ((sum, maxZero, None), ('0', cnt)) => (sum, maxZero, Some(cnt))
      case (state, _) => state
    } match {
      case (ans, mx, _) => ans + mx
    }
  }
}
