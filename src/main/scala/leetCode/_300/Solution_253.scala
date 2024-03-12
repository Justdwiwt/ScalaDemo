package leetCode._300

object Solution_253 {
  def minMeetingRooms(intervals: Array[Array[Int]]): Int = {
    if (intervals.length < 2) return intervals.length
    val sorted = intervals.sorted((a: Array[Int], b: Array[Int]) => a(0) - b(0))
    val pq = new java.util.PriorityQueue[Int]()
    pq.offer(sorted(0)(1))
    (1 until sorted.length).foreach(i => {
      if (sorted(i).head >= pq.peek()) pq.poll()
      pq.offer(sorted(i)(1))
    })
    pq.size
  }
}
