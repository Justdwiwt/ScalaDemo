package leetCode

object Solution_1450 {
  def busyStudent(startTime: Array[Int], endTime: Array[Int], queryTime: Int): Int = {
    startTime.zip(endTime).count(i => i._1 <= queryTime && i._2 >= queryTime)
  }
}
