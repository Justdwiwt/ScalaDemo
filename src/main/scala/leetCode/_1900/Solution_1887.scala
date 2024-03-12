package leetCode._1900

object Solution_1887 {
  def reductionOperations(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var res = 0
    (0 to nums.length - 2).reverse.foreach(i => if (sorted(i) != sorted(i + 1)) res += nums.length - 1 - i)
    res
  }
}
