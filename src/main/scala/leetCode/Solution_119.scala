package leetCode

object Solution_119 {
  def getRow(rowIndex: Int): List[Int] = {
    val res = Array.fill(rowIndex + 1)(0)
    res(0) = 1
    (1 to rowIndex).foreach(i => (i to 1 by -1).foreach(j => res(j) += res(j - 1)))
    res.toList
  }
}
