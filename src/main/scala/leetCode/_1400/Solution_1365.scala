package leetCode._1400

object Solution_1365 {
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    nums.map(i => nums.count(_ < i))
  }
}
