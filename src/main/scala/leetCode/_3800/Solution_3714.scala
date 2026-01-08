package leetCode._3800

object Solution_3714 {
  def longestBalanced(s: String): Int = {
    val n = s.length

    val one = s
      .foldLeft(List.empty[(Char, Int)]) {
        case ((c, k) :: t, x) if c == x => (c, k + 1) :: t
        case (t, x) => (x, 1) :: t
      }
      .map(_._2)
      .reduceOption(_.max(_))
      .getOrElse(0)

    def two(x: Char, y: Char): Int = s
      .indices
      .foldLeft((0, Map(0 -> -1), 0)) {
        case ((ans, pos, d), i) =>
          val c = s(i)
          if (c != x && c != y) (ans, Map(0 -> i), 0)
          else {
            val nd = d + (if (c == x) 1 else -1)
            pos.get(nd) match {
              case Some(p) => (ans max (i - p), pos, nd)
              case None => (ans, pos + (nd -> i), nd)
            }
          }
      }._1

    val twoMax = List(('a', 'b'), ('a', 'c'), ('b', 'c')).map { case (x, y) => two(x, y) }.max


    val three = s
      .indices
      .foldLeft((0, Map((0, 0) -> -1), Map('a' -> 0, 'b' -> 0, 'c' -> 0))) {
        case ((ans, pos, cnt), i) =>
          val c = s(i)
          val ncnt = cnt.updated(c, cnt(c) + 1)
          val key = (ncnt('a') - ncnt('b'), ncnt('b') - ncnt('c'))
          pos.get(key) match {
            case Some(p) => (ans max (i - p), pos, ncnt)
            case None => (ans, pos + (key -> i), ncnt)
          }
      }._1

    one.max(twoMax).max(three)
  }
}
