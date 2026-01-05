package leetCode._3800

object Solution_3703 {
  def removeSubstring(s: String, k: Int): String = s
    .foldLeft(List.empty[(Char, Int)])((st, c) => {
      val next = st match {
        case (x, n) :: xs if x == c => (x, n + 1) :: xs
        case _ => (c, 1) :: st
      }

      next match {
        case (')', n1) :: ('(', n2) :: xs if n1 == k && n2 >= k =>
          if (n2 > k) ('(', n2 - k) :: xs else xs
        case _ =>
          next
      }
    })
    .reverse
    .map { case (c, n) => c.toString * n }
    .mkString
}
