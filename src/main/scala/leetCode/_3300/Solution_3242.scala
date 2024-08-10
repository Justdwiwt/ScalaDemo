package leetCode._3300

object Solution_3242 {
  class neighborSum(grid: Array[Array[Int]]) {
    private val dirs: Array[(Int, Int)] = Array((-1, 0), (1, 0), (0, -1), (0, 1), (1, 1), (-1, 1), (-1, -1), (1, -1))

    private val arr: Array[Array[Int]] = {
      val n = grid.length
      Array.fill(n * n)(Array(0, 0))
    }

    grid.indices.foreach(i => {
      grid.indices.foreach(j => {
        val v = grid(i)(j)
        dirs.zipWithIndex.foreach { case ((dx, dy), k) =>
          val (x, y) = (i + dx, j + dy)
          if (x >= 0 && x < grid.length && y >= 0 && y < grid.length)
            arr(v)(k / 4) += grid(x)(y)
        }
      })
    })

    def adjacentSum(value: Int): Int = arr(value).head

    def diagonalSum(value: Int): Int = arr(value)(1)
  }
}
