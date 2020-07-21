package leetCode

object Solution_1478 {
  def minDistance(houses: Array[Int], k: Int): Int = {
    val sorted = houses.sorted
    val dp = Array.ofDim[Int](sorted.length + 1, k + 1)
    (0 to sorted.length).foreach(i => (2 to k).foreach(j => dp(i)(j) += Int.MaxValue))
    (1 to sorted.length).foreach(i => (0 until i).foreach(j => dp(i)(1) += (sorted(j) - sorted(i / 2)).abs))
    (1 until k).foreach(j => (j until sorted.length).foreach(i => (1 to (i + 1 - j)).foreach(x => {
      var y = 0
      ((i + 1 - x) until (i + 1)).foreach(p => y += (sorted(p) - sorted((2 * i - x + 1) / 2)).abs)
      dp(i + 1)(j + 1) = dp(i + 1)(j + 1).min(dp(i + 1 - x)(j) + y)
    })))
    dp(sorted.length)(k)
  }
}
