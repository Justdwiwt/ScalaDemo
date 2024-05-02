package leetCode._1100

object Solution_1064 {
  def fixedPoint(A: Array[Int]): Int = A
    .zipWithIndex
    .find { case (value, index) => value == index }
    .map(_._2)
    .getOrElse(-1)
}
