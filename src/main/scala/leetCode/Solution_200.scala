package leetCode

object Solution_200 {
  def numIslands(grid: Array[Array[Char]]): Int = {
    if (grid.isEmpty) 0
    else {
      val x = grid.length
      val y = grid.head.length
      var res = grid.map(row => row.count(_ == '1')).sum

      val parent = (0 until x * y).toArray

      def left(i: Int, j: Int) = j - 1 >= 0

      def right(i: Int, j: Int) = j + 1 < y

      def up(i: Int, j: Int) = i - 1 >= 0

      def down(i: Int, j: Int) = i + 1 < x

      @annotation.tailrec
      def root(p: Int): Int = {
        if (p != parent(p)) {
          parent(p) = parent(parent(p))
          root(parent(p))
        }
        else p
      }

      def union(p: Int, q: Int): Unit = {
        val rootP = root(p)
        val rootQ = root(q)
        if (rootP != rootQ) {
          parent(rootP) = rootQ
          res -= 1
        }
      }

      (0 until x).foreach(row => (0 until y).withFilter(col => grid(row)(col) == '1').foreach(col => {
        val p = row * y + col
        if (left(row, col) && grid(row)(col - 1) == '1') union(p, row * y + (col - 1))
        if (right(row, col) && grid(row)(col + 1) == '1') union(p, row * y + (col + 1))
        if (up(row, col) && grid(row - 1)(col) == '1') union(p, (row - 1) * y + col)
        if (down(row, col) && grid(row + 1)(col) == '1') union(p, (row + 1) * y + col)
      }))
      res
    }
  }
}
