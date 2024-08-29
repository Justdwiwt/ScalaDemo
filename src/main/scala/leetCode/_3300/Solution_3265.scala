package leetCode._3300

object Solution_3265 {
  private def isEqual(num1: Int, num2: Int): Boolean = {
    if (num1 == num2) return true

    @scala.annotation.tailrec
    def check(x: Int, y: Int, dif: Int, first1: Option[Int], first2: Option[Int]): Boolean =
      if (x == 0 && y == 0) dif == 2
      else {
        val a1 = x % 10
        val a2 = y % 10
        if (a1 - a2 != 0) (first1, first2) match {
          case (None, None) => check(x / 10, y / 10, dif + 1, Some(a1), Some(a2))
          case (Some(f1), Some(f2)) => if (f1 != a2 || f2 != a1) false else check(x / 10, y / 10, dif + 1, first1, first2)
          case _ => false
        }
        else check(x / 10, y / 10, dif, first1, first2)
      }

    check(num1, num2, 0, None, None)
  }

  def countPairs(nums: Array[Int]): Int = nums
    .indices
    .flatMap(i => (i + 1 until nums.length)
      .withFilter(j => isEqual(nums(i), nums(j)))
      .map(j => (nums(i), nums(j))))
    .length
}
