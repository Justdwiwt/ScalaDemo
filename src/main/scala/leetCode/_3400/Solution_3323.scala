package leetCode._3400

object Solution_3323 {
  def minConnectedGroups(intervals: Array[Array[Int]], k: Int): Int = {
    val sorted = intervals.sortBy(a => (a.head, -a(1)))

    val mergedIntervals = sorted.foldLeft(Vector[Array[Int]]())((acc, cur) => acc match {
      case Vector() => Vector(cur)
      case prev +: rest if cur.head <= prev(1) =>
        val merged = Array(prev.head, prev(1).max(cur(1)))
        merged +: rest
      case _ => cur +: acc
    }).reverse

    val size = mergedIntervals.length

    mergedIntervals.indices.foldLeft(size)((minGroups, idx) => {
      val nextIndex = binarySearch(mergedIntervals, mergedIntervals(idx)(1) + k + 1)
      minGroups.min(idx + (size - nextIndex) + 1)
    })
  }

  private def binarySearch(mergedIntervals: Vector[Array[Int]], minStart: Int): Int = {
    @scala.annotation.tailrec
    def search(low: Int, high: Int): Int =
      if (low >= high) low
      else {
        val mid = low + (high - low) / 2
        if (mergedIntervals(mid).head >= minStart) search(low, mid)
        else search(mid + 1, high)
      }

    search(0, mergedIntervals.size)
  }
}
