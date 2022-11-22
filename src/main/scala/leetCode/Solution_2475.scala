package leetCode

object Solution_2475 {
  def unequalTriplets(nums: Array[Int]): Int = {
    var cnt = 0
    (0 to nums.length - 3)
      .foreach(i => (i + 1 to nums.length - 2)
        .foreach(j => (j + 1 until nums.length)
          .foreach(k => if (nums(i) != nums(j) && nums(j) != nums(k) && nums(k) != nums(i)) cnt += 1)))
    cnt
  }
}
