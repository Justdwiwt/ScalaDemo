package leetCode

object Solution_1664 {
  def waysToMakeFair(nums: Array[Int]): Int = {
    val a = Array.fill(nums.length + 1)(0)
    val b = Array.fill(nums.length + 1)(0)
    nums.indices.foreach(i => {
      a(i + 1) = nums(i) - a(i)
      b(i + 1) = nums(nums.length - 1 - i) - b(i)
    })
    nums.indices.count(i => a(i) == b(nums.length - i - 1))
  }
}
