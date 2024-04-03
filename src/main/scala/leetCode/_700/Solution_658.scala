package leetCode._700

object Solution_658 {
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
    @scala.annotation.tailrec
    def f(left: Int, right: Int): List[Int] =
      if ((right - left) >= k)
        if ((arr(left) - x).abs > (arr(right) - x).abs) f(left + 1, right)
        else f(left, right - 1)
      else arr.slice(left, right + 1).toList

    f(0, arr.length - 1)
  }
}
