package leetCode

object Solution_1431 {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    val res = Array.fill(candies.length)(false)
    val mx = candies.max
    candies.indices.foreach(i => res(i) = (candies(i) + extraCandies) >= mx)
    res
  }
}
