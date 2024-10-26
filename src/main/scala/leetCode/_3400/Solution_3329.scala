package leetCode._3400

object Solution_3329 {
  def numberOfSubstrings(s: String, k: Int): Long =
    s.foldLeft((Map.empty[Char, Int].withDefaultValue(0), 0, 0L)) {
      case ((cnt, left, res), c) =>
        val updatedCnt = cnt.updated(c, cnt(c) + 1)
        val (newCnt, newLeft) = Stream
          .iterate((updatedCnt, left)) { case (currCnt, l) => (currCnt.updated(s(l), currCnt(s(l)) - 1), l + 1) }
          .dropWhile { case (currCnt, _) => currCnt(c) >= k }
          .head

        (newCnt, newLeft, res + newLeft)
    }._3
}
