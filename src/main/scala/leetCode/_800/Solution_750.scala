package leetCode._800

object Solution_750 {
  def countCornerRectangles(grid: Array[Array[Int]]): Int = {
    if (grid.length == 1) return 0
    val res = grid.indices.flatMap(r1 => {
      (r1 + 1 until grid.length).flatMap(r2 => {
        val cnt = grid.head.indices.count(j => grid(r1)(j) == 1 && grid(r2)(j) == 1)
        Seq(cnt * (cnt - 1) / 2)
      })
    }).sum
    res
  }
}
