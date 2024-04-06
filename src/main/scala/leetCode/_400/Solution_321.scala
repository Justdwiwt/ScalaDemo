package leetCode._400

object Solution_321 {
  def maxNumber(nums1: Array[Int], nums2: Array[Int], k: Int): Array[Int] = {
    val (n, m) = (nums1.length, nums2.length)
    ((k - m).max(0) to k.min(n))
      .map(i => merge(maxArray(nums1, i), 0, maxArray(nums2, k - i), 0, k))
      .sortWith((nums1, nums2) => greater(nums1, 0, nums2, 0))
      .head
  }

  private def merge(nums1: Array[Int], i: Int, nums2: Array[Int], j: Int, k: Int): Array[Int] = Iterator
    .iterate((i, j, Array.empty[Int])) { case (i, j, res) =>
      if (greater(nums1, i, nums2, j)) (i + 1, j, res :+ nums1(i))
      else (i, j + 1, res :+ nums2(j))
    }
    .dropWhile { case (i, j, _) => i + j < k }
    .next()
    ._3

  private def greater(nums1: Array[Int], i: Int, nums2: Array[Int], j: Int): Boolean = Iterator
    .iterate((i, j)) { case (i, j) => (i + 1, j + 1) }
    .dropWhile { case (i, j) => i < nums1.length && j < nums2.length && nums1(i) == nums2(j) }
    .next() match {
    case (i, j) => j == nums2.length || (i < nums1.length && nums1(i) > nums2(j))
  }

  private def maxArray(nums: Array[Int], k: Int): Array[Int] = nums
    .indices
    .foldLeft(Array.empty[Int])((stack, i) => Iterator
      .iterate(stack)(_.dropRight(1))
      .dropWhile(stack => stack.length + nums.length - i > k && stack.lastOption.exists(_ < nums(i)))
      .next() match {
      case stack => if (stack.length < k) stack :+ nums(i) else stack
    })
}
