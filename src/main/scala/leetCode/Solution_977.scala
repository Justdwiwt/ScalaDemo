package leetCode

object Solution_977 {
  def sortedSquares(A: Array[Int]): Array[Int] = {
    A.map(i => i * i).sorted
  }
}
