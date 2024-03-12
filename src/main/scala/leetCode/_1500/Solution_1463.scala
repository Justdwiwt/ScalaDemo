package leetCode._1500

object Solution_1463 {
  def cherryPickup(grid: Array[Array[Int]]): Int = {
    val dp = Array.fill(grid.length, grid.head.length, grid.head.length)(-1)

    def f(i: Int, j: Int, k: Int): Int = {
      if (i == grid.length) 0
      else if (dp(i)(j)(k) >= 0) dp(i)(j)(k)
      else {
        var res = 0
        List(j - 1, j, j + 1).map(j2 => {
          List(k - 1, k, k + 1).map(k2 => {
            if (j2 >= 0 && j2 < grid.head.length && k2 >= 0 && k2 < grid.head.length)
              res = res.max(f(i + 1, j2, k2))
          })
        })
        dp(i)(j)(k) = res + (if (j == k) grid(i)(j) else grid(i)(j) + grid(i)(k))
        dp(i)(j)(k)
      }
    }

    f(0, 0, grid.head.length - 1)
  }
}
