package leetCode._2500

object Solution_2446 {
  def haveConflict(event1: Array[String], event2: Array[String]): Boolean =
    event1.head <= event2(1) && event2.head <= event1(1)
}
