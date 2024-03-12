package leetCode._1100

object Solution_1099 {
  def twoSumLessThanK(nums: Array[Int], k: Int): Int = {
    var mx = -1
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => {
      val sum = nums(i) + nums(j)
      if (sum < k && sum > mx) mx = sum
    }))
    mx
  }
}
