package leetCode

object Solution_378 {
  def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
    val sorted = matrix.flatten.sorted
    sorted(sorted.length - (sorted.length - k) - 1)
  }
}
