package leetCode._1300

object Solution_1267 {
  def countServers(grid: Array[Array[Int]]): Int = {
    var res = 0
    val row = Array.fill(grid.length)(0)
    val col = Array.fill(grid.head.length)(0)
    grid.indices.foreach(i => grid.head.indices.foreach(j =>
      if (grid(i)(j) == 1) {
        row(i) += 1
        col(j) += 1
      }
    ))
    grid.indices.foreach(i => grid.head.indices.foreach(j => if (grid(i)(j) == 1 && (row(i) > 1 || col(j) > 1)) res += 1))
    res
  }
}
