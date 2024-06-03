package leetCode._3200

object Solution_3169 {
  def countDays(days: Int, meetings: Array[Array[Int]]): Int = {
    val sortedMeetings = meetings.sortBy(_.head)

    val (remainingDays, (lastStart, lastEnd)) = sortedMeetings.foldLeft((days, (1, 0))) {
      case ((remainingDays, (start, end)), meeting) =>
        val (meetingStart, meetingEnd) = (meeting.head, meeting(1))
        if (meetingStart > end) {
          val newRemainingDays = remainingDays - (end - start + 1)
          (newRemainingDays, (meetingStart, meetingEnd))
        } else (remainingDays, (start, end.max(meetingEnd)))
    }

    remainingDays - (lastEnd - lastStart + 1)
  }
}
