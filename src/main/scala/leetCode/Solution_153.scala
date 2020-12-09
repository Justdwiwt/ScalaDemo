package leetCode

object Solution_153 {
  def findMin(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(data: Array[Int], lo: Int, hi: Int): Int = (lo, hi) match {
      case (l, h) if h < l => data(0)
      case (l, h) if l == h => data(l)
      case (l, h) => l + (h - l) / 2 match {
        case m if m < h && data(m + 1) < data(m) => data(m + 1)
        case m if l < m && data(m) < data(m - 1) => data(m)
        case m if data(m) < data(h) => f(data, l, m - 1)
        case m => f(data, m + 1, h)
      }
    }

    f(nums, 0, nums.length - 1)
  }
}
