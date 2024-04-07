package leetCode._300

object Solution_252 {
  def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = intervals
    .sortBy(_.head)
    .sliding(2)
    .forall {
      case Array(_) => true
      case Array(a, b) => a(1) <= b.head
    }
}
