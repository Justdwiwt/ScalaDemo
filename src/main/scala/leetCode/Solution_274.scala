package leetCode

object Solution_274 {
  def hIndex(citations: Array[Int]): Int = {
    val sorted = citations.sortWith(_ > _)
    (1 to sorted.length).reverse.foreach(i => if (sorted(i - 1) >= i) return i)
    0
  }
}
