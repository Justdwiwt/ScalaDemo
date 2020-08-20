package leetCode

object Solution_416 {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if ((sum & 1) > 0) false
    else {
      val x = nums.sortBy(a => -a)
      val t = sum / 2

      def f(idx: Int, target: Int): Boolean = {
        if (x(idx) > target) false
        else if (x(idx) < target) {
          (idx + 1 until x.length).foreach(i => if (f(i, target - x(idx))) return true)
          false
        } else true
      }

      f(0, t)
    }
  }
}
