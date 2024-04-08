package leetCode._200

object Solution_164 {
  def maximumGap(nums: Array[Int]): Int = {
    if (nums.length < 2) return 0
    val sorted = nums.sorted
    sorted.tail.foldLeft(sorted.head, 0)((acc, num) => {
      val maxDiff = num - acc._1
      (num, acc._2.max(maxDiff))
    })._2
  }
}
