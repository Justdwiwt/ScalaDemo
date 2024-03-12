package leetCode._2300

import scala.collection.mutable

object Solution_2267 {
  def hasValidPath(grid: Array[Array[Char]]): Boolean = {
    val m = mutable.Map.empty[(Int, Int, Int), Boolean]

    def dfs(x: Int, y: Int, req: Int): Boolean = m.getOrElseUpdate((x, y, req), {
      val balance = if (grid(x)(y) == '(') 1 else -1
      if (req < 0) false
      else if (x + y + 1 < req.abs) false
      else if (x == 0 && y == 0) req == balance
      else if (x == 0) dfs(x, y - 1, req - balance)
      else if (y == 0) dfs(x - 1, y, req - balance)
      else dfs(x - 1, y, req - balance) || dfs(x, y - 1, req - balance)
    })

    dfs(x = grid.length - 1, y = grid.head.length - 1, req = 0)
  }
}
