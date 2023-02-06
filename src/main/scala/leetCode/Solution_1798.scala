package leetCode

object Solution_1798 {
  def getMaximumConsecutive(coins: Array[Int]): Int = coins
    .sorted
    ./:(1)((acc, cur) => if (acc >= cur) acc + cur else return acc)
}
