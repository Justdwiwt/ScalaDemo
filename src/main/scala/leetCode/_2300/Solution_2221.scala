package leetCode._2300

object Solution_2221 {
  @scala.annotation.tailrec
  def triangularSum(nums: Array[Int]): Int =
    if (nums.length == 1) nums.head
    else {
      val arr = Array.fill(nums.length - 1)(0)
      arr.indices.foreach(i => arr(i) = (nums(i) + nums(i + 1)) % 10)
      triangularSum(arr)
    }
}
