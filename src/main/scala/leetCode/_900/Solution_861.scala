package leetCode._900

object Solution_861 {
  def matrixScore(A: Array[Array[Int]]): Int = {
    val flipped = A.map(line => if (line.head == 0) line.map(1 - _) else line)
    A.head.indices.map(col => {
      val toggled = flipped.map(_ (col)).sum
      (1 << (A.head.length - col - 1)) * toggled.max(A.length - toggled)
    }).sum
  }
}
