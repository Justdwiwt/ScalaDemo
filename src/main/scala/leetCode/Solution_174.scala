package leetCode

object Solution_174 {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val dp = Array.fill(dungeon(0).length + 1)(Int.MaxValue)
    dp(dungeon(0).length - 1) = 1
    (dp.length - 1 to 0 by -1).foreach(i => (dungeon(0).length - 1 to 0 by -1).foreach(j => dp(j) = math.max(1, math.min(dp(j), dp(j + 1) - dungeon(i)(j)))))
    dp(0)
  }
}
