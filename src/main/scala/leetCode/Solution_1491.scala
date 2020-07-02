package leetCode

object Solution_1491 {
  def average(salary: Array[Int]): Double = {
    f(salary.sorted.slice(1, salary.length - 1))
  }

  def f(A: Array[Int]): Double = A.sum.toDouble / A.length
}
