package leetCode._4000

object Solution_3952 {
  def maxTotal(nums: Array[Int], s: String): Long =
    nums.zip(s).foldLeft((0L, 0L)) {
      case ((f0, f1), (x, ch)) =>
        if (ch == '0') (f0, f0 + x)
        else (f1.max(f0 + x), f1 + x)
    }._1
}
