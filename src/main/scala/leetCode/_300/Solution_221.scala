package leetCode._300

object Solution_221 {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix.isEmpty) return 0
    val mem = Array.fill(matrix.length)(Array.fill(matrix.head.length)(0))
    var biggest = 0
    matrix.indices.foreach(r => matrix.head.indices.foreach(c => matrix(r)(c) match {
      case '1' =>
        val cur = checkNeighbors(mem, r, c)
        biggest = biggest.max(cur)
        mem(r)(c) = cur
      case _ => ()
    }))
    math.pow(biggest, 2).toInt
  }

  private def checkNeighbors(mem: Array[Array[Int]], row: Int, col: Int): Int = {
    val neighborLocs = List((0, -1), (-1, -1), (-1, 0)).map { case (rowOffset, colOffset) => (rowOffset + row, colOffset + col) }
    if (neighborLocs.exists { case (r, c) => r < 0 | c < 0 }) 1
    else neighborLocs.map { case (r, c) => mem(r)(c) }.min + 1
  }
}
