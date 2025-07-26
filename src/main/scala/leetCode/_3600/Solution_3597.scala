package leetCode._3600

object Solution_3597 {
  def partitionString(s: String): List[String] = {
    @scala.annotation.tailrec
    def f(start: Int, seen: Set[String], acc: List[String]): List[String] =
      if (start >= s.length) acc.reverse
      else {
        var end = start + 1
        while (end <= s.length && seen.contains(s.substring(start, end)))
          end += 1
        if (end <= s.length) {
          val part = s.substring(start, end)
          f(end, seen + part, part :: acc)
        } else acc.reverse
      }

    f(0, Set.empty, Nil)
  }
}
