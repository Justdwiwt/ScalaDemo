package leetCode._2800

object Solution_2760 {
  def longestAlternatingSubarray(nums: Array[Int], threshold: Int): Int = Iterator
    .iterate((0, 0, 0)) { case (mx, cur, i) =>
      if (nums(i) > threshold) (mx, 0, i + 1)
      else {
        val newLen =
          if (cur == 0) if (nums(i) % 2 == 0) 1 else 0
          else if (nums(i) % 2 == nums(i - 1) % 2)
            if (nums(i) % 2 == 0) 1
            else 0
          else cur + 1
        (mx.max(newLen), newLen, i + 1)
      }
    }
    .dropWhile { case (_, _, i) => i < nums.length }
    .next()
    ._1
}
