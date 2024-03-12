package leetCode._2200

object Solution_2176 {
  def countPairs(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, j: Int, cnt: Int): Int =
      if (i == nums.length - 1) cnt
      else {
        if (j == nums.length) f(i + 1, i + 2, cnt)
        else if (nums(i) == nums(j) && (i * j % k == 0)) f(i, j + 1, cnt + 1)
        else f(i, j + 1, cnt)
      }

    f(0, 1, 0)
  }
}
