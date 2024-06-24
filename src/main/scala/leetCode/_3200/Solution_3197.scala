package leetCode._3200

object Solution_3197 {
  def minimumSum(grid: Array[Array[Int]]): Int =
    f(grid).min(f(rotate(grid)))

  private def f(grid: Array[Array[Int]]): Int = {
    def area(grid: Array[Array[Int]], l: Int, r: Int): (Int, Int, Int, Int) = {
      var down = 0
      var right = 0
      var up = grid.length
      var left = grid.head.length

      grid.indices.foreach(i => (l until r).foreach(j => if (grid(i)(j) != 0) {
        left = left.min(j)
        right = right.max(j)
        up = up.min(i)
        down = down.max(i)
      }))

      (left, right, up, down)
    }

    def minimumArea(grid: Array[Array[Int]], l: Int, r: Int): Int = {
      val (left, right, up, down) = area(grid, l, r)
      (right - left + 1) * (down - up + 1)
    }

    val (left, right, up, down) = area(grid, 0, grid.head.length)
    var res = Int.MaxValue

    (up + 1 to down).foreach(i => {
      (i + 1 to down).foreach(j => {
        var a = minimumArea(grid.slice(up, i), left, right + 1)
        a += minimumArea(grid.slice(i, j), left, right + 1)
        a += minimumArea(grid.slice(j, down + 1), left, right + 1)
        res = res.min(a)
      })

      (left + 1 to right).foreach(j => {
        var a = minimumArea(grid.slice(up, i), left, right + 1)
        a += minimumArea(grid.slice(i, down + 1), left, j)
        a += minimumArea(grid.slice(i, down + 1), j, right + 1)

        var b = minimumArea(grid.slice(up, i), left, j)
        b += minimumArea(grid.slice(up, i), j, right + 1)
        b += minimumArea(grid.slice(i, down + 1), left, right + 1)

        res = b.min(res.min(a))
      })
    })

    res
  }

  private def rotate(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val n = grid.length
    val m = grid.head.length
    val b = Array.ofDim[Int](m, n)
    grid.indices.foreach(i => grid.head.indices.foreach(j => b(j)(n - 1 - i) = grid(i)(j)))
    b
  }
}
