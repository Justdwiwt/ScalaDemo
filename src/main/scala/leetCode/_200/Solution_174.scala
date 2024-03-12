package leetCode._200

object Solution_174 {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val dp = Array.ofDim[Int](dungeon.length + 1, dungeon.head.length + 1)
    (0 to dungeon.length).foreach(i => dp(i) = Array.fill(dp(i).length)(Int.MaxValue))
    dp(dungeon.length)(dungeon.head.length - 1) = 1
    dp(dungeon.length - 1)(dungeon.head.length) = 1
    dungeon.indices.reverse.foreach(i => dungeon.head.indices.reverse.foreach(j => {
      dp(i)(j) = (dp(i + 1)(j).min(dp(i)(j + 1)) - dungeon(i)(j)).max(1)
    }))
    dp.head.head
  }
}
