package leetCode

object Solution_252 {
  def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
    val sort = intervals.sorted((a: Array[Int], b: Array[Int]) => a(0) - b(0))
    (0 until sort.length - 1).foreach(i => if (sort(i)(1) > sort(i + 1)(0)) return false)
    true
  }
}
