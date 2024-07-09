package leetCode._2600

object Solution_2590 {

  import scala.collection.mutable.ListBuffer

  private case class Task(id: Int, userId: Int, taskDescription: String, dueDate: Int, tags: List[String])

  class TodoList {
    private var taskList: ListBuffer[Task] = ListBuffer.empty
    private var id: Int = 1

    def addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List[String]): Int = {
      val task = Task(id, userId, taskDescription, dueDate, tags)
      id += 1
      taskList += task
      task.id
    }

    def getAllTasks(userId: Int): List[String] = {
      val filteredTasks = taskList.filter(_.userId == userId).sortBy(_.dueDate)
      filteredTasks.map(_.taskDescription).toList
    }

    def getTasksForTag(userId: Int, tag: String): List[String] = {
      val filteredTasks = taskList.filter(task => task.userId == userId && task.tags.contains(tag)).sortBy(_.dueDate)
      filteredTasks.map(_.taskDescription).toList
    }

    def completeTask(userId: Int, taskId: Int): Unit =
      taskList.find(task => task.userId == userId && task.id == taskId).foreach(taskList -= _)
  }
}
