package leetCode

import scala.collection.mutable

object Solution_690 {

  class Employee() {
    var id = 0
    var importance = 0
    var subordinates = List()
  }

  def getImportance(employees: List[Employee], id: Int): Int = {
    val m = new mutable.HashMap[Int, Employee]()
    employees.foreach(i => m.put(i.id, i))

    def dfs(eid: Int): Int = {
      val employee = m(eid)
      var res = employee.importance
      employee.subordinates.foreach(i => res += dfs(i))
      res
    }

    dfs(id)
  }
}
