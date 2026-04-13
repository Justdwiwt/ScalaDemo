package leetCode._3900

object Solution_3854 {
  def makeParityAlternating(nums: Array[Int]): Array[Int] =
    if (nums.length == 1) Array(0, 0)
    else {
      val (gMin, gMax) = (nums.min, nums.max)

      def calc(t: Int): (Int, Int) = nums.zipWithIndex.foldLeft((0, Int.MaxValue, Int.MinValue)) {
        case ((op, mn, mx), (x, i)) =>
          val bad = ((x - i) & 1) != t
          val y =
            if (!bad) x
            else if (x == gMin) x + 1
            else if (x == gMax) x - 1
            else x
          (op + (if (bad) 1 else 0), mn.min(y), mx.max(y))
      } match {
        case (op, mn, mx) => (op, (mx - mn).max(1))
      }

      List(0, 1)
        .map(calc)
        .minBy { case (op, d) => (op, d) }
        .productIterator
        .map(_.asInstanceOf[Int])
        .toArray
    }
}
