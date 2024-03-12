package leetCode._2000

object Solution_1911 {
  def maxAlternatingSum(nums: Array[Int]): Long = {
    var even = 0L
    var odd = 0L
    nums.indices.foreach(i => {
      val newEven = even.max(odd + nums(i))
      odd = odd.max(even - nums(i))
      even = newEven
    })
    even
  }
}
