package leetCode._1500

object Solution_1465 {
  def maxArea(h: Int, w: Int, horizontalCuts: Array[Int], verticalCuts: Array[Int]): Int = {
    def f(cuts: Array[Int], bound: Int): Long = (0 +: cuts :+ bound)
      .sorted
      .sliding(2)
      .map { case Array(l, h) => h - l }
      .max

    ((f(horizontalCuts, h) * f(verticalCuts, w)) % 1000000007).toInt
  }
}
