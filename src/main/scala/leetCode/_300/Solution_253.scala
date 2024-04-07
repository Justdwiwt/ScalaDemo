package leetCode._300

object Solution_253 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    if (intervals.length < 2) return intervals.length
    val sorted = intervals.sortBy(_.head)
    val pq = new java.util.PriorityQueue[Int]()
    pq.offer(sorted.head(1))
    sorted.indices.drop(1).foreach(i => {
      if (sorted(i).head >= pq.peek()) pq.poll()
      pq.offer(sorted(i)(1))
    })
    pq.size
  }
}
