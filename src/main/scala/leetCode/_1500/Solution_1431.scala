package leetCode._1500

object Solution_1431 {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] =
    candies.map(_ + extraCandies >= candies.max).toList
}
