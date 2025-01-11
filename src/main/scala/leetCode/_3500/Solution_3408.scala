package leetCode._3500

import scala.collection.mutable

object Solution_3408 {
  case class Task(userId: Int, tkId: Int, priority: Int)

  class TaskManager(_tasks: List[List[Int]]) {

    implicit val taskOrdering: Ordering[Task] = Ordering.fromLessThan((t1, t2) => {
      if (t1.priority != t2.priority) t1.priority > t2.priority
      else t1.tkId > t2.tkId
    })

    val st: mutable.TreeSet[Task] = mutable.TreeSet.empty[Task]
    private val taskIdMapping = mutable.Map.empty[Int, Task]

    _tasks.foreach(task => add(task.head, task(1), task(2)))

    private def add(userId: Int, taskId: Int, priority: Int): Unit = {
      val newTask = Task(userId, taskId, priority)
      st.add(newTask)
      taskIdMapping(taskId) = newTask
    }

    def edit(taskId: Int, newPriority: Int): Unit = {
      val previousTask = taskIdMapping(taskId)
      rmv(taskId)
      add(previousTask.userId, previousTask.tkId, newPriority)
    }

    private def rmv(taskId: Int): Unit = {
      val previousTask = taskIdMapping(taskId)
      taskIdMapping.remove(taskId)
      st.remove(previousTask)
    }

    def execTop(): Int =
      if (st.isEmpty) -1
      else {
        val curr = st.head
        rmv(curr.tkId)
        curr.userId
      }
  }
}
