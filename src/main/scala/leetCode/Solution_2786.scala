package leetCode

object Solution_2786 {
  def maxScore(nums: Array[Int], x: Int): Long = {
    val h = nums.head.toLong
    val i = if (h % 2 == 0) (h, h - x) else (h - x, h)
    val (a, b) = nums.tail./:(i) { case ((even, odd), num) => if (num % 2 == 0) (even.max(odd - x) + num, odd) else (even, odd.max(even - x) + num) }
    a.max(b)
  }
}
