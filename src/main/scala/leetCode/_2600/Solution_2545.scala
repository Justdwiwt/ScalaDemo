package leetCode._2600

object Solution_2545 {
  def sortTheStudents(score: Array[Array[Int]], k: Int): Array[Array[Int]] =
    score.sortBy(-_(k))
}
