package leetCode._3600

object Solution_3511 {
  def makeArrayPositive(nums: Array[Int]): Int = {
    val (_, res, _, _) = nums.zipWithIndex.foldLeft((Vector(0L), 0, 0L, 0)) {
      case ((s, ans, preMx, j), (x, idx)) =>
        val i = idx + 1
        val cur = s.last + x
        if (i - j > 2 && cur - preMx <= 0) (s :+ 0L, ans + 1, 0L, i)
        else {
          val newPreMx = if (i - j >= 2) preMx.max(s(i - 2)) else preMx
          (s :+ cur, ans, newPreMx, j)
        }
    }
    res
  }
}
