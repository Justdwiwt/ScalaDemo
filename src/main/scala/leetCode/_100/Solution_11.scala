package leetCode._100

object Solution_11 {
  def maxArea(height: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(l: Int, r: Int, best: Int): Int = {
      val max = best.max((r - l) * height(l).min(height(r)))
      if (l + 1 == r) max
      else if (height(l) > height(r)) f(l, r - 1, max)
      else f(l + 1, r, max)
    }

    f(0, height.length - 1, 0)
  }
}
