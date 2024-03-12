package leetCode._1900

object Solution_1898 {
  def maximumRemovals(s: String, p: String, removable: Array[Int]): Int = {
    def isSubsequence(n: Int): Boolean = {
      val removed = removable.iterator.take(n).toSet
      Iterator
        .iterate(0 -> 0) {
          case (i, j) if removed.contains(i) || s(i) != p(j) => (i + 1, j)
          case (i, j) => (i + 1, j + 1)
        }
        .find { case (i, j) => i == s.length || j == p.length }
        .exists(_._2 == p.length)
    }

    @scala.annotation.tailrec
    def search(start: Int, end: Int): Int =
      if (start + 1 == end) start
      else {
        val mid = (start + end) >>> 1
        if (isSubsequence(mid)) search(mid, end) else search(start, mid)
      }

    search(0, removable.length + 1)
  }
}
