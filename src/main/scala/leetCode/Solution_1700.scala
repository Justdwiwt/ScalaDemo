package leetCode

object Solution_1700 {
  def countStudents(students: Array[Int], sandwiches: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(sandwiches: Array[Int], n1: Int, n0: Int): Int =
      if (n1 < 0 || n0 < 0) n1.max(n0)
      else if (sandwiches.isEmpty) 0
      else if (sandwiches.head == 0) f(sandwiches.tail, n1, n0 - 1)
      else f(sandwiches.tail, n1 - 1, n0)

    f(sandwiches, students.sum, students.length - students.sum)
  }
}
