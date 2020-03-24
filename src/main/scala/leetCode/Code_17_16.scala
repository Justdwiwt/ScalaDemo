package leetCode

object Code_17_16 {
  def massage(nums: Array[Int]): Int = nums.foldLeft((0, 0)) {
    case ((y, n), t) => (n + t) -> n.max(y)
  } match {
    case (a, b) => a.max(b)
  }
}
