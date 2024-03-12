package leetCode._2000

object Solution_1957 {
  def makeFancyString(s: String): String = {
    val (state, tail) = s.toList.splitAt(2)
    if (tail.isEmpty) s
    else tail
      ./:(state.reverse) {
        case (res@a :: b :: _, c) if a == b & b == c => res
        case (res, c) => c :: res
      }
      .reverse
      .mkString
  }
}
