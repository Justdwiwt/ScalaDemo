package leetCode

object Solution_575 {
  def distributeCandies(candies: Array[Int]): Int =
    (candies.length / 2).min(candies.toSet.size)
}
