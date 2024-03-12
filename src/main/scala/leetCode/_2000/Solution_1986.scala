package leetCode._2000

import scala.Ordering.Implicits._

object Solution_1986 {
  def minSessions(tasks: Array[Int], sessionTime: Int): Int = {
    val allTasks = (1 << tasks.length) - 1

    val time = Array.fill(1 << tasks.length)((Int.MaxValue, 0))
    time(0) = (0, sessionTime)

    (1 to allTasks).foreach(tasksNow => tasks.indices
      .map({ taskIdx => val task = 1 << taskIdx; (taskIdx, task) })
      .withFilter({ case (_, task) => (tasksNow & task) != 0 })
      .foreach({ case (taskIdx, task) =>
        val (sessions, timeInSession) = time(tasksNow - task)
        val timeNow =
          if (timeInSession + tasks(taskIdx) <= sessionTime) (sessions, timeInSession + tasks(taskIdx))
          else (sessions + 1, tasks(taskIdx))
        time(tasksNow) = time(tasksNow).min(timeNow)
      })
    )

    time(allTasks)._1
  }
}
