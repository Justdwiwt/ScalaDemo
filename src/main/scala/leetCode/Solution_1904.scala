package leetCode

object Solution_1904 {
  def numberOfRounds(startTime: String, finishTime: String): Int = {
    val hourStart = startTime.split(":")(0).toInt
    val minStart = startTime.split(":")(1).toInt
    val hourEnd = finishTime.split(":")(0).toInt
    val minEnd = finishTime.split(":")(1).toInt
    val start = hourStart * 60 + minStart
    val finish = hourEnd * 60 + minEnd
    val round = if (start > finish) 96 else 0
    0.max(finish / 15 - (start + 14) / 15 + round)
  }
}
