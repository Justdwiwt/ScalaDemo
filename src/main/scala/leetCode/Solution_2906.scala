package leetCode

object Solution_2906 {
  def constructProductMatrix(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val m = grid.length
    val n = grid.head.length
    val M = 12345
    val pre = Array.fill(m * n + 1)(0)
    val suf = Array.fill(m * n + 1)(0)
    pre(0) = 1
    suf(m * n) = 1
    var preSum = 1
    var sufSum = 1
    grid.indices.foreach(i => grid.head.indices.foreach(j => {
      grid(i)(j) %= M
      grid(m - 1 - i)(n - 1 - j) %= M
      preSum = (preSum * grid(i)(j)) % M
      sufSum = (sufSum * grid(m - 1 - i)(n - 1 - j)) % M
      pre(i * n + j + 1) = preSum
      suf((m - 1 - i) * n + n - 1 - j) = sufSum
    }))
    grid.indices.foreach(i => grid.head.indices.foreach(j => {
      val idx = i * n + j
      grid(i)(j) = pre(idx) * suf(idx + 1)
      grid(i)(j) %= M
    }))
    grid
  }
}
