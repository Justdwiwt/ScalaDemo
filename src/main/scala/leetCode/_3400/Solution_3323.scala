package leetCode._3400

object Solution_3323 {
  def minConnectedGroups(intervals: Array[Array[Int]], k: Int): Int = {
    val sortedIntervals = intervals.sortBy(_.head)
    val refined = scala.collection.mutable.ArrayBuffer[Array[Int]]()

    sortedIntervals.foreach(v =>
      if (refined.isEmpty || refined.last(1) < v.head) refined.append(v)
      else {
        val cur = refined.remove(refined.length - 1)
        refined.append(Array(cur.head, cur(1).max(v(1))))
      })

    val toSearch = refined.map(_.head).toArray
    refined.zipWithIndex.map { case (v, k1) =>
      val pos = java.util.Arrays.binarySearch(toSearch, v(1) + k)
      val idx = if (pos < 0) -pos - 1 else pos
      refined.length - idx + k1 + 1
    }.min
  }
}
