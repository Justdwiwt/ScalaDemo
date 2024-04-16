package leetCode._2900

object Solution_2852 {
  def sumRemoteness(grid: Array[Array[Int]]): Long = {
    val m = grid.length
    val n = grid.head.length
    val POS = Array((0, -1), (-1, 0))
    var sm = BigInt(0)
    var res = BigInt(0)
    val has = Array.fill(m * n)(BigInt(-1))
    val dc = Array.tabulate(m * n)(identity)

    def find(x: Int): Int = {
      if (dc(x) != x) dc(x) = find(dc(x))
      dc(x)
    }

    grid.indices.foreach(i => grid.head.indices.foreach(j => if (grid(i)(j) > 0) {
      sm += grid(i)(j)
      val x = i * n + j
      dc(x) = x
      has(x) = BigInt(grid(i)(j))
      POS.foreach { case (dx, dy) =>
        val nx = i + dx
        val ny = j + dy
        if (0 <= nx && nx < m && 0 <= ny && ny < n && grid(nx)(ny) > 0) {
          val y = find(nx * n + ny)
          if (x != y) {
            dc(y) = x
            has(x) += has(y)
          }
        }
      }
    }))

    (0 until m * n).foreach(i => if (grid(i / n)(i % n) > 0) res += (sm - has(find(i))))
    res.toLong
  }
}
