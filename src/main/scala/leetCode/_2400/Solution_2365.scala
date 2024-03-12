package leetCode._2400

object Solution_2365 {
  def taskSchedulerII(tasks: Array[Int], space: Int): Long =
    f(tasks.toList, Map.empty, 1, space)

  @scala.annotation.tailrec
  def f(tasks: List[Int], breakMap: Map[Int, Long], day: Long, space: Int): Long = tasks match {
    case Nil => day - 1
    case h :: tail =>
      val breakUntil = breakMap.getOrElse(h, 0L)
      if (day > breakUntil) f(tail, breakMap.updated(h, day + space), day + 1, space)
      else f(tasks, breakMap, breakUntil + 1, space)
  }
}
