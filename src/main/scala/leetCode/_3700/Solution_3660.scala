package leetCode._3700

object Solution_3660 {
  def maxValue(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val pre = nums.scanLeft(Int.MinValue)(_ max _).tail
    val suf = nums.toList.scanRight(Int.MaxValue)(_ min _).tail.toArray

    nums.indices.foldRight((List[Int](), 0))((i, acc) => {
      val (list, next) = acc
      val cur = if (pre(i) <= suf(i)) pre(i) else next
      (cur :: list, cur)
    })._1.toArray
  }
}
