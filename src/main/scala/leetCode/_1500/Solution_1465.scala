package leetCode._1500

object Solution_1465 {
  def maxArea(h: Int, w: Int, horizontalCuts: Array[Int], verticalCuts: Array[Int]): Int = {
    val hSorted = horizontalCuts.sorted
    val vSorted = verticalCuts.sorted
    val mh = maxCut(hSorted, h).toLong
    val mv = maxCut(vSorted, w).toLong
    (((mh % 1000000007) * (mv % 1000000007)) % 1000000007).toInt
  }

  def maxCut(array: Array[Int], s: Int): Int = 0.to(array.length).map(x => {
    if (x == 0) array(0)
    else if (x == array.length) s - array(x - 1)
    else array(x) - array(x - 1)
  }).max
}
