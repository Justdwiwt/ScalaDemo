package leetCode._2400

object Solution_2367 {
  def arithmeticTriplets(nums: Array[Int], diff: Int): Int = (nums ++ nums.map(_ + diff) ++ nums.map(_ + diff + diff))
    .groupBy(identity)
    .mapValues(_.length)
    .count(_._2 == 3)
}
