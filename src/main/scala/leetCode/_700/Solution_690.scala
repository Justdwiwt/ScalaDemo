package leetCode._700

object Solution_690 {

  class Employee() {
    var id = 0
    var importance = 0
    var subordinates: List[Nothing] = List()
  }

  def getImportance(employees: List[Employee], id: Int): Int = {
    val empLookup = employees./:(Map[Int, Employee]())((m, e) => m + (e.id -> e))

    def dfs(employeeId: Int, acc: Int): Int = {
      val e = empLookup(employeeId)
      e.subordinates./:(e.importance) {
        case (acc, id) =>
          val sub = empLookup(id).importance
          acc + dfs(id, sub)
        case _ => acc
      }
    }

    dfs(id, 0)
  }
}
