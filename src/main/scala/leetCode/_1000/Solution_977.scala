package leetCode._1000

object Solution_977 {
  def sortedSquares(A: Array[Int]): Array[Int] = {
    A.map(i => i * i).sorted
  }
}
