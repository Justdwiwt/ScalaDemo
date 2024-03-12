package leetCode._900

object Solution_896 {
  def isMonotonic(A: Array[Int]): Boolean = {
    def f(f: Int => Boolean): Boolean = A.indices.drop(1).forall(i => f(A(i) - A(i - 1)))

    f(_ >= 0) || f(_ <= 0)
  }
}
