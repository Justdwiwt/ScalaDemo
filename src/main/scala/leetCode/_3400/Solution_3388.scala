package leetCode._3400

object Solution_3388 {
  def beautifulSplits(nums: Array[Int]): Int = {
    val n = nums.length
    val arr = Array.fill(n + 1, n + 1)(0)

    (n - 2 to 0 by -1).foreach(i => (n - 1 to i + 1 by -1).foreach(j => if (nums(i) == nums(j)) arr(i)(j) = arr(i + 1)(j + 1) + 1))

    def isBeautifulSplit(i: Int, j: Int): Boolean = {
      val len1 = i + 1
      val len2 = j - i
      val len3 = n - 1 - j

      (len1 <= len2 && arr(0)(i + 1) >= len1) || (len2 <= len3 && arr(i + 1)(j + 1) >= len2)
    }

    nums.indices.flatMap(i =>
      (i + 1 until nums.length)
        .withFilter(_ + 1 < nums.length)
        .withFilter(isBeautifulSplit(i, _))
        .map(_ => 1)
    ).sum
  }
}
