package leetCode

object Solution_1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var map = Map[Int, Int]()
    nums.indices.foreach(i => {
      val complement = target - nums(i)
      if (map.contains(complement)) return Array(map(complement), i)
      else map += (nums(i) -> i)
    })
    Array(0, 0)
  }
}
