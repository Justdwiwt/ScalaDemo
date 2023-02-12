package leetCode

object Solution_2555 {
  def maximizeWin(prizes: Array[Int], k: Int): Int = {
    val dp = Array.fill(prizes.length + 1)(0)
    prizes.indices./:(0, 0) { case ((j, res), i) =>
      val newJ = Iterator.iterate(j)(_ + 1).dropWhile(j => prizes(j) < prizes(i) - k).next()
      dp(i + 1) = dp(i).max(i - newJ + 1)
      (newJ, res.max(i - newJ + 1 + dp(newJ)))
    }._2
  }
}
