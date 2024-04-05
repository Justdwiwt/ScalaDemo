package leetCode._500

object Solution_446 {
  def numberOfArithmeticSlices(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(i: Int, j: Int, map: Map[(Int, Long), Int], acc: Int): Int = {
      lazy val diff = nums(i).toLong - nums(j)
      lazy val iCnt = map.getOrElse((i, diff), 0)
      lazy val jCnt = map.getOrElse((j, diff), 0)
      lazy val newMap = map.updated((i, diff), iCnt + 1 + jCnt)
      if (i >= nums.length) acc
      else if (j >= i) f(i + 1, 0, map, acc)
      else f(i, j + 1, newMap, acc + jCnt)
    }

    f(1, 0, Map(), 0)
  }
}
