package leetCode._700

object Solution_690 {

  class Employee {
    var id = 0
    var importance = 0
    var subordinates: List[Nothing] = List()
  }

  def getImportance(employees: List[Employee], id: Int): Int = {
    val e = employees.find(_.id == id).get
    e.importance + e.subordinates.map(getImportance(employees, _)).sum
  }
}
