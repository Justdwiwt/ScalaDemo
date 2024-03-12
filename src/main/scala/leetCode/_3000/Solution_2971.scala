package leetCode._3000

object Solution_2971 {
  def largestPerimeter(nums: Array[Int]): Long = {
    val sorted = nums.sorted
    var res = -1L
    var sum = (sorted.head + sorted(1)).toLong
    sorted.indices.drop(2).foreach(i => {
      if (sum > sorted(i)) res = sum + sorted(i)
      sum += sorted(i)
    })
    res
  }
}
