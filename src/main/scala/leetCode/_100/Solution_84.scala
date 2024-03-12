package leetCode._100

object Solution_84 {
  def largestRectangleArea(heights: Array[Int]): Int = {
    val seq = heights.toSeq :+ 0
    seq.zipWithIndex./:(
      (List.empty[(Int, Int, Int)], seq.head))({
      case ((stack, mxH), (h, idx)) =>
        val (hi, lo) = stack.span(_._1 > h)
        val newMx = hi.map(Function.tupled((h: Int, lo: Int, _: Int) => (idx - lo) * h)).fold(mxH)(math.max)
        val newLo = lo.headOption.map(_._3 + 1).getOrElse(0)
        ((h, newLo, idx) :: lo, newMx)
    })._2
  }
}
