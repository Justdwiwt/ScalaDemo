package leetCode._900

object Solution_888 {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val diff = (B.sum - A.sum) / 2
    val bobSet = B.toSet
    A.find(a => bobSet.contains(a + diff)).map(m => Array(m, m + diff)).getOrElse(Array.empty)
  }
}
