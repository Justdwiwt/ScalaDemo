package leetCode

object Solution_2952 {
  def minimumAddedCoins(coins: Array[Int], target: Int): Int = {
    val sorted = coins.sorted

    @scala.annotation.tailrec
    def f(miss: Long, i: Int, res: Int): Int = {
      if (miss > target) res
      else if (i < sorted.length && sorted(i) <= miss) f(miss + sorted(i), i + 1, res)
      else f(miss + miss, i, res + 1)
    }

    f(1L, 0, 0)
  }
}
