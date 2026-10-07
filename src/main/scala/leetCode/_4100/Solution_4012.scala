package leetCode._4100

object Solution_4012 {
  def countTasks(tasks: Array[Int], shifts: Array[Int]): Array[Int] = {
    val prefix = tasks.scanLeft(0L)(_ + _).tail
    val total = prefix.last

    def upperBound(x: Long): Int = {
      var l = 0
      var r = prefix.length

      while (l < r) {
        val m = (l + r) >>> 1
        if (prefix(m) <= x) l = m + 1
        else r = m
      }
      l
    }

    shifts.scanLeft((0L, 0)) { case ((t, _), shift) =>
      val next = t + shift

      if (next >= total) (0L, 0)
      else (next, prefix.length - upperBound(next))
    }.tail.map(_._2)
  }
}
