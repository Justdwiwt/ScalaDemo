package leetCode._4100

object Solution_4054 {
  def shadowPairs(nums: Array[Int]): Long = {
    @scala.annotation.tailrec
    def pop(stack: List[(Int, Long)], size: Long, x: Int): (List[(Int, Long)], Long) =
      stack match {
        case (v, c) :: tail if v > x =>
          pop(tail, size - c, x)
        case _ => (stack, size)
      }

    nums.foldLeft((List((0, 0L)), 0L, 0L)) {
      case ((stack, size, ans), x) =>
        val (st, sz) = pop(stack, size, x)

        st match {
          case (`x`, c) :: tail =>
            ((x, c + 1) :: tail, sz + 1, ans + sz - c)
          case _ =>
            ((x, 1L) :: st, sz + 1, ans + sz)
        }
    }._3
  }
}
