package leetCode._2900

object Solution_2892 {
  def minArrayLength(nums: Array[Int], k: Int): Int = {
    if (nums.contains(0)) return 1

    nums
      .drop(1)
      .foldLeft((nums.head.toLong, nums.length)) { case ((product, count), x) =>
        val newProduct = product * x
        if (newProduct <= k) (newProduct, count - 1)
        else (x, count)
      }
      ._2
  }
}
