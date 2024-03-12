package leetCode._2700

object Solution_2643 {
  def rowAndMaximumOnes(mat: Array[Array[Int]]): Array[Int] = mat
    .map(_.count(_ == 1))
    .zipWithIndex
    .map(n => Array(n._2, n._1))
    .minBy(n => (-n(1), n.head))
}
