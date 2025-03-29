package leetCode._3500

object Solution_3449 {
  def maxScore(points: Array[Int], m: Int): Long = {
    def check(low: Long): Boolean = {
      @scala.annotation.tailrec
      def rec(i: Int, rem: Long, pre: Long): Boolean =
        if (i >= points.length) true
        else {
          val p = points(i).toLong
          val needed = ((low - 1) / p + 1) - pre
          if (i == points.length - 1 && needed <= 0) true
          else {
            val k = if (needed < 1) 1L else needed
            val newRem = rem - (k * 2 - 1)
            if (newRem < 0) false
            else rec(i + 1, newRem, k - 1)
          }
        }

      rec(0, m.toLong, 0L)
    }

    @scala.annotation.tailrec
    def bs(left: Long, right: Long): Long =
      if (left + 1 >= right) left
      else {
        val mid = (left + right) / 2
        if (check(mid)) bs(mid, right)
        else bs(left, mid)
      }

    val left0 = 0L
    val right0: Long = ((m + 1L) / 2L) * points.min + 1
    bs(left0, right0)
  }
}
