package leetCode

object Solution_1785 {
  def minElements(nums: Array[Int], limit: Int, goal: Int): Int = {
    val sum = nums.map(_.toLong).sum
    val needed = (goal.toLong - sum).abs
    if (needed == 0) 0
    else {
      val res = needed / limit.toLong
      val extra = if (needed % limit.toLong == 0) 0L else 1L
      (res + extra).toInt
    }
  }
}
