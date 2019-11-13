package leetCode

object Solution_944 {
  def minDeletionSize(A: Array[String]): Int = {
    A.map(_.toCharArray).transpose.map(_.mkString).count(i => i != i.sorted)
  }
}
