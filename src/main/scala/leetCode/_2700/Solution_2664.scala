package leetCode._2700

object Solution_2664 {
  def tourOfKnight(m: Int, n: Int, r: Int, c: Int): Array[Array[Int]] = {
    val dirs = Array((-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2), (-2, -1))
    val res = Array.ofDim[Int](m, n)
    var solve = false

    def backtrack(x: Int, y: Int, k: Int): Unit = {
      if (k == 0) {
        solve = true
        return
      }
      dirs.foreach { case (dx, dy) =>
        val newX = x + dx
        val newY = y + dy
        if (newX >= 0 && newX < m && newY >= 0 && newY < n && res(newX)(newY) == 0 && !(newX == r && newY == c)) {
          res(newX)(newY) = m * n - k
          backtrack(newX, newY, k - 1)
          if (!solve) res(newX)(newY) = 0
        }
      }
    }

    backtrack(r, c, m * n - 1)
    res
  }
}
