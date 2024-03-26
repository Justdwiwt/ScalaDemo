package leetCode._1500

object Solution_1433 {
  def checkIfCanBreak(s1: String, s2: String): Boolean = {
    val zipped = s1.sorted.zip(s2.sorted)
    zipped.forall { case (c1, c2) => c1 <= c2 } || zipped.forall { case (c1, c2) => c1 >= c2 }
  }
}
