package leetCode._1000

object Solution_991 {
  def brokenCalc(startValue: Int, target: Int): Int = {
    @scala.annotation.tailrec
    def dfs(x: Int, y: Int, cnt: Int): Int =
      if (x > y) x - y + cnt
      else if (x == y) cnt
      else if (y % 2 == 0) dfs(x, y / 2, cnt + 1)
      else dfs(x, y + 1, cnt + 1)

    dfs(startValue, target, 0)
  }
}
