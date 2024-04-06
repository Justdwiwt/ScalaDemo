package leetCode._400

object Solution_361 {
  def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
    if (grid == null || grid.isEmpty || grid.head.isEmpty) return 0

    var max = 0
    val row = grid.length
    val col = grid.head.length

    def count(i: Int, j: Int): Int = {
      var res = 0

      def checkHorizontal(c: Int, step: Int): Unit = {
        var cur = c
        while (cur >= 0 && cur < col && grid(i)(cur) != 'W') {
          if (grid(i)(cur) == 'E') res += 1
          cur += step
        }
      }

      def checkVertical(r: Int, step: Int): Unit = {
        var cur = r
        while (cur >= 0 && cur < row && grid(cur)(j) != 'W') {
          if (grid(cur)(j) == 'E') res += 1
          cur += step
        }
      }

      checkHorizontal(j - 1, -1)
      checkHorizontal(j + 1, 1)
      checkVertical(i - 1, -1)
      checkVertical(i + 1, 1)

      res
    }

    grid.indices.foreach(i => grid.head.indices.foreach(j => if (grid(i)(j) == '0') max = max.max(count(i, j))))

    max
  }
}
