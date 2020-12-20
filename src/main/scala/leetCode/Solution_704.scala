package leetCode

object Solution_704 {
  def search(nums: Array[Int], target: Int): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int): Int =
      if (l > r) -1
      else {
        val m = (l + r) >>> 1
        nums(m).compareTo(target) match {
          case 0 => m
          case x if x < 0 => f(m + 1, r)
          case _ => f(l, m - 1)
        }
      }

    f(0, nums.length - 1)
  }
}
