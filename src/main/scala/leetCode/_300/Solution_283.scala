package leetCode._300

object Solution_283 {
  def moveZeroes(nums: Array[Int]): Unit = {
    val cnt = nums.indices./:(0) { case (acc, e) =>
      if (nums(e) != 0) {
        nums(acc) = nums(e)
        acc + 1
      } else acc
    }
    (cnt until nums.length).foreach(i => nums(i) = 0)
  }
}
