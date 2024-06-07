package leetCode._3200

object Solution_3173 {
  def orArray(nums: Array[Int]): Array[Int] =
    nums.sliding(2).map { case Array(a, b) => a | b }.toArray
}
