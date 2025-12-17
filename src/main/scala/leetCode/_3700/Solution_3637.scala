package leetCode._3700

object Solution_3637 {
  def isTrionic(nums: Array[Int]): Boolean = {
    val diffs = nums.sliding(2).map { case Array(a, b) => b - a }.toArray

    val inc = diffs.takeWhile(_ > 0).length
    val dec = diffs.drop(inc).takeWhile(_ < 0).length
    val inc2 = diffs.drop(inc + dec).takeWhile(_ > 0).length

    inc > 0 && dec > 0 && inc2 > 0 && inc + dec + inc2 == diffs.length
  }
}
