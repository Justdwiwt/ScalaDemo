package leetCode._4100

object Solution_4052 {
  def cyclicShift(n: Int, grid: Array[Array[Int]], rowShift: Array[Int], colShift: Array[Int]): Array[Array[Int]] = {
    val mat = grid.zipWithIndex.map {
      case (row, i) =>
        val d = rowShift(i) % n
        row.indices.map(j => row((j + d) % n)).toArray
    }

    mat.transpose.zipWithIndex.foreach {
      case (col, j) =>
        val d = colShift(j) % n
        col.indices.foreach(i => grid(i)(j) = col((i + d) % n))
    }

    grid
  }
}
