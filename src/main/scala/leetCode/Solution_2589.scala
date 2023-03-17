package leetCode

object Solution_2589 {
  private case class Task(start: Int, end: Int, duration: Int)

  def findMinimumTime(tasks: Array[Array[Int]]): Int = {
    val sorted = tasks.collect { case Array(start, end, duration) => Task(start, end, duration) }.sortBy(_.end)
    goFind(sorted.toList, Set.empty)
  }

  @scala.annotation.tailrec
  private def goFind(tasks: List[Task], on: Set[Int]): Int = tasks match {
    case Nil => on.size
    case h :: tail =>
      val newOn = (h.end to(h.start, -1)).filter(!on.contains(_)).take(h.duration)
      goFind(tail.flatMap(minus(_, newOn)), on ++ newOn)
  }

  private def minus(task: Task, newOn: IndexedSeq[Int]): List[Task] =
    if (newOn.head < task.start) List(task)
    else {
      val newDuration = task.duration - newOn.iterator.takeWhile(_ >= task.start).size
      if (newDuration > 0) List(Task(task.start, task.end, newDuration))
      else List.empty
    }
}
